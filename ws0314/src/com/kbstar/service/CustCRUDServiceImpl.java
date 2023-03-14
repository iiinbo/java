package com.kbstar.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.CustDaoImpl;
import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;

public class CustCRUDServiceImpl implements CRUDService<String, Cust> {

	DAO<String, String, Cust> dao; // CustCRUDServiceImpl은 필요에 따라 DAO를 이용한다.

	public CustCRUDServiceImpl() {
		dao = new CustDaoImpl();
	}

	@Override
	public void register(Cust v) throws Exception {
		// 데이터검증
		// db입력
		try {
			dao.insert(v);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("id가 중복되었습니다.");
			} else {
				throw new Exception("시스템 장애 입니다."); // 1차 dao에서 한번 던졌고 여기가 두번째라 문구쓴다.
			}
		}
		// Email sms전송 과정이 여기서 일어남

	}

	@Override
	public void modify(Cust v) throws Exception {
		try {
			dao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("삭제 도중 네트워크 오류가 발생했습니다.");
			} else {
				throw new Exception("해당 id가 존재하지 않습니다."); // 1차 dao에서 한번 던졌고 여기가 두번째라 문구쓴다.
			}
		}
	}

	@Override
	public void remove(String k) throws Exception {

		try {
			// k값 넣으면 삭제.
			dao.delete(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("삭제 도중 네트워크 오류가 발생했습니다.");
			} else {
				throw new Exception("해당 id가 존재하지 않습니다.");
			}
			// 1차 dao에서 한번 던졌고 여기가 두번째라 문구쓴다.
		}
	}

	@Override
	public Cust get(String k) throws Exception {
		// 1.셀렉트 : 반환받을 값(cust)을 먼저 초기화 해줄 것.
		Cust cust = null;

		try {
			cust = dao.select(k);
		} catch (SQLException e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애가 발생했습니다."); // 서버오류일 때
			} else {
				throw new Exception("조회할 id가 존재하지 않습니다."); // 조회 할 데이터 없을 때
			}
		}
		return cust;

	}

	@Override
	public List<Cust> get() throws Exception {
		//1.셀렉트All : 반환받을 바구니(list)을 먼저 초기화 해줄 것.
		
		List<Cust> list = null;
		try{
			list = dao.selectAll();
		}catch(Exception e) {
			if(e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애가 발생했습니다."); //서버오류일 때
			} 
		}
		
		return list;
	}

}
