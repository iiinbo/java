package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.Service;
import com.kbstar.service.ItemService;

public class App2 { //**상품 주문하기**

	public static void main(String[] args) {
		Service<String, ItemDTO> service = new ItemService();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input Command(종료,주문하기)");
			String cmd = sc.next(); // 커멘드 입력하면 값 가져온다
			if (cmd.equals("종료")) {
				System.out.println("다음 방문을 기대하겠습니다^^ 감사합니다.");
				break;
			} else if (cmd.equals("주문하기")) {
				System.out.println("1상의 2하의 중 원하는 상품의 번호를 입력하세요.");
				String pd_id = sc.next(); // 입력받은 데이터는 각각 db로 전달 아니고, 객체 만들어서 한번에 전달한다.

				if (pd_id.equals("1")) {
					System.out.println("'포근해니트'/'샤랄라블라우스' 중 구매할 상품명을 입력하세요");
					String pd_name = sc.next();
					if(pd_name.equals("포근해니트")) {
						System.out.println("580,000원 입니다. 결제가 진행됩니다.");
						int price = 580000;
						ItemDTO item = new ItemDTO(pd_id, pd_name, price); // 한번에 전달할 수 있는 객체를 새로 생성했다.
						service.register(item); // 주문 완료
						System.out.println(item);
						break;
					} else {
						System.out.println("980,000원 입니다. 결제가 진행됩니다.");
						int price = 980000;
						ItemDTO item = new ItemDTO(pd_id, pd_name, price); // 한번에 전달할 수 있는 객체를 새로 생성했다.
						service.register(item); // 주문 완료
						System.out.println(item);
						break;
					}
				} else {
					System.out.println("'무릎시려청바지'/'멋쟁이슬랙스' 중 구매할 상품명을 입력하세요");
					String pd_name = sc.next();
					if(pd_name.equals("무릎시려청바지")) {
						System.out.println("180,000원 입니다. 결제가 진행됩니다.");
						int price = 180000;
						ItemDTO item = new ItemDTO(pd_id, pd_name, price); // 한번에 전달할 수 있는 객체를 새로 생성했다.
						service.register(item); // 주문 완료
						System.out.println(item);
						break;
					} else {
						System.out.println("280,000원 입니다. 결제가 진행됩니다.");
						int price = 280000;
						ItemDTO item = new ItemDTO(pd_id, pd_name, price); // 한번에 전달할 수 있는 객체를 새로 생성했다.
						service.register(item); // 주문 완료
						System.out.println(item);
						break;
					} 	
				}
			}
		}
	} 
}

	


