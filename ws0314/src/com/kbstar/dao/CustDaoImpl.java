package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		//System.out.println("Driver Loading 성공!");
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

	@Override // 에러케이스1 : 조회할 건 없으면 null이라고 나옴, 2 : 서버 죽어도 null
	public Cust select(String k) throws Exception {
		// 셀렉트는 반환할 값 있기에 선언 필수
		Cust cust = null;

		// 1. 정상으로 끝나도 자동으로 close해줄게. try()안에 선언하면.
		// 2. Sql문으로 전송해줄게. try()안에 선언하면.
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectSql);) {
			pstmt.setString(1, k);

			// 문제발생 시 close 자동으로 하기 위해 한번 더 try안에 try문 입력
			// 참고. executeQuery : 데이터를 가져온다.
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next(); // 끄집어내기 전 한칸 이동 후.

				String id = rset.getString("id"); // 끄집어낼 값 : "id"는 컬럼명.
				String pwd = rset.getString("pwd"); // 끄집어낼 값 : "pwd"는 컬럼명.
				String name = rset.getString("name"); // 끄집어낼 값 : "name"는 컬럼명.
				int age = rset.getInt("age"); // 끄집어낼 값 : "age"는 컬럼명.

				cust = new Cust(id, pwd, name, age); // cust 객체 생성이 마지막이다.
			} catch (Exception e) {
				throw e; // 여긴 조회할 데이터 없을 때 발생 구간 -> 에러는 ServiceImpl로 던졌다. 거기서 세부문구
			}

		} catch (Exception e) {
			throw e; // 여긴 네트웤오류 발생구간 -> 에러는 ServiceImpl로 던졌다. 거기서 세부문구
		}
		return cust;
	}

	@Override //에러케이스 1 : 조회할 데이터 없으면 공백으로 처리된다.
	public List<Cust> selectAll() throws Exception {
		List<Cust> list = new ArrayList<>();

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectAllSql);) {
			try (ResultSet rset = pstmt.executeQuery();) {
				// 셀렉트 올은 와일문~
				while (rset.next()) {
					Cust cust = null; // 안에서 초기화 가능
					String id = rset.getString("id"); // 끄집어낼 값 : "id"는 컬럼명.
					String pwd = rset.getString("pwd"); // 끄집어낼 값 : "pwd"는 컬럼명.
					String name = rset.getString("name"); // 끄집어낼 값 : "name"는 컬럼명.
					int age = rset.getInt("age"); // 끄집어낼 값 : "age"는 컬럼명.

					cust = new Cust(id, pwd, name, age); // cust 객체 생성이 마지막이다.
					list.add(cust); // 한바퀴 돌아서나온 값은 list에 넣자.
				}
			} catch (Exception e) {

			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public List<Cust> search(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
