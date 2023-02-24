package whilecontrol;

public class P92 {

	public static void main(String[] args) {
		//합과 평균을 구하라
		
		
		System.out.println("start ...");
		
		int cnt = 0;
		int sum = 0;
		double avg = 0.0;
				
				
		for (int i = 1; i <=100; i++) {
			sum += i;
			cnt++;	
			}
		
		avg = sum / (cnt*1.0); //cnt*1.0; 실수로 바꾸는 작업.
		
		System.out.printf("%d, %4.2f", sum, avg);
	}

}
