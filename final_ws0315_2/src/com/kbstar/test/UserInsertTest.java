package com.kbstar.test;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.UserServiceImpl;


public class UserInsertTest {

	public static void main(String[] args) {
		//회원가입 테스트 성공
		//중복 id 생성 시 예외처리 확인 성공
		//가입자 이름 한글 OK
		CRUDService<String, UserDTO> Service = new UserServiceImpl();
		
		UserDTO user = new UserDTO("jini1098", "8880", "지니", "01091548880");
		try {
			Service.register(user);
			System.out.println("인터넷뱅킹 회원가입이 성공적으로 완료되었습니다.");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
