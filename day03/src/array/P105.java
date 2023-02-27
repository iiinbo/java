package array;

import java.util.Arrays;
import java.util.Random;


public class P105 {

	public static void main(String[] args) {
		
		int arr[] = new int[5];
		Random r = new Random();
		int sum = 0;
		int cnt = 0;
		double avg = 0.0;
	
		//홀수 번째의 합과 평균을 구하라
		for (int i=0; i<arr.length; i++) {
			arr [i] = r.nextInt(9)+1;
			if(i % 2 == 0) { //0부터 인덱스가 시작이니, 짝수번째로 뽑아야 홀수가 나옴
				sum += arr[i];
				cnt++;
			}
		}
		avg = sum / (cnt*1.0);
		System.out.println(Arrays.toString(arr));
		System.out.printf("%d, %4.2f",sum, avg);
		
		
	}

}
