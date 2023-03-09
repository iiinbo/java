package com.kbstar.dto;

public class TransactionDTO {
	private String date; //거래일시 : key값
	private String accNo; //계좌번호
	private double balance; //금액
	private String type; //I : 입금, O : 출금
	private String desc; //거래명
	//1. 디폴트 컨스트럭터
	public TransactionDTO() {
	}
	//2.컨스트럭터
	public TransactionDTO(String date, String accNo, double balance, String type, String desc) {
		this.date = date;
		this.accNo = accNo;
		this.balance = balance;
		this.type = type;
		this.desc = desc;
	}
	//getter and setter
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	//출력정보
	@Override
	public String toString() {
		return "TransactionDTO [date=" + date + ", accNo=" + accNo + ", balance=" + balance + ", type=" + type
				+ ", desc=" + desc + "]";
	}
	
	
}
