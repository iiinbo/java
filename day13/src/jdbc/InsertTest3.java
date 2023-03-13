package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest3 {

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
		String url = "jdbc:oracle:thin:@172.16.21.43:1521:XE"; // 1521 사용자모드
		String insertSql = "INSERT INTO cust VALUES(?,?,?,?)"; // 우리는 이 문장을 질의한다.
		// 4. SQL전송
		try (Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement pstmt = con.prepareStatement(insertSql);) {
			// Connection생성과 Statement 생성을 밖이 아니라 try구문 () 안에.
			// try구문 안에 쓰면, *close를 자동으로 실행해준다.*
			pstmt.setString(1, "id14"); // 물음표자리에 값 세팅.
			pstmt.setString(2, "pwd10");
			pstmt.setString(3, "나국민");
			pstmt.setInt(4, 50);
			int result = pstmt.executeUpdate();// 5. 결과 받기// 우리가 위에서 만든 쿼리문을 DB로날린다(업데이트)~ 라는 뜻.
			System.out.println(result);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
