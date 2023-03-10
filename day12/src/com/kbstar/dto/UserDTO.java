package com.kbstar.dto;

public class UserDTO { //data를 담아서 각 객체로 운반하는 역할
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String contact; //연락처
	
	//1. 디폴트 컨스트럭터
	public UserDTO() {
	}
	//2. 기본
	public UserDTO(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	//3. 컨스트럭터
	public UserDTO(String id, String pwd, String name, String email, String contact) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.contact = contact;
	}
	//getter and setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//출력정보
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", Email=" + email + ", contact=" + contact
				+ "]";
	}
	
	
}
