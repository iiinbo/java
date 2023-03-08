package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;

public class ItemDAO implements DAO<String, ItemDTO> {

	HashMap<String, ItemDTO> db = null; // db

	public ItemDAO() {
		db = new HashMap<>();
	}

	// 자동삽입 k:string이 박히고, v:UserDTO가 자동으로 박힌다

	@Override
	public void insert(ItemDTO v) throws Exception {
		if (db.containsKey(v.getPd_id())) {
			throw new Exception("동일한 상품을 주문했습니다.");
		}

		db.put(v.getPd_id(), v); // ItemDTO에서 id값을 빼서 저장한다.

//		if (v.getPd_name().equals("샤랄라블라우스")) {
//			throw new Exception("PE0002");
//		}

	}

	@Override
	public void delete(String k) throws Exception {
		if (!db.containsKey(k)) {
			throw new Exception("입력한 id에 대한 정보가 없습니다.");
		}
		db.remove(k);
	}

	@Override
	public void update(ItemDTO v) throws Exception {
		if (!db.containsKey(v.getPd_id())) {
			throw new Exception("입력한 id에 대한 정보가 없습니다.");
		}
		db.put(v.getPd_id(), v);

	}

	@Override
	public ItemDTO select(String k) throws Exception {
		if (!db.containsKey(k)) {
			throw new Exception("PE0004");
		}
		ItemDTO item = null;
		item = db.get(k);
		return item;
	}

	@Override
	public List<ItemDTO> select() throws Exception {
		ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
		Collection<ItemDTO> col = db.values();
		for (ItemDTO data : col) {
			list.add(data); // 리스트에 넣어!
		}
		return list;
	}

}
