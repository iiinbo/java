package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dao.ItemDAO;
import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeMessage;

public class App2 { // **상품 주문하기**

	public static void main(String[] args) {
		DAO<String, ItemDTO> itemDao = new ItemDAO();
		ItemDTO item = null;

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input Command(전체상품조회, 주문하기, 주문내역조회, 나가기)");
			String cmd = sc.next(); // 커멘드 입력하면 값 가져온다
			if (cmd.equals("나가기")) {
				System.out.println("다음 방문을 기대하겠습니다^^ 감사합니다.");
				break;

			} else if (cmd.equals("주문하기")) {
				System.out.println("1상의 2하의 중 원하는 상품의 번호를 입력하세요.");
				String pd_id = sc.next(); // 입력받은 데이터는 각각 db로 전달 아니고, 객체 만들어서 한번에 전달한다.

				if (pd_id.equals("1")) {
					System.out.println("'포근해니트'/'샤랄라블라우스' 중 구매할 상품명을 입력하세요");
					String pd_name = sc.next();
					if (pd_name.equals("포근해니트")) {
						try {
							int price = 580000;
							item = new ItemDTO(pd_id, pd_name, price); // 한번에 전달할 수 있는 객체를 새로 생성했다.
							itemDao.insert(item);
							System.out.println("580,000원 입니다. 결제 완료 후 구매가 성공적으로 이루어집니다.");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							System.out.println(e.getMessage());
						}

					} else {
						try {

							int price = 980000;
							item = new ItemDTO(pd_id, pd_name, price); // 한번에 전달할 수 있는 객체를 새로 생성했다.
							itemDao.insert(item); // 주문 완료
							System.out.println(item);
							System.out.println("980,000원 입니다. 결제가 진행됩니다.");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							System.out.println(e.getMessage());
						}

					}
				} else {
					System.out.println("'무릎시려청바지'/'멋쟁이슬랙스' 중 구매할 상품명을 입력하세요");
					String pd_name = sc.next();
					if (pd_name.equals("무릎시려청바지")) {
						System.out.println("180,000원 입니다. 결제가 진행됩니다.");
						int price = 180000;
						item = new ItemDTO(pd_id, pd_name, price); // 한번에 전달할 수 있는 객체를 새로 생성했다.
						try {
							itemDao.insert(item); // 주문 완료
							System.out.println(item);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					} else {
						System.out.println("280,000원 입니다. 결제가 진행됩니다.");
						int price = 280000;
						item = new ItemDTO(pd_id, pd_name, price); // 한번에 전달할 수 있는 객체를 새로 생성했다.
						try {
							itemDao.insert(item); // 주문 완료
							System.out.println(item);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				}
			} else if (cmd.equals("주문내역조회")) {
				System.out.println("조회할 상품번호를 입력해 주세요 예) 1, 2");
				String pd_id = sc.next();

				ItemDTO item2 = null;

				try {
					item2 = itemDao.select(pd_id);
					System.out.println(item2);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println(MakeMessage.makeMessage(e.getMessage()));
				}

			} else if (cmd.equals("전체상품조회")) {
			
				String pd_id = sc.next();
			}
		}
	}
}
