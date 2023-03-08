package set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTest1 {

	public static void main(String[] args) {
		//set은 중복을 허용 안한다.(list와 다른점)
		Set<Integer> set = new HashSet<Integer>();
		Random r= new Random();
		int num = r.nextInt(10)+1;
		int size = 0;
		
		//중복값을 제거해도 10개가 출력되려면 while문사용
		while(set.size() < 10) {
			set.add(num);
			set.add(size++);
			
		}
		
		//1~10까지 10개 입력 -> 10개 숫자 중 중복된 값이 있어서, 출력이 10개로 안나옴
//		Random r= new Random();
//		for(int i=0; i < 10; i++) {
//			int num = r.nextInt(10)+1;
//			set.add(num);
//		}
		
		System.out.println(set.size());
		System.out.println("===========");
		
		for(int data : set) {
			System.out.println(data);
		}
	}

}
