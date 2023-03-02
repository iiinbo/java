package bank;

public class Account {
	private String accNum;
	private String accName;
	private double balance;

	// 디폴트 컨스트럭터
	public Account() {
		//MakeaccountNumber makenum = new MakeaccountNumber();
		this.accNum =MakeaccountNumber.makeAccNum(); // 계좌번호 자동생성될거야
	} //위 MakeaccountNumber 함수는 기능으로만 사용하고 객체로는 안쓸거야. 이걸 static로 지정하면 가능

	// 2.
	public Account(String accNum, String accName, double balance) {
		this.accNum = accNum;
		this.accName = accName;
		this.balance = balance;
	}

	// 3. 이름과 입금액 넣으면 자동으로 계좌번호 생성하는
	public Account(String accName, double balance) {
		this();
		this.accName = accName;
		this.balance = balance;
	}

	// 상태확인 테스트목적
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accName=" + accName + ", balance=" + balance + "]";
	}

	// 게터 앤 세터 : 잔액조회 가능함. 잔액가져오기
	public double getBalance() {
		return balance;
	}

	// 입금
	public void deposit(double money) {
		if (money <= 0) {
			System.out.println("입금금액을 확인하세요");
			return;
		}
		this.balance += money;

	}

	// 출금
	public void withdraw(double money) {
		if (money <= 0) {
			System.out.println("출금금액을 확인하세요");
			return;
		}
		if (this.balance < money) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		this.balance -= money;
	}

}
