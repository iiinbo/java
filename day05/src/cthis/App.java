package cthis;

import java.util.Date;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee("이말순", 500);
		// 이름과 셀러리만 입력했어. id는 자동생성해줘
		System.out.println(e);

		Employee e2 = new Employee("이말순2", 500);
		// 이름과 셀러리만 입력했어. id는 자동생성해줘
		System.out.println(e2);

		Date d = new Date();
		java.sql.Date dd = new java.sql.Date(0);//똑같은 이름을 가진 다른 클래스를 쓰고싶다면 이렇게.
		
	}
}
