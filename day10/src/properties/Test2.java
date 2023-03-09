package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test2 {

	public static void main(String[] args) {
		Properties props = new Properties();
		String fileName = "file.txt";

		try (FileInputStream in = new FileInputStream(fileName)) {
			props.load(in);
		} catch (IOException e) {
			System.out.println("문제가 발생하였습니다. 관리자에게 문의바람");
			return; //문제 발생하면 가장 밖에 print기능까지 못가게 해라.
		}
		
		String ip = props.getProperty("IP_ADDR");
		int port = Integer.parseInt(props.getProperty("PORT"));
		System.out.printf("%s 서버로 %d 포트로 접속한다.",ip,port);

	}

}
