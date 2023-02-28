package ws0228;

public class Employee {

	private String name ;
	private int salary ;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	// 이름 출력
	public String getName() {
		return this.name;
	}
	
	// 급여 출력
	public int getSalary() {
	     return salary;
	}
	
	// 연봉 출력
	public double getAnnSalary() {
		return (this.salary*12);
	}
	
	// 세금 출력 (연봉 x 0.175)
	public double getTax() {
		return ((this.salary*12) * 0.175);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}


}
