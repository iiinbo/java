package remote;

public class Audio implements Remote{
	
	//자동으로 Remote의 기능정의가 추가
	@Override
	public void turnOn() {
		System.out.println("Trun On Audio");
		
	}

	@Override
	public void turnOff() {
		System.out.println("Trun Off Audio");
		
	}

}
