package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetIpAddress {
	public static String getIpAddress() {
		String ipAddr = ""; //우린 이 함수 호출하고
		
		Properties props = new Properties();
		String fileName = "file.txt";

		try (FileInputStream in = new FileInputStream(fileName)) {
			props.load(in);
		} catch (IOException e) {
			System.out.println("문제가 발생하였습니다. 관리자에게 문의바람");
			
		}
		
		ipAddr = props.getProperty("IP_ADDR");
		
		return ipAddr; //리턴(출력)시킬 것이다.
	}
}
