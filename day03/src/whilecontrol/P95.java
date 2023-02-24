package whilecontrol;

public class P95 {

	public static void main(String[] args) {
		System.out.println("start ...");
		//while문으로 짝수의 합과 평균을 구하라
		
		int i = 1;
		int cnt = 0;
		int sum = 0;
		double avg = 0.0;
		
		while (i <= 100) {
			if (i % 7 == 0) {
				sum += i;
				cnt++;
			}
			i++;
			
		}
		
		avg = (sum*1.0) / cnt;
		System.out.printf("%d, %4.2f", sum, avg);
	}
}
