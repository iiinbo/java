package com.kbstar.frame;

public interface Notification {
	//1.사용자에게 메일을 보내고 문자를 보내는 기능 정의하는 인터페이스
	//2. 그다음 클래스 파일 만들고 im
	public void sendEmail(String email, String msg) throws Exception;
	public void sendSMS(String contact, String msg) throws Exception;
}
