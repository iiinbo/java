package ifcontrol;

public class P86 {

	public static void main(String[] args) {
		//if문을 삼항연산자로 변경해보기
		double sum = 80.0;

		String grade = (sum >= 90.0) ? "VIP" : (sum >= 80.0) ? "GOLD" : "SILVER";
		System.out.printf("%s",grade);

	}
	
}	
