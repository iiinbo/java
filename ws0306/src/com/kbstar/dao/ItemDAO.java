package com.kbstar.dao;

import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;

public class ItemDAO implements DAO<String, ItemDTO>{

	//자동삽입 k:string이 박히고, v:UserDTO가 자동으로 박힌다
	@Override
	public void insert(ItemDTO v) {
		return;
		
	}

	@Override
	public void delete(String k) {
		return;
		
	}

	@Override
	public void update(ItemDTO v) {
		return;
		
	}

	

}
