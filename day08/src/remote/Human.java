package remote;

public class Human {
	public static void main(String args []) {
		Remote remote = new Audio(); //또는 Tv
		//null 값에 어떤 '클래스(객체)'가 들어오냐에 따라 폴리머퓨즘을 구현 한다.
		remote.turnOn();
		remote.turnOff();
		
	}
}
