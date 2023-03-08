package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.Service;
import com.kbstar.service.UserService;

import bank.MakeMessage;


public class App { // 인터페이스에 기능 정의가 된 것만 보고 개발하면 된다.

	public static void main(String[] args) {
		Service<String, UserDTO> service = new UserService();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input Command(q,i,d,u)");
			String cmd = sc.next(); // 커멘드 입력하면 값 가져온다
			if (cmd.equals("q")) {
				System.out.println("Bye");
				break;
			} else if (cmd.equals("i")) {
				System.out.println("Input id");
				String id = sc.next(); // 입력받은 데이터는 각각 db로 전달 아니고, 객체 만들어서 한번에 전달한다.
				System.out.println("Input pwd");
				String pwd = sc.next();
				System.out.println("Input name");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pwd, name); // 한번에 전달할 수 있는 객체를 새로 생성했다.
				
				try {
					service.register(user);
				} catch (Exception e) {
					System.out.println(com.kbstar.frame.MakeMessage.makeMessage(e.getMessage()));
				} //회원가입 완료
				
			} else if (cmd.equals("d")) {
				System.out.println("Input id"); // id 입력 : 삭제가능
				String id = sc.next();
				try {
					service.remove(id);
				} catch (Exception e) {
					System.out.println(com.kbstar.frame.MakeMessage.makeMessage(e.getMessage()));
				}
				
			} else if (cmd.equals("u")) { // id & name & pwd : 수정가능
				System.out.println("Input id");
				String id = sc.next(); // 입력받은 데이터는 각각 db로 전달 아니고, 객체 만들어서 한번에 전달한다.
				System.out.println("Input pwd");
				String pwd = sc.next();
				System.out.println("Input name");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pwd, name);
				try {
					service.modify(user);
				} catch (Exception e) {
					System.out.println(com.kbstar.frame.MakeMessage.makeMessage(e.getMessage()));
				}
			}
		}
		sc.close();
	}

}
			
		/*
		 * Service<String,UserDTO> service = new UserService(); UserDTO user = new
		 * UserDTO("id01", "pw01", "james"); service.register(user);
		 */
	


