package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartUpdateTest {

	public static void main(String[] args) {
		//카트정보 수정(modify) 하기위해 cart가 필요.
		CRUDService<String, Cart> Service = new CartCRUDServiceImpl();
		
		//주문번호를 입력한 뒤, 수정가능한 정보 2가지 [item_id, cnt]
		Cart cart = new Cart("2023314100","id50","2023314710187", 55, null); //item 테이블에 존재하는 다른 상품id가져옴
		try {
			Service.modify(cart);
			System.out.println("입력한 '카트주문번호'의 정보가 성공적으로 수정되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
