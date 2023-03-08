package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapTest3 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A"); // 1번째는 A
		map.put(2, "B"); // 1번째는 a
		map.put(4, "C"); // 1번째는 a
		map.put(5, "D"); // 1번째는 a
		map.put(6, "E"); // 1번째는 a

		
		//Map에 담긴 key값 & value값 꺼낼 땐 각각 뽑아야한다.
		Collection<String> col = map.values(); //value값들만
		
		System.out.println(col.size()); //사이즈출력
		
		for(String data:col) { //값들 모두 출력
			System.out.println(data);
		}
	}

}
