package com.kbstar.hrd;

public class Manager {
	private String id;
	private String name;
	private int salary;
	private int bonus;

	
	//디폴트 컨스트럭터
	public Manager() {
	}
	//2. 컨스트럭터
	public Manager(String id, String name, int salary, int bonus) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	//게터 앤 세터
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public int getSalary() {
		return salary;
	}
	public int getBonus() {
		return bonus;
	}
	
	//행위 기능
	//연봉
	public int getAnnSalary() {
		int result = 0; //위 result와 여기 랑 다름.
		result = this.salary * 12;
		return result;
	}
	//연봉에 따른 세금
	public double getTax() {
		double result = 0.0;
		result = (this.salary*12) * 0.175;
		return result;
	}
	//보너스에 따른 세금
	public double getbonus() {
		double result = 0.0;
		result = bonus*0.2;
		return result;
	}
	
	
	//객체의 정보를 출력하기 위해 toString (테스트목적으로)
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", bonus=" + bonus + "]";
	}
	
	
}
