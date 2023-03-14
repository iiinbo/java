package com.kbstar.frame;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public interface DAO<K1,K2,V> {
	public void insert(V v) throws Exception;
	public void delete(K1 k) throws Exception;
	public void update(V v) throws Exception;
	public V select(K1 k) throws Exception; //k값(id) 넣으면 v값 반환
	public List<V> selectAll() throws Exception;
	
	public List<V> search(K2 k) throws Exception;
	
	// 2. jdbc에서 각각 실행해주던 커넥션도 한번에 인터페이스로(**public 옆에 default만 적어주기**)
		// (insert, delete, update 등 커넥션 변수 필요하면 여기서 지정한 getConnection()한번으로 사용가능)
		public default Connection getConnection() throws Exception {
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

}
