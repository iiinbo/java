package array;

public class P102 {

	public static void main(String[] args) {
		int a = 100; //프리미티 타입(기본)
		
		int arr[] = new int[3]; //레퍼런스 타입(참조)
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		System.out.println(arr);

		for(int i=0; i < arr.length; i++) { //배열의 길이(사이즈3)만큼 증가시켜보겠다
			System.out.printf("%d \t", arr[i]); //\t 는 공간띄워서 옆으로 정렬
		}
		//또다른 방식이며 많이 사용하고 있음
		System.out.println("Type 2");
		for(int data:arr) { //왼쪽은 데이타:오른쪽은 배열의 집합체를 기재
			System.out.printf("%d \t", data);
		}
	}

}
