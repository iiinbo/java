package calculator;

public class Ui {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		int result = 0; //화면에선 결과값 받을 준비를 해라. int로
		result = cal.sum(10, 20); //화면에서 10과 20을 입력했다.이값을 저장해라.result로 // 이 숫자를 어떻게 처리할지는 class에서 지정했다.
		System.out.println(result); //결과를 화면에 출력하라.
		cal.save(result); //결과를 저장해라. 근데 void로 사용했으니 출력할 것은 없고 저장만 한다 안보이게.
		System.out.println("OK"); //저장에 문제가 없이 실행이 순차적으로 완료되었다면 ok가 떨어진다.
		
		
		
	}

}
