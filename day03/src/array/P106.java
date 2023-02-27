package array;

import java.util.Arrays;
import java.util.Random;


public class P106 {

	public static void main(String[] args) {
		
		int arr[] = new int[5];
		Random r = new Random();
		int sum = 0;
		int cnt = 0;
		double avg = 0.0;
	
		for (int i=0; i<arr.length; i++) {
			arr [i] = r.nextInt(9)+1;}
		
		//배열의 홀수 값들의 합과 평균을 구하라
		for (int a : arr) {
		
			if(a%2 != 0)
				sum += a;
				cnt++;
		}
		avg = sum / (cnt*1.0);
		System.out.println(Arrays.toString(arr));
		System.out.printf("%d, %4.2f",sum, avg);
		
		
		
	}

}
