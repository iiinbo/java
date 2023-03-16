package com.kbstar.service;

import com.kbstar.dao.ItemDAO;
import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Service;

public class ItemService implements Service<String, ItemDTO> {

	DAO<String, ItemDTO> dao;

	public ItemService() {
		dao = new ItemDAO();		// dao 사용하기 위해 객체 선언
	}

	@Override
	public void register(ItemDTO v) throws Exception{
		try {
			dao.insert(v);
		}catch(Exception e) {
			throw e; //app2로 넘긴다 에러.
		}System.out.println("주문완료된 내역을 이메일로 발송드렸습니다.^^ 감사합니다 고객님~!");
	}

	
	@Override
	public void remove(String k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(ItemDTO v) {
		// TODO Auto-generated method stub

	}

}
