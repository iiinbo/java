package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustSelectTest {

	public static void main(String[] args) {
		//고객정보 조회 하기위해 cust가 필요하니까.
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
		
		Cust cust = null;
		try {
			cust = crudService.get("id03");
			System.out.println(cust);
			System.out.println("성공적으로 조회가 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
