package com.kbstar.app;

import java.util.List;
import java.util.Scanner;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class App { // 인터페이스에 기능 정의가 된 것만 보고 개발하면 된다.

	public static void main(String[] args) {

		DAO<String, UserDTO> userDao = new UserDAO();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input Command(q,i,d,u,s,sa)");
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
					userDao.insert(user);
				} catch (Exception e) {
					System.out.println("입력 불가한 정보가 들어갔습니다.");
				} // 회원가입 완료

			} else if (cmd.equals("d")) {
				System.out.println("Input id"); // id 입력 : 삭제가능
				String id = sc.next();
				try {
					userDao.delete(id); //:해당하는id를 데이터베이스에서 삭제하라고 요청
				} catch (Exception e) {
					System.out.println("id가 존재하지 않습니다.");
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
					userDao.update(user);
				} catch (Exception e) {
					System.out.println("id가 존재하지 않습니다.");
				}
			} else if (cmd.equals("s")) {
				System.out.println("Input id"); // 입력한 id에 대해서만 조회
				String id = sc.next();

				UserDTO user = null;

				try {
					user = userDao.select(id);
					System.out.println(user);
				} catch (Exception e) {
					System.out.println("id가 존재하지 않습니다.");
				}
			} else if (cmd.equals("sa")) {
				List<UserDTO> list = null;
				try {
					list = userDao.select();
					for(UserDTO data:list) { //list에 담긴 것 모두 출력할거야.
						System.out.println(data);
					}
				} catch (Exception e) {
					System.out.println("정보가 존재하지 않습니다.");
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
