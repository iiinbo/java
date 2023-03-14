package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustInsertTest {

	public static void main(String[] args) {
		//회원가입을 시키기 위해 cust가 필요하니까.
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
		
		Cust cust = new Cust("id77", "pwd77", "정인보",25);
		try {
			crudService.register(cust);
			System.out.println("성공적으로 입력이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
