package oop3;

public class Car {
	private String name; // 속성주기
	private String color;
	private int size;
	private int fsize; // 기름통 사이즈
	private int cfsize; // 현재 기름의 양

	// 생성자 컨스트럭터 만들기
	// 1. 디폴트 생성자(기본)
	public Car() {
	}

	// 2. 공장에서 방금 출고된 자동차의 경우 현재기름양 필요 없으므로.
	public Car(String name, String color, int size, int fsize) {
		this.name = name;
		this.color = color;
		this.size = size;
		this.fsize = fsize;
	}

	// 3. 또다른 케이스
	public Car(String name, String color, int size, int fsize, int cfsize) {
		this(name, color, size, fsize); // 2번 생성자랑 똑같이 할랭
		this.cfsize = cfsize;
	}

	// 출력해줘 아래내용을~
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", size=" + size + ", fsize=" + fsize + ", cfsize=" + cfsize
				+ "]";
	}

	// *행위 기술*
	// 기름을 넣는다
	// 기름통 사이즈(50리터)보다 많이 넣으면, 다시 주유하세요
	// -값 들어가면, 다시 주유하세요
	
	public void setCfsize(int size) {// size 변수의 의미이다. 아규먼트 x
		System.out.println("기름을 넣어주세요");
		if (size <= 0 || fsize < (size + cfsize)) {
			System.out.println("다시 주유하세요");
			return;
		} cfsize += size;
		System.out.println("주유가 완료되었습니다.");
	}

	// 주행을 한다., 주행거리 1리터당 10km를 주행할 수 있다. / 소진되면 못가게
	public void go(int distance) {
		if(cfsize < 0 || cfsize < (distance/10)) { //달리려고 하는 km보다 기름약이 부족해도 못가요
			System.out.printf("주유를 하신 뒤 출발이 가능합니다.");
			return;
		} System.out.printf("%s Go!", this.name, distance);
		  cfsize -= (distance/10);
		}
	

	// 멈춘다.
	public void stop() {
		if(cfsize <= 0) {
			System.out.printf("%s, %d Stop! 주유해 주세요.", this.name, cfsize);
			return;
		}
	}

}
