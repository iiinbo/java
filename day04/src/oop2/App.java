package oop2;

public class App {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		System.out.println(e1.toString()); //출력해줘
		
		
		Employee e2 = new Employee("이말숙",5000000); //컨스트럭터 3 예시
		
		
		System.out.println(e2.toString()); //출력해줘
		System.out.println(e2.getAnnSalary()); //e2 객체의 월급*12 = 연봉을 출력해줘
		System.out.println(e2.getTax()); //e2 객체의 세금을 출력해줘
		
		e2.setName("이말자"); //개명한 이름을 넣기 -> toString에서 변ㄴ경된 이름 출력됨
		System.out.println(e2.toString()); //출력해줘
	}

}
