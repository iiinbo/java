package bank;


public class Account {
	private String accNum;
	private String accName;
	private String accHolder;
	private double balance;

	// 디폴트 컨스트럭터
	public Account() {
		//MakeaccountNumber makenum = new MakeaccountNumber();
		this.accNum =MakeaccountNumber.makeAccNum(); // 계좌번호 자동생성될거야
	} //위 MakeaccountNumber 함수는 기능으로만 사용하고 객체로는 안쓸거야. 이걸 static로 지정하면 가능


	// 2. 이름과 입금액 넣으면 자동으로 계좌번호 생성하는
	public Account(String accName, double balance) {
		this();
		this.accName = accName;
		this.balance = balance;
	}
	
	//3. 
	public Account(String accName, String accHolder, double balance) throws Exception {
		this();
		this.accName = accName;
		this.accHolder = accHolder;
		if(balance < 0) {
			throw new Exception("에러코드(A0001) 신규금액 오류입니다. 금액을 다시 확인해 주세요.");
		}
		this.balance = balance;
	}
	//4.
	public Account(String accNum, String accName, String accHolder, double balance) {
		this.accNum = accNum;
		this.accName = accName;
		this.accHolder = accHolder;
		this.balance = balance;
	}

	
	
	public double getBalance() {
		return balance;
	}
   
	// 입금 - 음수 예외상황
	public void deposit(double money) throws Exception {
		
		if (money <= 0) {
			throw new Exception("에러코드(B0001) 입금금액 오류입니다. 금액을 다시 확인해 주세요.");
		}
		this.balance += money;
	}

	// 출금 - 잔액부족 시와 음수 발생 시 예외상황
	public void withdraw(double money) throws WithdrawException {
		
		if (money <= 0) {
			throw new WithdrawException("에러코드(C0001) 출금금액 오류입니다. 금액을 다시 확인해 주세요.");
		}
		if (this.balance < money) {
			throw new WithdrawException("에러코드(C0002) 출금금액이 계좌 잔액을 초과했습니다. 금액을 다시 확인해 주세요.");
		}
		this.balance -= money;
	}
	//출력정보
	@Override
	public String toString() {
		return "고객님의 계좌번호 : " + accNum + " / 계좌 종류 : " + accName + " / 계좌 예금주명 : " + accHolder + " / 계좌 잔액 : "
				+ balance;
	}

}
