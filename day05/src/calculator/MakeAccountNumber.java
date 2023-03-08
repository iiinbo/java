package calculator;

import java.util.Calendar;

public class MakeAccountNumber {
	//static : 여기서 쓴 변수는 객체로 사용 안하고, 함수 기능으로만 사용할거야. 속성 없어.
	public static String makeAccNum() {
		String accNum = "";
		Calendar cal = Calendar.getInstance();
		accNum = ""+ cal.get(Calendar.YEAR)
		+ cal.get(Calendar.MONTH)+1
		+ cal.get(Calendar.DAY_OF_MONTH)
		+ cal.get(Calendar.MILLISECOND);
		return accNum;
	}
}
