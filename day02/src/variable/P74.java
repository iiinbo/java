package variable;

import java.util.Random;
import java.util.Scanner;

public class P74 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력 하십시오(10~100)");
		// 10~100 사이의 정수를 입력 받는다.
		// 1부터 입력 받은 숫자 까지의 범위에서 랜덤한 숫자를 발생 하시오
		String cmd = sc.next(); //string을
		int cmd2 = Integer.parseInt(cmd); //string-> 정수로 변환
		
		Random r = new Random(); //랜덤한 숫자
		int randomNum = r.nextInt(cmd2)+1; //0부터 해당숫자 전까지인데, 1부터니까 +1
		
		System.out.println(randomNum);
		
		sc.close();
		
		
	}

}
