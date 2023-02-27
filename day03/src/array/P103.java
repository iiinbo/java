package array;

public class P103 {

	public static void main(String[] args) {
		
		//int arr[] = new int[3]; //배열선언방법 1
		//int []arr = new int[3]; //배열선언방법 2 변수명 앞에다가 꼭 []
		/*
		 * arr[0] = 10; arr[1] = 20; arr[2] = 30;
		 */
		int arr[] = {10, 20, 30}; //배열선언방법 3
		
		for(int data:arr) { //왼쪽은 데이타:오른쪽은 배열의 집합체를 기재
			System.out.printf("%d \t", data);
		}
		
	}

}
