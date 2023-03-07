package com.kbstar.dao;

import com.kbstar.frame.DAO;

public class AccountMariaDBDAO implements DAO {
	
	
	//자동생성
	@Override
	public void insert(Object obj) {
		System.out.println(obj);
		System.out.println("Inserted Oracle...");	
		
	}

	@Override
	public void delete(Object obj) {
		System.out.println(obj);
		System.out.println("Deleted Oracle...");	
		
		
	}

	@Override
	public void update(Object obj) {
		System.out.println(obj);
		System.out.println("Updated Oracle...");	
		
	}
	
}
