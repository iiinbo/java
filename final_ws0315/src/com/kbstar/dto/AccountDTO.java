package com.kbstar.dto;

import com.kbstar.frame.MakeAccountNumber;

public class AccountDTO {
	private String accNum;
	private String accHolder;
	private double balance;
	
	public AccountDTO() {
		this.accNum = MakeAccountNumber.makeAccNum();
	}

	public AccountDTO(String accHolder, double balance) {
		this();
		this.accHolder = accHolder;
		this.balance = balance;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	//출력정보
	@Override
	public String toString() {
		return "AccountDTO [accNum=" + accNum + ", accHolder=" + accHolder + ", balance=" + balance + "]";
	}

}
