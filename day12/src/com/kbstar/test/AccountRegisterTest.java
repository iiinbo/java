package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountService;

public class AccountRegisterTest {

	public static void main(String[] args) {
		CRUDService<String, AccountDTO> accService = new AccountService();
		AccountDTO obj = // 계좌번호/잔액/누구의계좌인지
				new AccountDTO("202302", 500000, "정인보");
		AccountDTO obj2 = // 계좌번호/잔액/누구의계좌인지
				new AccountDTO("202403", 100000, "조현손");
		AccountDTO obj3 = // 계좌번호/잔액/누구의계좌인지
				new AccountDTO("202504", 30000, "김국민");

		// 단위테스트
		// 1.인터페이스 - Service가 Notification을 이용하여 계좌개설수행한 레지스터 테스트
		try {
			accService.register(obj);
			accService.register(obj2);
			accService.register(obj3);
			System.out.println(obj2);
			System.out.println("계좌개설이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("(RE0001) 계좌개설 실패 에러");
			e.printStackTrace();
		}
		// 2.get(k) 테스트
		AccountDTO acc = null; // 초기화
		try {
			acc = accService.get("20230310");
			System.out.println(acc); // 가져온 계좌 단건 정보 화면에 출력해줘
			System.out.println("-------------------------");
		} catch (Exception e) {

		}

		// 3.get() 테스트
		// db에 먼저 정보 달라고 요청하기
		List<AccountDTO> list = null;
		try {
			list = accService.get();
			for (AccountDTO data : list) {
				System.out.println(data);

			}
		} catch (Exception e) {

		}
		System.out.println("----전체조회 종료-------");

		// 4.remove 테스트
		try {
			accService.remove("202505");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}System.out.println("----계좌해지거래 종료-------");
		// 5. update 테스트
		obj2 = new AccountDTO("202403", 50000, "홍길동");
		try {
			accService.modify(obj2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}System.out.println(obj2);
		
	}

}
