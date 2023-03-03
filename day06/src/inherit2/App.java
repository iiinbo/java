package inherit2;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee("1234567", "james", 500);
		System.out.println(e);
		System.out.println(e.getAnnSalary());
		
		Manager m = new Manager("8910234", "ann", 600, 55);
		System.out.println(m);
		System.out.println(m.getAnnSalary());
		
	}

}
