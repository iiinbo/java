package com.kbstar.test;


import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.UserServiceImpl;

public class UserSelectTest {

	public static void main(String[] args) {
		//뱅킹 이용하는 고객정보 조회 테스트 성공
		//미존재 id 입력 시 예외처리 확인 성공
		CRUDService<String, UserDTO> crudService = new UserServiceImpl();
		
		UserDTO user = null;
		try {
			user = crudService.get("bo2939");
			System.out.println(user);
			System.out.println("성공적으로 조회가 완료되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
