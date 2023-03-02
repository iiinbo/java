package aggregation;

public class Car {
	public String name; // 속성
	public String color;
	public int size;

	// public car() {} //디폴트 컨스트럭터는 자동으로 만들어진다(기본ㄴ생성자)
	// 생성자 (constructor)가 필요함 속성과 행위를 세팅해주는 역할
	public Car() {
		this.name = "k1";
		this.color = "red";
		this.size = 1000;
	}
    
	// 동일한 클래스이름이되, 다양한 속성을 별도로 줄 수도 있다. (오버로드라고 한다)
	// 여기서 () 안에 들어가는 내용은 아규먼트(넣어준단 뜻) //app2에서 new로 car를 생성할 때 바로 속성값을 입력했으니 퍼블릭
	// car 두번째가 실행되는 것
	public Car(String name, String color, int size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}

	public void go() {
		System.out.printf("%s, %s Go Car...", this.name, this.color); // 행위(오퍼레이션)
	}

	public void stop() {
		System.out.printf("%s, %s Stop Car...", this.name, this.color);
	}
}
