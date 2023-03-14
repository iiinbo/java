package com.kbstar.test;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemInsertTest {

	public static void main(String[] args) {
		//회원가입을 시키기 위해 cust가 필요하니까.
		CRUDService<String, Item> Service = new ItemCRUDServiceImpl();
		
		Item obj = new Item("flower", 33300, 3.2); //상품명, 금액, 할인율만 입력받으면 -> 상품번호 & 등록일자 자동생성
		try {
			Service.register(obj);
			System.out.println("성공적으로 입력이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
