package com.kbstar.app;

import java.util.List;
import java.util.Scanner;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.ShopService;
import com.kbstar.service.CartCRUDServiceImpl;
import com.kbstar.service.CustCRUDServiceImpl;
import com.kbstar.service.ItemCRUDServiceImpl;
import com.kbstar.service.ShopServiceImpl;

public class App {

	public static void main(String[] args) {

		// 이 App은 모든 service를 다 사용한다. 선언해주기
		ShopService<Cust, Cart> shopService = new ShopServiceImpl();

		CRUDService<String, Cust> custService = new CustCRUDServiceImpl();
		CRUDService<String, Item> itemService = new ItemCRUDServiceImpl();
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("----   Shop Mall Program -----");
			System.out.println("Login(l) or Register(r) (q) ...");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("Bye...");

				break;
			} else if (cmd.equals("r")) {
				System.out.println("Register.. "); // 회원가입 진행 안내
				System.out.println("id를 만들어 주세요"); // 입력요청
				String id = sc.next();
				System.out.println("pwd를 만들어 주세요"); // 입력요청
				String pwd = sc.next();
				System.out.println("이름을 입력해 주세요"); // 입력요청
				String name = sc.next();
				Cust cust = new Cust(id, pwd, name, 20); // 입력 다 받은 뒤 객체 생성

				try {
					shopService.register(cust); // 메일보내는 기능때문에 회원가입을 shopService에서 사용.
					System.out.println("환영합니다.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (cmd.equals("l")) {
				System.out.println("Login.. ");
				System.out.println("ID를 입력 하세요.. ");
				String id = sc.next();
				System.out.println("PWD를 입력 하세요.. ");
				String pwd = sc.next();
				Cust cust = null; // 로그인 성공 시 cust 객체 계속 유지된다.

				try {
					cust = shopService.login(id, pwd); // login에 커서 올리면 cust를 리턴한다고 나온다.

					System.out.println("로그인 성공");
					System.out.println("----------------------------");
					// 로그인 후 메인
					while (true) {
						System.out.println("Menu(사용자정보조회(c),상품조회(it),카트입력(i),카트조회(ci),나가기(e))...");
						String cmn = sc.next();
						if (cmn.equals("e")) {
							System.out.println("Logout...");
							break;

						} else if (cmn.equals("c")) {
							System.out.println("사용자정보조회...");
							Cust custInfo = null;
							custInfo = custService.get(cust.getId()); // cust 안에 id와 pwd정보 있으므로 빼낼 수 있다.
							System.out.println(custInfo);

						} else if (cmn.equals("it")) {
							System.out.println("상품조회");
							List<Item> list = null;
							list = itemService.get();
							for (Item item : list) { // 담긴곳 list, 그 안에 상품내역은 item
								System.out.println(item);
							}

						} else if (cmn.equals("i")) {
							System.out.println("카트입력");
							Cart cart = null;
							System.out.println("담고싶은 상품id를 입력하세요 ");
							String item_id = sc.next();
							System.out.println("담을 상품의 개수를 입력하세요 ");
							int cnt = Integer.parseInt(sc.next());
							
							cart = new Cart(cust.getId(), item_id, cnt); //user_id는 로그인 완료된 상태에서 가져올 수 있음
							cartService.register(cart);
							
							System.out.printf("상품번호 : %s, %d개가 카트에 정상적으로 담겼습니다.\n", item_id, cnt);
							
						} else if (cmn.equals("ci")) {
							System.out.println("나의 카트조회...");
							List<Cart> list = null;
							list = shopService.myCart(cust.getId());
							for (Cart cart : list) {
								System.out.println(cart);
							}

						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					// e.printStackTrace();
				}
			}
		}
		sc.close();

	}

}
