package inherit2;

public class App3 {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Manager(); //객체간 프로모션과 폴리머피즘구현가능
		Employee e3 = new Sales(); //상동
		
		Object obj1 = new Employee(); //자바에선 클래스마다 extends pbject가 생략되어있기 때문에,
		Object obj2 = new Manager();
		Object obj3 = new Sales();
		
	}

}
