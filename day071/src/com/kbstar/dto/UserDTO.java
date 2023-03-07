package com.kbstar.dto;

public class UserDTO { //data를 담아서 각 객체로 운반하는 역할
	private String id;
	private String pwd;
	private String name;
	//1. 디폴트 컨스트럭터
	public UserDTO() {
	}
	//2. 기본
	public UserDTO(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	//getter and setter
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
	//출력정보 모두 다.
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}
	
}
