package com.kbstar.test;


import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.UserServiceImpl;

public class UserDeleteTest {

	public static void main(String[] args) {
		//고객정보 삭제(remove) 테스트 성공
		//id 미존재 시 예외처리 확인 성공
		CRUDService<String, UserDTO> Service = new UserServiceImpl();
		
		UserDTO user = new UserDTO("bo2940", null, null, null);
		try {
			Service.remove(user.getId());
			System.out.println("성공적으로 삭제가 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
