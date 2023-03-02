package bank;

import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {
		Account acc = null;

		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Input command (c,w,d, s, q)");
			String cmd = sc.next(); // string을
			if (cmd.equals("q")) {
				System.out.println("bye");
				break;
				
			} else if (cmd.equals("c")) {
				System.out.println("create account");
				System.out.println("input account info[name,balance]");
				System.out.println("이름입력");
				String name = sc.next();
				System.out.println("입금액 입력");
				double balance = Double.parseDouble(sc.next());
				acc = new Account(name, balance);
				System.out.println(acc); // 계좌가 생성되었다고 보여주기.
				
			} else if (cmd.equals("w")) {
				System.out.println("withdraw:");
				System.out.println("출금금액을 입력하세요");
				double money = Double.parseDouble(sc.next());
				acc.withdraw(money);
				System.out.println(acc);
				
			} else if (cmd.equals("d")) {
				System.out.println("deposit:");
				System.out.println("입금금액을 입력하세요");
				double money = Double.parseDouble(sc.next());
				acc.deposit(money);
				System.out.println(acc);

			} else if (cmd.equals("s")) {
				System.out.println("Select:");
				System.out.println(acc);
			}

			sc.close();
		}
	}
}
