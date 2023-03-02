package bank;

public class App {

	public static void main(String[] args) {
		Account acc = new Account("정인보", 10000);
		System.out.println(acc);
		
		acc.withdraw(20000);
		acc.deposit(30000);
		System.out.println(acc); //출금실패하고, 잔액은 증가함
		
		
	}

}
