package com.kbstar.test;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.BankService;
import com.kbstar.service.BankServiceImpl;

public class bankTest {

	public static void main(String[] args) {
		BankService<UserDTO, AccountDTO, TransactionDTO, String, String> service = new BankServiceImpl();
		
		//회원가입
		UserDTO user = new UserDTO("id01", "pwd01", "james", "a@naver.com", "010-2222-5555");//UserDTO로 위 정보 입력받으면 'service'에서 회원가입이 완료된다.
		try {
			service.register(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	
		//로그인
		String id = "";
		String pwd = "pwd02";
		UserDTO loginUser = null;
		 //UserDTO로 위 정보 입력받으면 'service'에서 로그인 정상여부를 알려준다.
		try {
			loginUser = service.login(id, pwd);
			System.out.println(loginUser);
			System.out.println("Login OK!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
	}

}
