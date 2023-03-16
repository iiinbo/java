package com.kbstar.test;


import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.UserServiceImpl;

public class UserUpdateTest {

	public static void main(String[] args) {
		//고객정보 수정(modify) 테스트 성공
		//
		CRUDService<String, UserDTO> Service = new UserServiceImpl();
		
		UserDTO user = new UserDTO("bo2940", "2939", "77", "01031062939");
		try {
			Service.modify(user);
			System.out.println("성공적으로 수정이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
	}

}
