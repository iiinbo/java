package bank;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		//계좌생성c
		//출금w
		//계좌 입금d
		//계좌정보 조회s

		Account acc = null;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Input command (계좌신규, 출금, 입금, 조회, 종료)");
			String cmd = sc.next(); // string을
			
			if (cmd.equals("종료")) {
				System.out.println("bye");
				break;
				
			} else if (cmd.equals("계좌신규")) {
				System.out.println("이름입력");
				String name = sc.next();
				System.out.println("입금액 입력");
				double balance = Double.parseDouble(sc.next());
				
				try {
					acc.getBalance(balance);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return;
				}
				
				acc = new Account(name, balance);
				System.out.println(acc); // 계좌가 생성되었다고 보여주기.
				
			} else if (cmd.equals("출금")) {
				System.out.println("출금금액을 입력하세요");
				double money = Double.parseDouble(sc.next());
				//예외처리
				try {
					acc.withdraw(money); //출금 시
				} catch (WithdrawException e) { //음수 에러나면
					System.out.println(e.getMessage()); //메시지발생
				}
				System.out.println("출금이 완료되었습니다. 현재 잔액 : "+ acc.getBalance());
				System.out.println(acc); //정상이면 계좌정보도 함께
				
			} else if (cmd.equals("입금")) {
				
				System.out.println("입금금액을 입력하세요");
				double money = Double.parseDouble(sc.next());
				//예외처리
				try {
					acc.deposit(money);
					System.out.println(acc);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				

			} else if (cmd.equals("조회")) {
				System.out.println("계좌현황 : ");
				System.out.println(acc);
			}

			
		} sc.close();
	}

}
