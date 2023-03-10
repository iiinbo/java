package com.kbstar.frame;

public class MakeMessage {
	public static String makeMessage(String code) {
		//에러메세지 코드가 일치하면 result에 입력한 문구가 나온다.
		//코드도 같이 뽑고 싶으면, app에 프린트 *2번 하면 됨.
		String result = "";
		switch(code) {
		case "ER0001" : result="계좌개설에 실패했습니다.";
		break;
		case "db DE0001" : result="계좌해지에 실패했습니다. 계좌정보가 존재하지 않습니다.";
		break;
		case "db UP0001" : result="계좌 정보수정에 실패했습니다.";
		break;
		case "ER0002" : result="음수를 입력하셨습니다. 재거래 바랍니다.";
		break;
		case "ER0003" : result="잔액이 부족합니다.";
		break;
		case "EX0004" : result="id가 중복되었습니다. 다른 id로 설정해주시기 바랍니다.";
		break;
		case "PE0002" : result="주문상품이 품절되었습니다. 다른 상품을 담아주시기 바랍니다.";
		break;
		default : result = "고객센터에 문의바랍니다."; //case 외 에러발생 시 문구
		}
		
		return result;
	}
}
