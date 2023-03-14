package com.kbstar.dto;

import java.util.Date;

public class Item {
	private String id; //상품번호
	private String name; //상품명
	private int price; //상품금액
	private double rate; //할인율
	private Date regdate; //등록일자
	
	//디폴트 컨스트럭터
	public Item() {
	}
	//2 컨스트럭터
	public Item(String id, String name, int price, double rate, Date regdate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rate = rate;
		this.regdate = regdate;
	}
	//3 컨스트럭터(사용)
	public Item(String name, int price, double rate) {
		this.name = name;
		this.price = price;
		this.rate = rate;
	}
	//gas
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	//출력정보
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", rate=" + rate + ", regdate=" + regdate
				+ "]";
	}
	
	
}
