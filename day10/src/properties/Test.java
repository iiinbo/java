package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		Properties props = new Properties();
		String fileName = "file.txt";
		//Test파일엔 ip번호가 없는데, txt파일에 적고 이렇게 선언해서 가져다 쓸 수 있다.
		
		FileInputStream in = null;
		try {
			in = new FileInputStream(fileName);
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}finally { 
			try {
				if(in != null) { //close를 하되, 만약에 in입력 값이 null이 아닐때만.
				in.close();
				}
			} catch (IOException e) {
				
			}
		}
		
		String ip = props.getProperty("IP_ADDR");
		System.out.println(ip);

	}

}
