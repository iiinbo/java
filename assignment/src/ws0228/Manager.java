package ws0228;

public class Manager {
	private String name;
	private int salary;
	private int bonus;
	
	
	public Manager() {
	}
	
	
	public Manager(String name, int salary, int bonus) {
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
		}


	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}
	
	public double getAnnSalary() {
		return (this.salary * 12) + this.bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public double getTax() {
		return ((this.salary*12) + (this.bonus)) * 0.175; // 정수 * 실수 = 실수
	}


	@Override
	public String toString() {
		return "Manager [name=" + name + ", salary=" + salary + ", bonus=" + bonus + "]";
	}



	
}
