package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;

public class AccountDAO implements DAO<String,AccountDTO> {

	//db만들기
	HashMap<String,AccountDTO> db;
	
	public AccountDAO() {
		db = new HashMap<String,AccountDTO>();
	}
	
	@Override
	public void insert(AccountDTO v) throws Exception {
		//계좌생성한 뒤 db에 계좌번호 저장하려는데 이미 있다면 에러.
		//그게 아니면 db에 put 입력
		if(db.containsKey(v.getAccNo())) {
			throw new Exception("db IN0001");
		} db.put(v.getAccNo(), v);
		
	}

	@Override
	public void delete(String k) throws Exception {
		//db에 계좌번호가 없다면 에러
		//그게 아니면 삭제
		if(!db.containsKey(k)) {
			throw new Exception("db DE0001");
		} db.remove(k);
		
	}

	@Override
	public void update(AccountDTO v) throws Exception {
		//db에 저장되어있는 정보가 없었으면 에러
		//그게아니고 수정이 있으면 put
		if(!db.containsValue(v)) { //여긴 key값만 보는게 아니라 value값
			throw new Exception("db UP0001");
		} db.put(v.getAccNo(), v);
		
	}

	@Override
	public AccountDTO select(String k) throws Exception {
		AccountDTO obj = null;
		obj = db.get(k);
		return obj;
	}

	@Override
	public List<AccountDTO> select() throws Exception {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		Collection<AccountDTO> col = db.values();
		for(AccountDTO obj:col) {
		 list.add(obj);
		}
		return list;
	}

	//추상함수 추가
	//내 계좌(사용자의) 조회 obj = id;
	//이 함수는 사용자의 id를 입력하면 사용자가 가진 계좌를 모두 반환
	//Object obj = new String();
	@Override
	public List<AccountDTO> search(Object obj) throws Exception {
		
		return null;
	}
	
}
