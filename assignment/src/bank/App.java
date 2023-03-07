package bank;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// 계좌생성c
		// 출금w
		// 계좌 입금d
		// 계좌정보 조회s

		Account acc = null;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Input command (계좌신규, 출금, 입금, 조회, 해지, 종료)");
			String cmd = sc.next(); // string을

			if (cmd.equals("종료")) {
				System.out.println("OK bye.......");
				break;

			} else if (cmd.equals("계좌신규")) {
				System.out.println("계좌 종류입력 ex) 입출금");
				String accName = sc.next();
				System.out.println("예금주 입력");
				String accHolder = sc.next();
				System.out.println("신규금액 입력");
				double balance = Double.parseDouble(sc.next());

				try {
					acc = new Account(accName, accHolder, balance);
					System.out.println(acc); // 계좌가 생성되었다고 보여주기.
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return;
				}

			}
			if (acc == null) {
				System.out.println("계좌가 없습니다. 계좌 신규 후 다시 이용해 주세요.");
			}

			else {
				if (cmd.equals("출금")) {
					System.out.println("출금금액을 입력하세요");
					double money = Double.parseDouble(sc.next());
					// 예외처리
					try {
						acc.withdraw(money); // 출금 시
						System.out.println("출금이 완료되었습니다. 현재 잔액 : " + acc.getBalance());
						System.out.println(acc); // 정상이면 계좌정보도 함께
					} catch (WithdrawException e) { // 음수 에러나면
						System.out.println(e.getMessage()); // 메시지발생
					}

				} else if (cmd.equals("입금")) {

					System.out.println("입금금액을 입력하세요");
					double money = Double.parseDouble(sc.next());
					// 예외처리
					try {
						acc.deposit(money);
						System.out.println("입금이 완료되었습니다. 현재 잔액 : " + acc.getBalance());
						System.out.println(acc);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else if (cmd.equals("조회")) {
					System.out.println("**계좌현황**  ");
					System.out.println(acc);
				}
				else if (cmd.equals("해지")) {
					System.out.println("해지할 계좌번호를 입력해 주세요.");
					String accNum = sc.next();
					System.out.println("해지에 따른 현금 반환금액은 " + acc.getBalance() + "원 입니다.");
					System.out.println("계좌 해지가 정상적으로 완료되었습니다. 감사합니다.");
					acc = null;
				}
			}

		}
		sc.close();
	}

}
