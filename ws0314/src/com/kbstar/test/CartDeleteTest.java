package com.kbstar.test;


import com.kbstar.dto.Cart;
import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;
import com.kbstar.service.ItemCRUDServiceImpl;

public class CartDeleteTest {

	public static void main(String[] args) {
		//카드정보 삭제(remove) 하기위해 cart가 필요.
		CRUDService<String, Cart> Service = new CartCRUDServiceImpl();
		
		try {
			Service.remove("2023314289100");  //존재
			System.out.println("카트에서 성공적으로 삭제가 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
