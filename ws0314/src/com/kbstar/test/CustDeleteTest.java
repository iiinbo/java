package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustDeleteTest {

	public static void main(String[] args) {
		//고객정보 삭제(remove) 하기위해 cust가 필요하니까.
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
		
		Cust cust = new Cust("id01", "pwd02", "tom", 0);
		try {
			crudService.remove(cust.getId());
			System.out.println("성공적으로 삭제가 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
