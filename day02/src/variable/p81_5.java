package variable;

import java.util.Scanner;

public class p81_5 {

	public static void main(String[] args) {
		// 입력한 이메일 주소 도메인이 naver면 n 구글 g 아니면 etc

		Scanner sc = new Scanner(System.in);
		System.out.println("이메일주소를 입력하세요");
		String address = sc.next(); // string
		int result = address.indexOf("@");
		String domain = address.substring(result + 1);

		String a = (domain.equals("naver.com")) ? "N" : (domain.equals("google.com")) ? "G" : "Etc";
		
		System.out.println(a);
		sc.close();
	}	
}	
		
		/*if (domain.equals("naver.com")) {
			System.out.println("N");
		} else if (domain.equals("google.com")) {
			System.out.println("G");
		} else {
			System.out.println("Etc");
		}
	}*/

