package com.kbstar.dao;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDAO implements DAO<String,UserDTO>{

	
	
	
	//자동삽입될 때, k:string이 박히고, v:UserDTO가 자동으로 박힌다
	@Override
	public void insert(UserDTO v) {
		System.out.println(v.getId()+"님이 저장 되었습니다.");
		
	}

	@Override
	public void delete(String k) {
		System.out.println(k+"님이 삭제 되었습니다.");
		
	}

	@Override
	public void update(UserDTO v) {
		System.out.println(v.getId()+"님의 정보가 수정 되었습니다.");
		
	}
	
}
