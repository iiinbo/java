package inherit2;

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
	//부모 클래스에 아래처럼 정해주면, getIncentive까지 일괄 출력이 가능하다. 오버라이딩가능!
	public double getIncentive() {
		return 0.0;
	}
	@Override
	public String toString() {
		return id+""+name+""+salary;
	}
	
}
