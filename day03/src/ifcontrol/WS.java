package ifcontrol;

public class WS {

	public static void main(String[] args) {
		//1~100까지의 숫자 중 3의 배수, 4의 배수, 7의 배수의 합과 평균을 각각 구하라
		int cnt = 0, cnt2 = 0, cnt3 = 0;
		int sum = 0, sum2 = 0, sum3 = 0;
		double avg = 0.0, avg2 = 0.0, avg3 = 0.0;

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
				cnt++; 
			}
			if (i % 4 == 0) {
				sum2 += i;
				cnt2++; 
			} 
			if (i % 7 == 0) {
				sum3 += i;
				cnt3++; 
			} 
		}
		avg = sum / (cnt * 1.0);
		avg2 = sum2 / (cnt2 * 1.0);
		avg3 = sum3 / (cnt3 * 1.0);

	System.out.println("합계 : "+ sum + "평균 : " + avg);
	System.out.printf("%d, %4.2f\n", sum2, avg2);
	System.out.printf("%d, %4.2f", sum3, avg3);
}
}