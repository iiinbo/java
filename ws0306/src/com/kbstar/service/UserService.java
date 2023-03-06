package com.kbstar.service;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Service;

public class UserService implements Service <String, UserDTO> {
	DAO<String,UserDTO> dao;
	//디폴트 컨스트럭터 만들기.
	public UserService() {
		dao = new UserDAO();
	}
	
	//자동삽입
	@Override
	public void register(UserDTO v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(UserDTO v) {
		// TODO Auto-generated method stub
		
	}

}
