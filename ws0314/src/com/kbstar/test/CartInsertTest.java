package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartInsertTest {

	public static void main(String[] args) {
		//카트에 상품을 담기 위해 Cart가 필요해.
		CRUDService<String, Cart> Service = new CartCRUDServiceImpl();
		
		Cart obj = new Cart("id50", "2023314100", 2); //user_id, item_id, cnt만 입력받으면 -> 카드번호(id) & 등록일자 자동생성
		try {
			Service.register(obj);
			System.out.println("고객님의 카트에 상품이 성공적으로 담겼습니다.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
