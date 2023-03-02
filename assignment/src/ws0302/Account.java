package ws0302;

import ws0302.MakeAccountNumber;

public class Account {
	private String accNum;
	private String accName;
	private double balance;
	private double rate;
	private String grade;

	// 디폴트 생성자
	public Account() {
		this.accNum = MakeAccountNumber.makeAccNum(); // 계좌번호 자동생성
	}

	// 2 컨스트럭터 : 모두 수기입력해서 생성하는 객체
	public Account(String accNum, String accName, double balance, double rate) {
		this.accNum = accNum;
		this.accName = accName;
		this.balance = balance;
		this.rate = rate;
	}

	// 3. 컨스트럭터 : 계좌번호는 자동생성 받을 객체
	public Account(String accName, double balance, double rate, String grade) {
		this();
		this.accName = accName;
		this.balance = balance;
		this.rate = rate;
		this.grade = grade;
	}

	// *기능*
	// 입금,출금,현재 잔액조회,현재 이자금액조회
	// 입금
	public void deposit(double money) {
		if(money <= 0) {
			System.out.println("입금 금액을 다시 확인하세요");
		} this.balance += money;
	}

	// 출금
	public void withdraw(double money) {
		if(money <= 0) {
			System.out.println("출금 금액을 다시 확인하세요");
			return;
		} if(money > this.balance) { //출금하려는 money가 잔액보다 많을 경우
			System.out.println("출금 잔액이 부족합니다.");
			return;
		} this.balance -= money;
	}
	//이자계산하기
	public double getInterest() {
		double result = balance * rate;
		return result;
	}
	
	// getter and setter
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAccNum() {
		return accNum;
	}

	public String getAccName() {
		return accName;
	}
	//계좌 잔액조회(void아니고 double. 보여줄 정보가 있으니까)
	public double getBalance() {
		return balance;
	}
	//현재 이자조회(void아니고 double. 보여줄 정보가 있으니까)
	public double getRate() {
		return rate;
	}

	// 출력할 정보
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accName=" + accName + ", balance=" + balance + ", rate=" + rate
				+ ", grade=" + grade + "]";
	}

}
