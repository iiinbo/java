package cal;

import java.util.Scanner;

public class CalUi {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Input 2 Number");
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		double result = 0.0;
		try {
			result = Cal.div(a, b);
		} catch (Exception e) {
			System.out.println("분모가 0으로 입력되었습니다.");
			//내부에서 받은 예외에러를 여기서 노출시켜준다.
		}
		//화면에는 입력하는데 에러 없으나, 실행내부에서 에러발생. 그래서 출력안됨
		
		
		System.out.println(result);
		sc.close();
	}

}
