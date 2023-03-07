package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dto.ItemDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.SearchService;
import com.kbstar.frame.Service;
import com.kbstar.service.ItemService;

public class App2 {

	public static void main(String[] args) {
		Service<Integer, ItemDTO> service = new ItemService();
		SearchService search = new ItemService();
		// ItemService service = new ItemService();
		// 기능 단독추가시 : 위처럼 선언해주어야 단독추가한 search 기능이 보인다.

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input Command(q,i,d,u,s)");
			String cmd = sc.next(); // 커멘드 입력하면 값 가져온다
			if (cmd.equals("q")) {
				System.out.println("Bye");
				break;
			} else if (cmd.equals("s")) { // search 기능 추가는 이렇게 가능.
				search.search();
			} else if (cmd.equals("i")) {
				System.out.println("Input id");
				int id = Integer.parseInt(sc.next()); // 입력받은 데이터는 각각 db로 전달 아니고, 객체 만들어서 한번에 전달한다.
				System.out.println("Input name");
				String name = sc.next();
				System.out.println("Input price");
				double price = Double.parseDouble(sc.next());

				System.out.println("Input quantity");
				int qt = Integer.parseInt(sc.next());

				ItemDTO item = new ItemDTO(id, name, price, qt);
				service.register(item); // 상품주문'등록' 완료

			} else if (cmd.equals("d")) {
				System.out.println("Input id"); // id 입력 : 삭제가능
				// 예외처리 방법(예시)
				try {
					int id = Integer.parseInt(sc.next()); // 입력정상이면
					service.remove(id); // id삭제
				} catch (Exception e) { // 예외상황 발생 시
					System.out.println("숫자만 입력 가능합니다.");
				}

			} else if (cmd.equals("u")) { // id & name & price : 수정가능
				System.out.println("Input id");
				int id = Integer.parseInt(sc.next());
				System.out.println("Input name");
				String name = sc.next();
				System.out.println("Input price");
				double price = Double.parseDouble(sc.next());
				System.out.println("Input quantity");
				int qt = Integer.parseInt(sc.next());
				ItemDTO item = new ItemDTO(id, name, price, qt);
				service.modify(item); // 주문 수정완료
			}
		}
		sc.close();
	}

}
