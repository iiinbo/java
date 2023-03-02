package com.kbstar.hrd.app;

import com.kbstar.hrd.Manager;

public class App2 {

	public static void main(String[] args) {
		Manager m = new Manager();

		Manager ms[] = new Manager[3];
		// 이 배열에는 3개의 임플로이 객체가 들어갈 수 있다.
		ms[0] = new Manager("201", "홍말자", 400, 40);
		ms[1] = new Manager("202", "정말자", 450, 50);
		ms[2] = new Manager("203", "장말자", 480, 80);
		
		//for
		for(Manager data:ms) {
			System.out.println(data);
			System.out.println(data.getAnnSalary());
			System.out.println(data.getbonus());
		}
	}

}
