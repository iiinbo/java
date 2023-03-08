package bank;

public class MakeMessage {
	public static String makeMessage(String code) {
		//에러메세지 심플
		String result = "";
		switch(code) {
		case "ER0001" : result="계좌개설 실패..";
		break;
		case "ER0002" : result="음수입력 재거래 요청";
		break;
		case "ER0003" : result="잔액 부족";
		break;
		default : result = "고객센터에 문의바랍니다."; //case 외 에러발생 시 문구
		}
		
		return result;
	}
}
