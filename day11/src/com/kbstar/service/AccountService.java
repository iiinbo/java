package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Notification;
import com.kbstar.frame.CRUDService;
import com.kbstar.noti.NotificationImpl;

public class AccountService implements CRUDService<String, AccountDTO> {

	DAO<String, AccountDTO> accDao;
	Notification notification;
	
	public AccountService() {
		accDao = new AccountDAO();
		notification = new NotificationImpl();
	}
	
	//계좌개설
	@Override
	public void register(AccountDTO v) throws Exception {
		try {
		accDao.insert(v);
		} catch(Exception e) {
			throw new Exception("IN0001 계좌개설에 실패했습니다.");
		}
		
	}
	//계좌해지
	@Override
	public void remove(String k) throws Exception {
		try {
		accDao.delete(k);
		} catch(Exception e) {
			throw new Exception("DE0001 계좌해지에 실패했습니다.");
		}
	}

	@Override
	public void modify(AccountDTO v) throws Exception {
		try {
		accDao.update(v);
		} catch(Exception e) {
			throw new Exception("UP0001 계좌정보 수정에 실패했습니다.");
		}
	}

	@Override
	public AccountDTO get(String k) throws Exception {
		AccountDTO obj = null;
		obj = accDao.select(k);
		return obj;
	}

	@Override
	public List<AccountDTO> get() throws Exception {
		List<AccountDTO> list = null;
		try {
		list = accDao.select();
		} catch(Exception e) {
			throw new Exception("SE0002 계좌내역 전체조회에 실패했습니다.");
		}
		return list;
	}
	
}
