package com.kbstar.test;


import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.UserServiceImpl;

public class UserSelectAllTest {

	public static void main(String[] args) {
		// 고객정보 전체조회 테스트 성공
		// 조회내역 미존재 시 예외처리 성공
		CRUDService<String, UserDTO> Service = new UserServiceImpl();

		List<UserDTO> list = null;
		try {
			list = Service.get();

				for (UserDTO obj : list) {
					System.out.println(obj);
				}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
