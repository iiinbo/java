package bank;

public class Atm {

	public static void main(String[] args) {
		// 계좌생성 시 발생할 수 있는 예외상황을 대처.
		Account acc1 = null; // 3.컨스트럭터 이용. //밖에다 선언할 때 null이 초기화.
		try {
			acc1 = new Account(-10000);
			System.out.println(acc1); // 정상일 때 계좌정보 출력 성공
			acc1.withdraw(50000); //계좌개설 후 출금거래 시도
		} catch (Exception e) {
			System.out.println(MakeMessage.makeMessage(e.getMessage())); // 예외상황 발생 시 메시지 발송
			System.out.println(e.getMessage()); //에러코드도 함께.
		}

	}

}
