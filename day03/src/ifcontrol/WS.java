package ifcontrol;

import java.util.Scanner;

public class WS {

	public static void main(String[] args) {
		//1~ 100까지의 숫자 중	
		//1.3의 배수의 합과 평균을 구해라 (for문과 if문 사용)
		int i = 0;
		int cnt = 0;
		int sum = 0;
		double avg = 0.0;

		for (i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
				cnt++; 
			} 
	
		}
		avg = sum / (cnt * 1.0); // cnt*1.0; 실수로 바꾸는 작업.

		System.out.printf("%d, %4.2f\n", sum, avg);
		
		
		
//1.4의 배수의 합과 평균을 구해라 (for문과 if문 사용)
		int cnt2 = 0;
		int sum2 = 0;
		double avg2 = 0.0;

		for (i = 1; i <= 100; i++) {
			if (i % 4 == 0) {
				sum2 += i;
				cnt2++; 
			} 
	
		}
		avg2 = sum2 / (cnt2 * 1.0); // cnt*1.0; 실수로 바꾸는 작업.

		System.out.printf("%d, %4.2f\n", sum2, avg2);
		
		
//3. 7의 배수의 합과 평균을 구해라 (while문과 if문 사용)
		int l = 1;
		int cnt3 = 0;
		int sum3 = 0;
		double avg3 = 0.0;
		
		while (l <= 100) {
		if (l % 7 == 0) {
			sum3 += l;
			cnt3++;
		}
		l++;
	}
	
	avg3 = (sum3*1.0) / cnt3;
	System.out.printf("%d, %4.2f", sum3, avg3);
}
}