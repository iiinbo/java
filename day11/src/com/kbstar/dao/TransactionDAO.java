package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.DAO;

public class TransactionDAO implements DAO<String, TransactionDTO> {

	// db
	HashMap<String, TransactionDTO> db;

	public TransactionDAO() {
		db = new HashMap<String, TransactionDTO>();
	}

	@Override
	public void insert(TransactionDTO v) throws Exception {
		if(db.containsKey(v.getDate())) {
			throw new Exception("db IN0011");
		}
		db.put(v.getDate(), v);
	}

	@Override
	public void delete(String k) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(TransactionDTO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public TransactionDTO select(String k) throws Exception {
		TransactionDTO obj = null;
		obj = db.get(k);
		return obj;
	}

	@Override
	public List<TransactionDTO> select() throws Exception {
		List<TransactionDTO> list = new ArrayList<TransactionDTO>(); //바구니 list
		Collection<TransactionDTO> col = db.values(); //col에 고객정보 몽땅 담았어
		for(TransactionDTO data:col) {
			list.add(data);
		}
		return list;
	}

}
