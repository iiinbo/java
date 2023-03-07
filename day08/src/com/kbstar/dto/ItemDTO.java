package com.kbstar.dto;

public class ItemDTO  { //화면에서 입력된 값을 service와 dao로 운반하는 역할.
	private int id; //프라이머리key : int
	private String name;
	private double price;
	private int qt;
	public ItemDTO() {
	}
	public ItemDTO(int id, String name, double price, int qt) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.qt = qt;
	}
	//getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	@Override
	public String toString() {
		return "ItemDTO [id=" + id + ", name=" + name + ", price=" + price + ", qt=" + qt + "]";
	}
	
	
}
