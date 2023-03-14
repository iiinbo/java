package com.kbstar.frame;

import java.util.Calendar;

public class MakeItemNumber {
	public static int cnt = 100;
	public static int cnt2 = 100;
	public static String makeItemNum() { //item의 id값 생성하는 키워드
		String trNum = "";
		Calendar cal = Calendar.getInstance();
		trNum = "" + cal.get(Calendar.YEAR)
		            + (cal.get(Calendar.MONTH)+1)
		            + cal.get(Calendar.DAY_OF_MONTH)
		            + cal.get(Calendar.MILLISECOND)
		            + cnt2;
		cnt2++;
		return trNum;
	}
	public static String makeCartNum() { //카트의 id번호 생성 키워드
		String accNum = "";
		Calendar cal = Calendar.getInstance();
		accNum = "" + cal.get(Calendar.YEAR)
		            + (cal.get(Calendar.MONTH)+1)
		            + cal.get(Calendar.DAY_OF_MONTH)
		            + cal.get(Calendar.MILLISECOND)
		            + cnt;
		cnt++;
		return accNum;
	}
}
