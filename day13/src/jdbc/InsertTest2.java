package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest2 {

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
		String insertSql = "INSERT INTO cust VALUES(?,?,?,?)"; // 우리는 이 문장을 질의한다.
		Connection con = null;
		PreparedStatement pstmt = null;
		try {// 4. SQL전송
			con = DriverManager.getConnection(url, id, pwd); // 커넥션 시도/// 3. Statement 생성 -> SQL문 준비하고 전송준비
			pstmt = con.prepareStatement(insertSql);// 커넥션에 집어넣는다.
			pstmt.setString(1, "id13"); // 물음표자리에 값 세팅.
			pstmt.setString(2, "pwd10");
			pstmt.setString(3, "김국민");
			pstmt.setInt(4, 50);
			int result = pstmt.executeUpdate();// 5. 결과 받기// 우리가 위에서 만든 쿼리문을 DB로날린다(업데이트)~ 라는 뜻.
			System.out.println(result);	
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (pstmt != null) { // 널이 아닐때만 닫아줘~
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try { // 6. CLose -> 연결 해제//커넥션도 정상적으로 닫아주기.
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("close 실패");
				e.printStackTrace();
			}
			System.out.println("Close 성공!");
		}
	}

	




}
