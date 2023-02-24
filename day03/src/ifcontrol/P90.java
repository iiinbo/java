package ifcontrol;

public class P90 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		//두 수의 최대 값과 최소 값을 구해봐요
		int max = 0;
		int min = 0;
		
		if(a > b) {
			max = a;
			min = b;
		} else {
			max = b;
			min = a;
		}
		
		
		System.out.printf("MAX: %d, MIN: %d", max, min);
		
		
	}
}
