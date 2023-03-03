package inherit;

public class Sales extends Employee {//employee한테 상속받고 싶으면 extends부터써줘
	private String loc;
	private double rate; //인사고과에 따라 추가 인센티브 제공하겠다. > getAnnSalary 재정의필요
	//디폴트
	public Sales() {
	}
	
	//2.컨스트럭터 생성
	public Sales(String id, String name, double salary, String loc, double rate) {
		super(id, name, salary);
		this.loc = loc;
		this.rate = rate;
	}

	
	//3.id랑 name이랑 salary만 입력하면 생성되도록. 컨스트럭터 생성(소스 - 수퍼)
	public Sales(String id, String name, double salary) {
		super(id, name, salary);
		
	}
	//재정의
	@Override
	public String toString() {
		return super.toString()+""+loc+""+rate;
	} //기존 출력정보에 loc랑 rate정보 추가해서 출력하겠다.
	
	//추가 인센티브 제공을 위한 getAnnSalary 재정의필요
	@Override
	public double getAnnSalary() {
		double result = 0.0;
		result = super.getAnnSalary() + (this.getIncentive() * 12);
		return result;
	}
	public double getIncentive() { //employee 에서 자식들이 쓸 수있게 get허용해줌
		double result = 0.0;
		result = getSalary() * this.rate;
		return result;
	}
	
	
}	
