package list;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTest2 {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		//인터페이스는 배열 생성 불가하므로, 하위 클래스인 ArrayList를 생성해서 씀(LinkedList)도 동일함.
		
		//1~10까지 숫자를 20개 입력한다.
		//단, while문을 이용한다.
		
		Random r = new Random();
		int num = r.nextInt(10) + 1;
		int size = 0;
		
		while(list.size() < 20) {
			list.add(num);
			list.add(size++);
			
		}
		//list정보를 출력
		System.out.println(list.size()); //총 몇개인지
		for (int data : list) { //담겨있는 숫자가 무엇인지
			System.out.println(data);
		}

	}

}
