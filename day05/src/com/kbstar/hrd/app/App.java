package com.kbstar.hrd.app;

import com.kbstar.hrd.Employee;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee("100", "말숙", 500);
		System.out.println(e); //출력해줘 e를.
		System.out.println(e.getSalary()); //출력해줘 e의 월 급여를.
		System.out.println(e.getTax()); //e 직원의 세금이 얼만질 출력해줘
		System.out.println(e.getAnnSalary()); //연봉
		System.out.println(e.getAnnTax()); //연봉에 따른 세금
		
		System.out.println("===============================");
		
		Employee emps[] = new Employee[3];//Employee에 들어갈 수 있는 배열이름 : emps
		//이 배열에는 3개의 임플로이 객체가 들어갈 수 있다.
		emps[0] = new Employee("201", "홍말자", 400);
		emps[1] = new Employee("202", "정말자", 450);
		emps[2] = new Employee("203", "장말자", 480);

		//emps안에 들어가있는 type : 집합체 모두 끄집어낼거야.
		for(Employee em:emps) {
			System.out.println(em); //기본정보 모두 출력
			System.out.println(em.getTax()); //세금
			System.out.println(em.getAnnSalary()); //연봉
			System.out.println(em.getAnnTax()); //연봉에 따른 세금
		}
	}
	

}
