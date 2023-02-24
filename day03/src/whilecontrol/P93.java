package whilecontrol;

public class P93 {

	public static void main(String[] args) {
		System.out.println("start ...");
		//1~100까지 합과 평균을 구하라
		int i = 1;
		int sum = 0;
		double avg = 0.0;
		while (i <= 100) {
			sum += i;
			i++;
		}
		avg = (sum*1.0) / (i-1);
		System.out.printf("%d, %f", sum, avg);
	}

}
