package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustSelectAllTest {

	public static void main(String[] args) {
		// 고객정보 전체조회 하기위해 List에 담긴 cust가 필요하니까.
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();

		List<Cust> list = null;
		try {
			list = crudService.get();

			if (list.size() == 0) {
				System.out.println("조회할 데이터가 없습니다.");
			} else {
				for (Cust obj : list) {
					System.out.println(obj);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
