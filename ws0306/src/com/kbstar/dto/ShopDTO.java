package com.kbstar.dto;

public class ShopDTO {
	private String sh_address; //매장주소
	private String sh_name; //매장이름
	private int sh_contact; //매장연락처
	private int sh_op; //매장운영시간
	public ShopDTO() {
	}
	public ShopDTO(String sh_address, String sh_name, int sh_contact, int sh_op) {
		this.sh_address = sh_address;
		this.sh_name = sh_name;
		this.sh_contact = sh_contact;
		this.sh_op = sh_op;
	}
	
	
	public String getSh_address() {
		return sh_address;
	}
	public void setSh_address(String sh_address) {
		this.sh_address = sh_address;
	}
	public String getSh_name() {
		return sh_name;
	}
	public void setSh_name(String sh_name) {
		this.sh_name = sh_name;
	}
	public int getSh_contact() {
		return sh_contact;
	}
	public void setSh_contact(int sh_contact) {
		this.sh_contact = sh_contact;
	}
	public int getSh_op() {
		return sh_op;
	}
	public void setSh_op(int sh_op) {
		this.sh_op = sh_op;
	}
	@Override
	public String toString() {
		return "ShopDTO [sh_address=" + sh_address + ", sh_name=" + sh_name + ", sh_contact=" + sh_contact + ", sh_op="
				+ sh_op + "]";
	}
	
}
