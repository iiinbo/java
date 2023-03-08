package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest1 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A"); //1번째는 A
		map.put(2, "B"); //1번째는 a
		map.put(4, "C"); //1번째는 a
		map.put(5, "D"); //1번째는 a
		map.put(6, "E"); //1번째는 a
		
		System.out.println(map.size());
		System.out.println(map.containsValue("A")); //key값이나 value값 있니/?
		
		System.out.println(map.get(6)); //key값을 넣으면 해당하는 값 나온다.
		
		Set<Integer> keys = map.keySet(); //1. key들을 빼낸다.1.2.4.5.6
		System.out.println(keys.toString());
		
		for(int data:keys) {
			System.out.println(map.get(data)); //map에서 전부꺼낸다.
		}
	}

}
