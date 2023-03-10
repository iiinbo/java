package ws0228;

public class App {

	public static void main(String[] args) {

		Manager mgr[] = new Manager[5];  // Manager 객체 생성
		Employee em[] = new Employee[5]; // Employee 객체 생성
		
		
		mgr[0] = new Manager("김진희", 100000, 100000);
		mgr[1] = new Manager("이성영", 200000, 200000);
		mgr[2] = new Manager("정인보", 300000, 300000);
		mgr[3] = new Manager("조현손", 400000, 400000);
		mgr[4] = new Manager("김국민", 500000, 500000);
		
		em[0] = new Employee("이뭉치", 1000000);
		em[1] = new Employee("송혜교", 2000000);
		em[2] = new Employee("아이유", 3000000);
		em[3] = new Employee("박서준", 4000000);
		em[4] = new Employee("김넛지", 5000000);

		for (Manager data : mgr) {
			System.out.printf("매니저 이름은 %s 월급은 %d원 보너스는 %d원입니다. \n", data.getName(), data.getSalary(), data.getBonus());
		}
		
	    System.out.println();
	    System.out.println("Manager 상세 정보를 출력합니다. ");
		for (Manager data2 : mgr) {
			System.out.printf("매니저 이름은 %s \t", data2.getName());
			System.out.printf("연봉(보너스 포함)은 %5.0f원 \t", data2.getAnnSalary()); // 연봉 계산식 호출
			System.out.printf("연봉에 대한 세금은 %5.2f원입니다. \n", data2.getTax()); // 세금 계산식 호출
		}
		
	    System.out.println();
	    // Employee 정보 출력
	    for(Employee data: em) {
	    	System.out.printf("직원 이름은 %s 월급은 %d원입니다.\n", data.getName(), data.getSalary());
	    }
	    
	    System.out.println();
	    // Employee 상세 정보 출력
	    System.out.println("Employee 상세 정보를 출력합니다. ");
	    for(int i=0; i < em.length; i++) {
	    	System.out.printf("직원의 이름은 %s \t", em[i].getName());
	    	System.out.printf("연봉은 %5.0f원 \t", em[i].getAnnSalary());  // 연봉 계산식 호출
	    	System.out.printf("연봉에 대한 세금은 %5.2f원입니다. \n", em[i].getTax());    // 세금 계산식 호출
	    }

	}
}