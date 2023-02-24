package ifcontrol;

public class P91 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 85;

		int max = 0;
		int min = 0;
		// 세 수의 최댓값과 최소값 구하기

		if ((a < b) && (b > c)) {
			max = b;
			if (a < c) {
				min = a;
			} else {
				min = c;
			}
		} else if ((b < a) && (a > c)) {
			max = a;
			if (b < c) {
				min = b;
			}
			min = c;
		} else if ((b < c) && (c > a)) {
			max = c;
			if (a < b) {
				min = a;
			}
			min = b;
		}

		// 세 수의 최댓값과 최소값 구하기(두번째 삼항 연산자 방식)

		max = (a > b) ? (a > c) ? a : c : (b > c) ? b : c;
		min = (a < b) ? (a < c) ? a : b : (c < b) ? c : b;

		//세 수의 최댓값과 최소값 구하기(세번째 방식)
		if(a > b) {
			max = Math.max(a, c);
			min = Math.min(b, c);
		} else {
			max = Math.max(b, c);
			min = Math.min(a, c);
		}
		
		
		System.out.printf("MAX: %d, MIN: %d", max, min);

	}
}
