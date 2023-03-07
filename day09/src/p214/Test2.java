package p214;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		int num = 0;
		//try문 안에 스캐너를 사용하면, 자동으로 close기능도 함께 부여.finally도 안써도됨.
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Input num");
		num = Integer.parseInt(sc.next());
		int result = 10 / num;
		System.out.println(result);
		}catch(Exception e) {
			System.out.println("잘못 입력하셨어요");
		}
		
		System.out.println("end App bye...");
		
		// 예외발생1 : NumberFormatException (영문입력)
		// 예외발생2 : ArithmeticException (0입력)
		//어떤 예외가 발생하더라도 문구 하나로 통일하려면 아래처럼도 가능 . 단점! 에러문구가 디테일하지 않음.
		/*catch (Exception e) { 
		System.out.println("잘못 입력하셨습니다.");
		e1.printStackTrace(); //무슨에러인지 모를 때, 개발자가 보는 코드
*/	
		}
	}


