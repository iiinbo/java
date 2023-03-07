package com.kbstar.dto;


public class AccountDTO {
	private String accNum;
	private String accName;
	private double balance;

	// 디폴트 컨스트럭터
	public AccountDTO() {
	} 
	// 2.
	public AccountDTO(String accNum, String accName, double balance) {
		this.accNum = accNum;
		this.accName = accName;
		this.balance = balance;
	}



	// 상태확인 테스트목적
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accName=" + accName + ", balance=" + balance + "]";
	}

	// 게터 앤 세터 : 잔액조회 가능함. 잔액가져오기
	public double getBalance() {
		return balance;
	}

	// 입금
	public void deposit(double money) {
		if (money <= 0) {
			System.out.println("입금금액을 확인하세요");
			return;
		}
		this.balance += money;

	}

	// 출금
	public void withdraw(double money) {
		if (money <= 0) {
			System.out.println("출금금액을 확인하세요");
			return;
		}
		if (this.balance < money) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		this.balance -= money;
	}

}
