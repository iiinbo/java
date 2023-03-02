package aggregation;

public class App {

	public static void main(String[] args) {
		Human human = new Human("James");
		//차없는 사람부터
		System.out.println(human);

		//차 있는 사람 만들기
		Car car = new Car("k1", "red", 1000);
		human.setCar(car);
		System.out.println(human);
		
		human.drive();
		human.stopCar(); 
	}

}
