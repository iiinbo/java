package whilecontrol;

public class P94_2 {

	public static void main(String[] args) {
		// 합과 평균을 구하는데,
		// 짝수만 구하시오

		System.out.println("start ...");

		int cnt = 0;
		int sum = 0;
		int i = 0;
		double avg = 0.0;

		for (i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum += i;
				cnt++; 
			} if(i == 8) {
				break;
			//돌아가는 횟수가 8까지하고 for문을 멈춰라. / if문에서 return은 함수 종료 / 컨티뉴는 스킵개념
			}
			
		}

		avg = sum / (cnt * 1.0); // cnt*1.0; 실수로 바꾸는 작업.

		System.out.printf("%d, %4.2f", sum, avg);
	}

}
