package com.kbstar.dto;

public class AccountDTO {
	private String accNo; //계좌번호
	private double balance; //계좌잔액
	private String holder; //누구의 계좌인지
	//1.디폴트 컨스트럭터
	public AccountDTO() {
	}
	//2. 컨스트럭터
	public AccountDTO(String accNo, double balance, String holder) {
		this.accNo = accNo;
		this.balance = balance;
		this.holder = holder;
	}
	//getter and setter
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	//출력정보
	@Override
	public String toString() {
		return "AccountDTO [accNo=" + accNo + ", balance=" + balance + ", holder=" + holder + "]";
	}



}
