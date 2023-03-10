package statics;

public class Car {
	private String name;
	private String maker;
	public static String makername = "HD"; //static은 객체 생성될 때 관여를 안함.
	//디폴트
	public Car() {
	}

	public Car(String name) {
		this.name = name;
	}
	
	public Car(String name, String maker) {
		this.name = name;
		this.maker = maker;
	}
	
	//출력정보
	@Override
	public String toString() {
		return "Car [name=" + name + ", maker=" + maker + "]";
	}
	
	

	
	
}
