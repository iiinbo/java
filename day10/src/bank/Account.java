package bank;

public class Account {
	private String accNo;
	private double balance;
	
	//1.디폴트 컨스트럭터
	public Account() {
		this.accNo = MakeaccountNumber.makeAccNum(); //계좌번호자동생성
	}
	//2.컨스트럭터
	public Account(String accNo, double balance) throws Exception {
		if(balance < 0) { //계좌생성 시 입금액(잔액)이 0보다 작으면 에러호출 
			throw new Exception("ER0001"); //코드 안에서는 throw
		}
		this.accNo = accNo;
		this.balance = balance;
	}
	//3.계좌번호 자동생성 컨스트럭터
	public Account(double balance) throws Exception {//밖에선 throws
		this(); //자동생성된 계좌번호기능 가져온다.
		if(balance < 0) { //계좌생성 시 입금액(신규금액)이 0보다 작으면 에러호출 
			throw new Exception("ER0001"); //코드 안에서는 throw
		}
		this.balance = balance;
	}
	
	public void withdraw(double money) throws Exception {
		//출금 시 발생할 수 있는 예외상황 2가지
		if(money <= 0) {
			throw new Exception("ER0002");
		}
		if(money > balance) {
			throw new Exception("ER0003");
		}
		balance -= money;
	}
	
	
	//출력정보
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}
	
}
