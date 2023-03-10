package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.TransactionDAO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Notification;
import com.kbstar.noti.NotificationImpl;

public class TransactionService implements CRUDService<String, TransactionDTO> {

	DAO<String, TransactionDTO> TransDao;
	Notification notification;
	
	public TransactionService() {
		 TransDao = new TransactionDAO();
		 notification = new NotificationImpl();
	}
	
	@Override
	public void register(TransactionDTO v) throws Exception {
		TransDao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(TransactionDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransactionDTO get(String k) throws Exception {
		TransactionDTO obj = null;
		
		try {
			obj = TransDao.select(k);
		} catch(Exception e) {
			throw new Exception("ER0258");
		}
		return obj;
	}

	@Override
	public List<TransactionDTO> get() throws Exception {
		List<TransactionDTO> list = null;
		try {
		list = TransDao.select();
		} catch(Exception e) {
			throw new Exception("SE0022 거래내역 전체조회에 실패했습니다.");
		}
		return list;
	}

}
