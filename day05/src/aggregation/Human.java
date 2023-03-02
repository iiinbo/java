package aggregation;

public class Human {
	private String name;
	private Car car; // 사람은 차를 가지고있다.

	// 디폴트
	public Human() {
	}

	// 컨스트럭터 : 이름과 차정보 모두 있을 때
	public Human(String name, Car car) {
		this.name = name;
		this.car = car;
	}

	// 컨스트럭터 : 이름만 있을 때(차소유x)
	public Human(String name) {
		this.name = name;
	}

	// getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	// 출력할 정보
	@Override
	public String toString() {
		return "Human [name=" + name + ", car=" + car + "]";
	}

	public void drive() {
		car.go();
	}

	public void stopCar() {
		car.stop();
	}
}
