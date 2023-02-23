package variable;

import java.util.Scanner;

public class p81_4 {

	public static void main(String[] args) {
		//90점 이상이면 a 80점 이상이면 b 그 외 f 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		String num = sc.next(); //string을
		
		int num2 = Integer.parseInt(num); 
		String result = (num2 >= 90) ? "A" : (num2 >= 80) ? "B" : "F";
		System.out.println(result);
	}

}
