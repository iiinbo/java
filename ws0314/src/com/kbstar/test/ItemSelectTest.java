package com.kbstar.test;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemSelectTest {

	public static void main(String[] args) {
		CRUDService<String, Item> Service = new ItemCRUDServiceImpl();
		
		Item item = null;
		try {
			item = Service.get("2023314997100");
			System.out.println(item);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
