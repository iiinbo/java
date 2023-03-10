package statics;

public class Test {

	public static void main(String[] args) {
		Car c1 = new Car("K1","Kia");
		System.out.println(c1);

		Car c2 = new Car("gen10",Car.makername); 
		//makername 변수는, c2라는 객체는 관여 못하지만, Car라는 Class파일에선 사용할 수 있기에 좌측처럼 사용.(class명.makername)
		System.out.println(c2);
	}

}
