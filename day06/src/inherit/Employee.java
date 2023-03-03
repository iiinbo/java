package inherit;

public class Employee {
	private String id;
	private String name;
	private double salary;
	//디폴트
	public Employee() {
	}
	//컨스트럭터
	public Employee(String id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public double getAnnSalary() {
		double result = 0.0;
		result = this.salary * 12;
		return result;
	}
	//Manager에서 salary 접근할 수 있게 getSalary만 접근 허용해주기. 게터
	public double getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return id+""+name+""+salary;
	}
	
}
