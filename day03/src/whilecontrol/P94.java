package whilecontrol;

public class P94 {

	public static void main(String[] args) {
		// 합과 평균을 구하는데,
		// 짝수만 구하시오

		System.out.println("start ...");

		int cnt = 0;
		int sum = 0;
		int i = 0;
		double avg = 0.0;

		for (i = 1; i <= 100; i++) {
			if (i % 2 != 0) { //짝수가 아닌 수(=홀수)
				continue; //홀수가 들어오면 컨티뉴를 실행해라(컨티뉴 = 스킵하고 다시 돌아라)
			}
			sum += i;
			cnt++;
		}

		avg = sum / (cnt * 1.0); // cnt*1.0; 실수로 바꾸는 작업.

		System.out.printf("%d, %4.2f", sum, avg);
	}

}
