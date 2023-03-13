package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.AccountDTO;
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

	//추상함수
	//이 함수는, 고객이 보유하고 있는 계좌번호를 입력하면, 해당 계좌의 거래내역을 조회한다.
	@Override
	public List<TransactionDTO> search(Object obj) throws Exception {
		List<TransactionDTO> list = new ArrayList<TransactionDTO>();
		Collection<TransactionDTO> col = db.values(); //hashmap에서 데이터 꺼낼 때. 컬렉션&db.values
			//끄집어 낸 데이터를 for-each문으로 다 끄집어내고, 리스트에 담을 것	
			//그러나 데이터 중 계좌정보만 담을 것! 조건은 if문으로 주기.
		for(TransactionDTO tr : col) {
			//계좌 중에서 id(이체정보에서 계좌번호는 accNo)가 obj와 같은 것들만 집어넣기
			if((tr.getAccNo()).equals(obj)) {
				list.add(tr);	
			}
		}
		return list;
	}
}
