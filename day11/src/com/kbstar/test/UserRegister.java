package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.UserService;

public class UserRegister {

	public static void main(String[] args) {
		CRUDService<String, UserDTO> service = new UserService();
		UserDTO obj =
				new UserDTO("id01", "pwd01", "james", "a@asd.com", "010-1234-5678");
		UserDTO obj2 =
				new UserDTO("id02", "pwd02", "james", "a@asd.com", "010-1234-5678");
		UserDTO obj3 =
				new UserDTO("id03", "pwd03", "james", "a@asd.com", "010-1234-5678");
		
		
		//단위테스트
		//1.인터페이스 - Service가 Notification을 이용하여 메세지발송 레지스터 테스트
		try {
			service.register(obj);
			service.register(obj2);
			service.register(obj3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		//2. get(k) 테스트
		//유저정보 받을 준비.
		UserDTO user = null; 
		try {
			user = service.get("id01");
			System.out.println(user); //가져온 정보 화면에 출력해줘
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//3. get() 전체테스트
		//1. db에서 정보달라고 서비스에 요청하기
		List<UserDTO> list = null;
		try {
		list = service.get();
		for(UserDTO data:list) {
			System.out.println(data);
		}
		}catch(Exception e) {
			
		} 
		//4. remove() 전체테스트
		try {
		service.remove("id05");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
