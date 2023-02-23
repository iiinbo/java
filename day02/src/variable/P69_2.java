package variable;

import java.util.Scanner;

public class P69_2 {

	public static void main(String[] args) {
		
		//이메일주소 뽑아내기
		String email = "jmlee@tonesol.com";
		
		String id = email.substring(0, 5);
		String domain = email.substring(6);
		
		System.out.printf("%s, %s",id,domain);
		
		
		
	}

}
