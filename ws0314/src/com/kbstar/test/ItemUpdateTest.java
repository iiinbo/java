package com.kbstar.test;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemUpdateTest {

	public static void main(String[] args) {
		//고객정보 수정(modify) 하기위해 item가 필요하니까.
		CRUDService<String, Item> Service = new ItemCRUDServiceImpl();
		
		Item item = new Item("202331425100", "miumiu", 60000000, 5.0 ,null);
		try {
			Service.modify(item);
			System.out.println("성공적으로 수정이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
