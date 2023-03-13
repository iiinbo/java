package com.kbstar.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kbstar.dto.Cust;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class CustDaoImpl implements DAO<String, String, Cust> {
	Cust cust = new Cust();
	
	// 1. jdbc에서 각각 실행해주던걸, Driver Loading 한번으로 할 수 있다.
	public CustDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return; // 예외상황 발생 시 종료해줘
		}
		System.out.println("Driver Loading 성공!");
	}

	// 2. jdbc에서 각각 실행해주던 커넥션도 한번에 해주자
	// (insert, delete, update 등 커넥션 변수 필요하면 여기서 지정한 getConnection()한번으로 사용가능)
	public Connection getConnection() throws Exception {
		Connection con = null;
		// ip주소 바뀌더라도 아래 프로퍼티 구문 덕분에 반영 가능.
		// 코드 안에 pwd 나 ip주소를 직접 입력하지 않아도 되며, 파일에서 수정되면 함께 가져온다.
		Properties props = new Properties();
		String fileName = "db_info.txt";
		FileInputStream in = new FileInputStream(fileName);
		props.load(in);

		String id = props.getProperty("DB_ID");
		String pwd = props.getProperty("DB_PWD");
		String url = props.getProperty("DB_URL"); // 1521 사용자모드
		con = DriverManager.getConnection(url, id, pwd); // 커넥션 값생성
		
		return con;
	}

	@Override
	public void insert(Cust v) throws Exception { // 객체 들어오면 db에 입력한다.
		try (Connection con = getConnection(); // 커넥션할 때, 한번에 쓰려고 위에서 만든 메소드쓰기!
				PreparedStatement pstmt = con.prepareStatement(Sql.insertSql);) { // sql.java에서 만든거
			// Connection생성과 Statement 생성을 밖이 아니라 try구문 () 안에.
			// try구문 안에 쓰면, *close를 자동으로 실행해준다.*
			pstmt.setString(1, v.getId()); // 자리에 따라 값 세팅.
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setInt(4, v.getAge());
			int result = pstmt.executeUpdate();// 5. 결과 받기// 우리가 위에서 만든 쿼리문을 DB로날린다(업데이트)~ 라는 뜻.
		} catch (SQLException e1) {
			throw e1; // 문제 던지자. app으로
			// e1.printStackTrace();
		}
	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.deleteSql);) {

			pstmt.setString(1, k); // 첫번째 물음표자리에 값 세팅.

			int result = pstmt.executeUpdate();// 5. 결과 받기// 우리가 위에서 만든 쿼리문을 DB로날린다(업데이트)~ 라는 뜻.
			if (result == 0) {
				throw new Exception("삭제할 id가 존재하지 않습니다.");
			}
		} catch (SQLException e1) {
			throw e1; // dao에서 처리 안하고 service로 던져
		}
	}

	@Override
	public void update(Cust v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.updateSql);) {

			// 물음표 자리마다 값 세팅.
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getAge());
			pstmt.setString(4, v.getId());

			int result = pstmt.executeUpdate();// 5. 결과 받기// 우리가 위에서 만든 쿼리문을 DB로날린다(업데이트)~ 라는 뜻.
			if (result == 0) {
				throw new Exception("수정할 내용이 없습니다.");
			}
		} catch (SQLException e1) {
			throw e1;
		}
	}

	@Override
	public Cust select(String k) throws Exception {
		Cust cust = null;
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.selectSql);) {
			
			pstmt.setString(1, k); // 첫번째 물음표자리에 값 세팅.
			try(ResultSet rset = pstmt.executeQuery()) { //셀렉트일 때 : executeQuery()
				rset.next(); //매우중요!!!! 한칸 이동 후 조회가능!
				
				String db_id = rset.getString("id"); //적은 컬럼명의 데이터를 끄집어 내자.
				String db_pwd = rset.getString("pwd");
				String name = rset.getString("name");
				int age = rset.getInt("age");
				cust = new Cust(db_id, db_pwd, name, age);
				System.out.println(db_id+""+name+""+age);
				//조회된 결과는 여기로 : rset 담긴다
				
			} catch(SQLException e1) {
				e1.printStackTrace(); //정상적으로 가져오고 나면  *close를 자동으로 실행해준다.*
			}
		} catch (SQLException e) { //못가져와도  *close를 자동으로 실행해준다.*
			throw e;
		}return cust;
	}

	@Override
	public List<Cust> selectAll() throws Exception {
		List<Cust> list = new ArrayList<Cust>();
		//Collection<Cust> col = db.values();
		
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.updateSql);) {
			
			try(ResultSet rset = pstmt.executeQuery()) { //셀렉트일 때 : executeQuery()
				//전체조회는 한 칸씩 이동해서 데이터 개수만큼 while문이 돌면서 데이터 전부 끄집어낸다.
				while(rset.next()) {//조회된 결과는 여기로 : rset 담긴다
					String db_id = rset.getString("id"); //컬럼의 데이터를 끄집어 내자.
					String db_pwd = rset.getString("pwd");
					String name = rset.getString("name");
					int age = rset.getInt("age");
					System.out.println(db_id+""+name+""+age);
				}

			} catch(SQLException e1) {
				throw e1; //정상적으로 가져오고 나면  *close를 자동으로 실행해준다.*
			}
		} catch (SQLException e) { //못가져와도  *close를 자동으로 실행해준다.*
			throw e;
		}return null;
	}

	@Override
	public List<Cust> search(String k) throws Exception {

		return null;
	}

}
