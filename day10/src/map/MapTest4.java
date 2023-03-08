package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.kbstar.dto.UserDTO;

public class MapTest4 {

	public static void main(String[] args) {
		//User넣을거다
		Map<String, UserDTO> db = new HashMap<String, UserDTO>();
		
		//map.에 put으로 집어넣어준다.
		db.put("id01", new UserDTO("id01", "pwd01", "james1"));
		db.put("id02", new UserDTO("id02", "pwd03", "james2"));
		db.put("id03", new UserDTO("id03", "pwd04", "james3"));
		
		UserDTO u = db.get("id02"); //UserDTO를 달라고 했으니까 UserDTO로 받으면됨
		System.out.println(u);
		
		//수정
		UserDTO uu = new UserDTO("id02", "pwd00", "james2");
		db.put(uu.getId(), uu); //id02에 uu를 넣어라
		
		System.out.println("============================");
		
		//값들 모두 출력
		Collection<UserDTO> col = db.values();
		
		for(UserDTO data:col) { //수정된 값까지 전부 출력
			System.out.println(data);
		}
	}

}
