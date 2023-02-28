package oop1;

public class App2 {

	public static void main(String[] args) {
		Car car1 = new Car("k2", "blue", 2000); //오른쪽 new가 먼저 읽히고 그다음 왼쪽.
		//메모리가 먼저 입력되고, 그 다음 주소가 입력됨
		car1.go(); //car1 주소의 go를 실행해라~
		car1.stop(); 
		System.out.println("----------------------------------");
	
		Car car2 = new Car("k3", "white", 3000); //오른쪽 new가 먼저 읽히고 그다음 왼쪽.
		//메모리가 먼저 입력되고, 그 다음 주소가 입력됨
		car2.go(); //car2 렐퍼런스의 go를 실행해라~
		car2.stop(); 
	
	}

}
