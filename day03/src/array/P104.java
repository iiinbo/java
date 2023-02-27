package array;

import java.util.Arrays;
import java.util.Random;


public class P104 {

	public static void main(String[] args) {
		
		int arr[] = new int[10];
		Random r = new Random();
		int sum = 0;
		double avg = 0.0;
		/*
		 * for (int i = 0; i < arr.length; i++) { arr [i] = r.nextInt(99)+1; //+1덕분에
		 * r이라는 랜덤숫자는 0~98이 아니라, 1~99까지 //arr[i] = data; }
		 */
		//System.out.println(Arrays.toString(arr)); //배열의 전체 내용을 화면에 출력하는 법
		
		//배열의 합과 평균을 구하라
		
		for (int i=0; i<arr.length; i++) {
			arr [i] = r.nextInt(99)+1;
			sum += arr[i];
		}
		avg = sum / ((arr.length)*1.0); //곱하기 안하면, 정수 나누기 정수니까~ 
		
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
		System.out.println(avg);
		
		
		
	}

}
