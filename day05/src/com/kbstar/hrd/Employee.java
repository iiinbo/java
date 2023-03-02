package com.kbstar.hrd;

public class Employee {
	private String id;
	private String name;
	private int salary;
	
	
	//디폴트 컨스트럭터(기본 생성자)
	public Employee() {
	}

	//2. 컨스트럭터
	public Employee(String id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	//getter and setter(가져오고 수정할 수 있게)
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
	
	//행위(기능)
	public double getTax() {
		double result = 0.0; //1-초기화 먼저 하고 / result는 해당 함수에서만 작용.
		result = this.salary *0.17; //3-정해준다.
		return result; //2-이 기능은 더블 값이 호출되게 한다.
		
	}
	

	public int getAnnSalary() {
		int result = 0; //위 result와 여기 랑 다름.
		result = this.salary * 12;
		return result;
	}
	public double getAnnTax() {
		double result = 0.0;
		result = this.getAnnSalary() *0.17; //겟샐러리가 가지고 있는 걸 먼저 계산한 뒤 *0.17할거야
		return result;
	}


	//객체의 정보를 출력하기 위해 toString (테스트목적으로)
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
