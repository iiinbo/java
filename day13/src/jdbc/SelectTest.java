package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) {
		// 1.Driver Loading -> 어떤 db랑 연결할래?
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return; // 예외상황 발생 시 종료해줘
		}
		System.out.println("Driver Loading 성공!");
		// 2. Connect -> 포트연결
		String id = "bank";
		String pwd = "111111";
		String url = "jdbc:oracle:thin:@172.16.20.61:1521:XE"; // 1521 사용자모드
		String selectSql = "SELECT * FROM cust WHERE id = ?"; // 우리는 이 문장을 질의한다.
		// 4. SQL전송
		try (Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement pstmt = con.prepareStatement(selectSql);) {
			// Connection생성과 Statement 생성을 밖이 아니라 try구문 () 안에.
			// try구문 안에 쓰면, *close를 자동으로 실행해준다.*
			pstmt.setString(1, "id02"); // 첫번째 물음표자리에 값 세팅.
			
			try(ResultSet rset = pstmt.executeQuery()) { //셀렉트일 때 : executeQuery()
				rset.next(); //매우중요!!!! 한칸 이동 후 조회가능!
				String db_id = rset.getString("id"); //적은 컬럼명의 데이터를 끄집어 내자.
				String db_pwd = rset.getString("pwd");
				String name = rset.getString("name");
				int age = rset.getInt("age");
				System.out.println(db_id+""+name+""+age);
				//조회된 결과는 여기로 : rset 담긴다
			} catch(SQLException e1) {
				e1.printStackTrace(); //정상적으로 가져오고 나면  *close를 자동으로 실행해준다.*
			}
		} catch (SQLException e) { //못가져와도  *close를 자동으로 실행해준다.*
			e.printStackTrace();
		}
	}

}
