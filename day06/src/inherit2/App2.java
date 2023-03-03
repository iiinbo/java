package inherit2;

public class App2 {

	public static void main(String[] args) {
		//*Manager is a Employee* 개념설명. 매우중요매우중요
		//*상속*을 통해 한번에 관리하고 배열도 만들고 출력할 수 있다!!!
		Employee e = new Manager("100","말순", 500, 50);
		
		Employee ea[]= new Employee[5];
		ea[0] = new Employee("200","말순2", 500);
		ea[1] = new Employee("201","말순3", 500);
		ea[2] = new Manager("202","말순4", 500, 50);
		ea[3] = new Manager("203","말순5", 500, 50);
		ea[4] = new Sales("204","말순6", 500, "seoul", 0.35);
		
		for(Employee data:ea) {
			System.out.println(data);
			System.out.println(data.getAnnSalary());
			System.out.println(data.getIncentive());
	
			
			//Employee :월급여*12
			//Manager : (월급여+보너스) *12로
			//출력은 한번에 해도 사전에 정의&재정의된 기법으로 출력된다.=> 다 형 성
			//다향성으로 오버라이딩 하면 아래 if문을 안사용해도 인센티브까지 추출이 가능함
			//if(data instanceof Sales) { //배열에서 가져온 객체가 sales 객체의 타입이면? 비교할 때 쓴다.
				//Sales s = (Sales)data; //Sales 타입으로 바꿔죠
				//System.out.println(s.getIncentive());
			}
		System.out.println("=====================================");
		TaxCal t = new TaxCal();
		double result = t.getTax(ea[1]);
		System.out.println(result);
		}
	}


