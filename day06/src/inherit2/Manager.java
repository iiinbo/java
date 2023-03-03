package inherit2;

public class Manager extends Employee{ //employee한테 상속받고 싶으면 extends부터써줘
	private double bonus; //상속받은거 이외 추가되는 것만 filde에 추가! 끝. 컨스트럭터만 상속불가하고 나머진 다 상속(함수, 메소드)
	//부모 컨스트럭터를 참고해서 그대로 가져올 순 있음.(소스 - 수퍼)
	public Manager() {
		super();
		
	}
	//부모 컨스트럭터를 참고해서 그대로 가져올 순 있음. 없어도 무방
	public Manager(String id, String name, double salary) {
		super(id, name, salary);
		
	}
	//보너스의 컨스트럭터는 별도 구현해야한다. / 경로 : 소스 - 유징컨스트럭터에서 가져온 것.
	public Manager(String id, String name, double salary, double bonus) {
		super(id, name, salary);
		this.bonus = bonus;
	}
	//게터 앤 세터(보너스 가져오고 변경할 수 있게)
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	//toString을 매니저에서 다시 정의해준다. 필요시! 재정의 -> 오버라이딩!!
	@Override
	//나만의 연봉계산을 따로 다시 정의
	public double getAnnSalary() {
		double result = 0.0;
		result = super.getAnnSalary()+(this.bonus*12);
		//result = (this.getSalary() + this.bonus)*12; 위에처럼 표현도 가능
		//this(매니저의~~), salary가 private면 접근이 안돼~ protected로 변경
		//protected로 못바꾸면, private로 놔두고, 게터세터에서 허용만 해주기~
		return result;
	}
	//매니저는 보너스가 얼마고, 상위의 tostring정보도 호출할거다~
	@Override
	public String toString() {
		return super.toString()+""+bonus;
	}
	




}
