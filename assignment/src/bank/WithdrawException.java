package bank;

public class WithdrawException extends Exception {
	public WithdrawException() {

	}

	public WithdrawException(String pushcode) {
		super(pushcode); //예외발생 시 코드를 발생시킬거다.
	}
}
