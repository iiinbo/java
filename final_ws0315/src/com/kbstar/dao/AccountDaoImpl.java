package com.kbstar.dao;

import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;

public class AccountDaoImpl implements DAO<String, AccountDTO> {

	
	
	// 1. jdbc에서 각각 실행해주던걸, Driver Loading 한번으로 할 수 있다.
			public AccountDaoImpl() {
				try {
					Class.forName("oracle.jdbc.OracleDriver");
				} catch (ClassNotFoundException e) {
					System.out.println("Driver가 없습니다.");
					e.printStackTrace();
					return; // 예외상황 발생 시 종료해줘
				}
			}
			
			//계좌(생성한)정보를 db로 집어넣거나 삭제하는 기능
			@Override
			public void insert(AccountDTO v) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void delete(String k) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void update(AccountDTO v) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public AccountDTO select(String k) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<AccountDTO> select() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<AccountDTO> search(Object obj) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
	
}
