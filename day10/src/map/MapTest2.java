package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest2 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A"); //1번째는 A
		map.put(2, "B"); //1번째는 a
		map.put(4, "C"); //1번째는 a
		map.put(5, "D"); //1번째는 a
		map.put(6, "E"); //1번째는 a
		
	
		
		Set<Integer> keys = map.keySet(); //1. key값들을 빼낸다.1.2.4.5.6
		System.out.println(keys.toString());
		
		for(int data:keys) {
			System.out.println(map.get(data)); //2. map에서 key값 전부꺼낸다.
		}
	}

}
