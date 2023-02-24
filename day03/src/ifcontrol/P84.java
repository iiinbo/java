package ifcontrol;

public class P84 {

	public static void main(String[] args) {
		String grade = "";
		String gender = "W";
		double sum = 79.0;

		
		/*
		 * System.out.println("start....");
		 * 
		 * if (gender.equals("M")) { System.out.println("male"); } else {
		 * System.out.println("female"); }
	
		 */
		
//첫번째 방식(단순 나열)
		
		if(gender.equals("M") && sum >= 90.0) {
			grade = "MVIP";
		} else if(gender.equals("W") && sum >= 90.0) {
			grade = "FVIP";
			
		} if(gender.equals("M") && sum >= 80.0) {
			grade = "MGOLD";
		} else if(gender.equals("W") && sum >= 80.0) {
			grade = "FGOLD";
		}
		
		if(gender.equals("M") && sum < 80.0) {
			grade = "MNORMAL";
		} else if(gender.equals("W") && sum < 80.0) {
			grade = "FNORMAL";
		}
		
//두번째 방식 (남과 여로 먼저 나눈다.)
		if(gender.equals("M")) {
			if (sum >= 90.0) {
				grade = "MVIP";
			} else if(sum >= 80.0) {
				grade = "MGOLD";
			} else {grade = "MNORMAL";}
		}
		
		if(gender.equals("W")) {
			if (sum >= 90.0) {
				grade = "FVIP";
			} else if(sum >= 80.0) {
				grade = "FGOLD";
			} else {grade = "FNORMAL";}
		}
		
		
//스위치문 + case문 안에 break; 와 함께 *실수는 못들어간다.
//break가 아래처럼 사라지면, 맨 상위에 있는 vip들은 하위에 있는 점수를 계속 받을 수 있다.
		//이는 if문에서 구현이 불가하므로 차이점이다.
		switch(grade) {
		case "FVIP" : 
		case "MVIP" :
			sum += 100;
		case "FGOLD" :
		case "MGOLD" :
			sum += 90;
		default :
			sum += 10;
		}
		
		
		
		
		System.out.printf("%s, %s, %f\n", grade, gender, sum);

		System.out.println("end....");
	

	}
	
}	
