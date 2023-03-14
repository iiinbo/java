package com.kbstar.dto;

import java.util.Date;

public class Cart {
	private String id;
	private String user_id;
	private String item_id;
	private int cnt;
	private Date regdate;
	
	//디폴트
	public Cart() {
	}
	//2.컨스트럭터
	public Cart(String id, String user_id, String item_id, int cnt, Date regdate) {
		this.id = id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.cnt = cnt;
		this.regdate = regdate;
	}
	//3.컨스트럭터(카트id는 자동생성되며, regdate도 자동생성)
	public Cart(String user_id, String item_id, int cnt) {
		this.user_id = user_id;
		this.item_id = item_id;
		this.cnt = cnt;
	}

	//4.
	public void Cart(String id, String item_id, int cnt) {
		this.id = id;
		this.item_id = item_id;
		this.cnt = cnt;
	}
	//getter and setter
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
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
		return "Cart [id=" + id + ", user_id=" + user_id + ", item_id=" + item_id + ", cnt=" + cnt + ", regdate="
				+ regdate + "]";
	}
	
	
	
}
