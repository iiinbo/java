package oop2;

import java.util.Random;


public class Employee {
	private String id; //초기 컨스트럭터 세팅 이후는 접근이 불가하게.(수정안되게~)
	private String name; //개명 케이스도 있으니 접근통로 만들 수 있다.
	private int salary;
	
	public Employee() { //컨스트럭터1 : 초기입력
		this.id = "temp0001";
		this.name = "temp";
		this.salary = 10000000;
	}
	public Employee(String id, String name, int salary) {//컨스트럭터2 : 모두 수기로 입력해야하는 직원 
		this.id = id;
		this.name = name;
		if(salary < 0) { //월급은 마이너스일 수 없으니까~ 컨스트럭터 생성할 때 조건 넣어줄 수 있다.
			this.salary = 0;
		} else {
			this.salary = salary;	
		}
		
		
	}
	public Employee(String name, int salary) {//컨스트럭터3 : 이름과 월급만 입력하면 규칙에의해 자동으로 id채번되는 직원
		this("10000", name, salary); //매우중요. 여기서 this=나와동일한 첫번째 임플로이(컨스트럭터)를 호출한는 의미다.
	}
	
	
	public String getName() { //해당 객체의 이름을 가져올 수 있게
		return name;
	}
	public void setName(String name) { //해당 객체의 이름을 변경할 수 있게
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public int getSalary() {
		return salary;
	}
	public int getAnnSalary() {
		return this.salary *12; //만들어진 객체의 주소의 샐러리에서 12를 곱해라
	}
	public double getTax() {
		return this.salary * 0.175; //만들어진 객체의 주소의 샐러리에서 0.1을 곱해라
		//정수 * 실수 = 실수로 나온다.
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
