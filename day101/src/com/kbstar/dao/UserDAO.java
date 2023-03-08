package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDAO implements DAO<String, UserDTO>{

	HashMap<String, UserDTO> db = null; //db
	
	public UserDAO() {
		db = new HashMap<>();
	}
	
	//함수 자동삽입
	@Override
	public void insert(UserDTO v) throws Exception {
		if(db.containsKey(v.getId())) {
			throw new Exception("동일한 id가 있습니다.");
		}
		
		db.put(v.getId(), v); //UserDTO에서 id값을 빼서 저장한다.
		
	}

	@Override
	public void update(UserDTO v) throws Exception {
		if(!db.containsValue(v)) {
			throw new Exception("기존 정보와 동일합니다.");
		}
		db.put(v.getId(), v); //다시 집어넣는다.
		
	}

	@Override
	public void delete(String k) throws Exception {
		if(!db.containsKey(k)) {
			throw new Exception("입력한 id가 없습니다.");
		}
		db.remove(k);
		
	}

	@Override
	public UserDTO select(String k) throws Exception {
		UserDTO user = null; 
		user= db.get(k); //db에있는 정보를 끄집어내겠다.
		return user;
	}

	@Override
	public List<UserDTO> select() throws Exception {
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		Collection<UserDTO>col = db.values(); //컬렉션으로 다 끄집어내
		for(UserDTO data:col) {
			list.add(data); //다 끄집어낸걸 list에 담는다.
		}
		return list; //list를 출력
	}

}
