package p214;

import java.util.Random;

public class Test4 {

	public static void main(String[] args) {
		int ar[] = new int[10];
		Random r= new Random();
		
		for(int i = 0; i < ar.length; i++) {
			ar[i] = r.nextInt(10)+1; //1~10까지 랜덤한 숫자 들어간다.
			//[i]에 0123 4번째 인덱스까지 들어갈 공간이 없을 때 나오는 예외에러
			//ArrayIndexOutOfBoundsException(자주나오는 실행예외)
		}
		for(int data:ar) {
			System.out.println(data);
			try {
				Thread.sleep(2000);//2초에 하나씩 찍어줘
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
