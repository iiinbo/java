package com.kbstar.dto;

public class ItemDTO {
	private String pd_id; //상품번호
	private String pd_name; //상품명
	private int price; //금액
	public ItemDTO() {
	}
	public ItemDTO(String pd_id, String pd_name, int price) {
		this.pd_id = pd_id;
		this.pd_name = pd_name;
		this.price = price;
	
	}
	
	
	public String getPd_id() {
		return pd_id;
	}
	public void setPd_id(String pd_id) {
		this.pd_id = pd_id;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "*주문내역 상세현황* 상품명 : "+ pd_name + " / 결제 완료금액 : " + price +"원 입니다.";
	}
	
}
