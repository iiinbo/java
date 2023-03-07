package p214;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input num");
		int num = 0;
		try {
			num = Integer.parseInt(sc.next()); //num이 지역함수로 되어있으면 안됨.
			int result = 10 / num; //전역함수로 밖에 선언이 되어야함.
			System.out.println(result);
		} 
		catch (ArithmeticException | NumberFormatException e) { //Exception은 최상위 class라, 어떤 예외상황이 와도 하나의 문구로 안내가능.
			System.out.println("분모가 0이 되었거나, 영문으로 잘못 입력하셨습니다.");
			return; //밑으로 내려가게 하고 싶지 않을 때.
			//e1.printStackTrace(); //무슨에러인지 모를 때, 개발자가 보는 코드
		}finally {
			System.out.println("반드시 실행"); //예외가 발생되든 아니든 finally 구간을 실행시킨다.
			sc.close();
		}
		System.out.println("end App...");
		
		// 예외발생1 : NumberFormatException (영문입력)
		// 예외발생2 : ArithmeticException (0입력)
		//어떤 예외가 발생하더라도 문구 하나로 통일하려면 아래처럼도 가능 . 단점! 에러문구가 디테일하지 않음.
		/*catch (Exception e) { 
		System.out.println("잘못 입력하셨습니다.");
		e1.printStackTrace(); //무슨에러인지 모를 때, 개발자가 보는 코드
*/	
		}
	}


