package com.kbstar.noti;

import com.kbstar.frame.Notification;

public class NotificationImpl implements Notification {

	@Override
	public void sendEmail(String email, String msg) throws Exception {
		System.out.printf("%s에게 %s 전송합니다.\n", email,msg);
		
	}

	@Override
	public void sendSMS(String contact, String msg) throws Exception {
		System.out.printf("%s에게 %s 전송합니다.\n", contact,msg);
		
	}

}
