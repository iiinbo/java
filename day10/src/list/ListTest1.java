package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListTest1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		// 1~10까지의 숫자 랜덤하게 10개 담자

		Random r = new Random();

		for (int i = 1; i <= 10; i++) {
			int num = r.nextInt(10) + 1;
			list.add(num);
		}
		list.add(5, 100); //5번 인덱스에 100숫자가 들어감. -> 6번째
		//list.remove(5);
		for (int data : list) {
			System.out.println(data);
		}

	}

}
