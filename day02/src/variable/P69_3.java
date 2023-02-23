package variable;

import java.util.Scanner;

public class P69_3 {

	public static void main(String[] args) {
		
		//이메일주소를 입력받기
		/*
		 * String email = "jmlee@tonesol.com";
		 * 
		 * String id = email.substring(0, "@"); String domain = email.substring("@");
		 * 
		 * System.out.printf("%s, %s",id,domain);
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일주소를 입력하세요");
		String address = sc.next(); //string
		
		int result = address.indexOf("@");
		//System.out.println(result);
		
		String id = address.substring(0, result);
		String domain = address.substring(result+1);
		
		System.out.printf("%s, %s",id,domain);
	}

}
