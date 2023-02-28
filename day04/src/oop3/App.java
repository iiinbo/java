package oop3;

public class App {

	public static void main(String[] args) {
		Car car = new Car("C1", "red", 1000, 50); //1000cc, 50리터가 디폴트
		System.out.println(car.toString()); //초기 자동차 출력해줘
		//지정하지 않은 cf사이즈는 초기화 되어있는 것을 확인할 수 있다.
		
		car.go(10);
		car.setCfsize(30);
		car.go(10);
		System.out.println(car.toString());
		
	}
	

}
