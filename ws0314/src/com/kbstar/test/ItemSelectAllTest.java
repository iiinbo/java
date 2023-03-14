package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemSelectAllTest {

	public static void main(String[] args) {
		// 전체조회하기 위해 시키기 위해 list가 필요하니까.
		CRUDService<String, Item> Service = new ItemCRUDServiceImpl();

		List<Item> list = null;
		try {
			list = Service.get();

			if (list.size() == 0) { // 바구니에 값이 하나도 없으면
				System.out.println("조회할 데이터가 없습니다.");
			} else { // 그게아니면 정상적으로 for문을 통해 전체출력
				for (Item obj : list) {
					System.out.println(obj);
				}
			}
		} catch (Exception e) { // 조회할 값 없으면 예외처리
			System.out.println(e.getMessage());
		}
	}

}
