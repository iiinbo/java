package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDAO implements DAO<String, UserDTO> {
	
	//1.데이터베이스 만들기
	HashMap<String, UserDTO> db; //1.해쉬맵을 db라고 선언
	
	//2.생성하고 데이터베이스 쓰기가 시작된다!
	public UserDAO() {
		db = new HashMap<>();
	}
	
	@Override
	public void insert(UserDTO v) throws Exception {
		//db에 넣을 때 조건
		//db에 k값으로 id가 이미 있다면 -> 입력 안되게해
		//그게 아니면 put 입력해줘
		if(db.containsKey(v.getId())) {
			throw new Exception("db error");
		} db.put(v.getId(), v); 
		
	}

	@Override
	public void delete(String k) throws Exception {
		if(!db.containsKey(k)) {
			throw new Exception("에러코드");
		} db.remove(k); 
		
	}

	@Override
	public void update(UserDTO v) throws Exception {
		//기존에 db에 정보가 없었으면 수정 불가
		//그게아니면 처음 입력과 동일한 방식으로 저장해(put)
		if(!db.containsValue(v)) {
			throw new Exception("에러코드");
		}db.put(v.getId(), v);
		//*v : UserDTO에서 id값을 가져오고 v(UserDTO)에 집어넣는다.*
		//여기서 v대신 k를 못쓰는 이유는 상위 함수에 형식이 (UserDTO v) 이기때문.
		
	}

	@Override
	public UserDTO select(String k) throws Exception {
		//사용자정보를 담아주는 UserDTO라는 객체를 obj로 만들거야. 조회할 수 있게
		//그다음 db에서 실제로 담긴 고객정보 중 k값만 가져와(get으로)
		//이걸 obj에 담았으니 리턴해.
		
		UserDTO obj = null;
		obj = db.get(k);
		return obj;
	}

	@Override
	public List<UserDTO> select() throws Exception {
		//1.리스트에 사용자정보를 담아서 가져올거다.
		//그런데! 리스트란 바구니에 db 고객정보를 담을 땐, get아니다.
		//2.컬렉션으로 담아야 함.
		//3.이제 담아서 전체 출력(for- each로)
		ArrayList<UserDTO> list = new ArrayList<UserDTO>(); //바구니만들었다.
		Collection<UserDTO> col = db.values();
		
		for(UserDTO obj : col) {
		 list.add(obj); //만들어둔 바구니, 리스트에 add로 담으면 끝.	
		}
		return list;
	}
	//유저의 k값은 s, v값은 userDTO 그자체
	

}
