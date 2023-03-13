package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustUpdateTest {

	public static void main(String[] args) {
		//고객정보 수정(modify) 하기위해 cust가 필요하니까.
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
		
		Cust cust = new Cust("id03", "pw4141", "tom", 20);
		try {
			crudService.modify(cust);
			System.out.println("성공적으로 수정이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
//modify(Cust v)