package array;

import java.util.Arrays;
import java.util.Random;

public class P114 {

	public static void main(String[] args) {
		//2차원 배열
		int[][] arr = new int[5][5]; //정방형 배열 가로세로 길이 동일 5*5
		
		Random r = new Random();
		
		for(int i = 0; i<arr.length; i++) { //여기서 arr.length는 5개 의미
			for(int j = 0; j < arr[i].length; j++) {//i가 0일 땐 j의 arr의 사이즈 5개고 이걸 5번 돌겠다. 
				arr[i][j] = r.nextInt(9)+1; //d 배열 안을 랜덤번호로 채우겠다. 1~9숫자로
			//00, 01, 02, 03, 04, 10, 11 ...44까지 돈다.
				
			}
		}
		System.out.println(Arrays.toString(arr));
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println("");
		}
		//위의 내용을 for-each로 변경하시오
		System.out.println("----------------------------------");
		
		for(int [] a :arr) {
			for(int data : a) {
				System.out.printf("%d\t", data);
			}
			System.out.println("");
		}
		
		
	
		
	}

}
