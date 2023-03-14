package com.kbstar.test;


import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemDeleteTest {

	public static void main(String[] args) {
		//고객정보 삭제(remove) 하기위해 item가 필요하니까.
		CRUDService<String, Item> Service = new ItemCRUDServiceImpl();
		
		try {
			Service.remove("2023314441100"); 
			System.out.println("성공적으로 삭제가 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
