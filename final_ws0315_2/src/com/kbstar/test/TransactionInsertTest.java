package com.kbstar.test;

import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.TransactionServiceImpl;


public class TransactionInsertTest {

	public static void main(String[] args) {
		//계좌이체 내역 생성 테스트 성공

		CRUDService<String, TransactionDTO> Service = new TransactionServiceImpl();
		
		TransactionDTO obj = 
				new TransactionDTO("679902-01-265904",500.0,"O","750602-01-720067");
		//TransactionDTO obj2 = new TransactionDTO("679902-01-265904",500.0,"O","750602-01-720067");
		try {
			Service.register(obj);
			System.out.println("계좌이체가 성공적으로 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
	}

}
