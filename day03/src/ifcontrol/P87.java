package ifcontrol;

public class P87 {

	public static void main(String[] args) {
		String grade = "";
		String gender = "M";
		int sum = 90;

		
		  System.out.println("start...."); 
		 
		if (gender.equals("M")) {
			System.out.println("male");
		} else {
			System.out.println("female");
		}
		
		//100 ~ 90 vip
		// 89~ 80
		// 79~70
		// 69~60
		// 59이하 노멀
		
		if(sum >= 90) {
			grade = "VIP";
		} else if (sum >= 80) {
			grade = "GOLD";
		} else if (sum >= 70) {
			grade = "SILVER";
		} else if (sum >= 60) {
			grade = "BRONZE";
		} grade = "NORMAL";
		
		
	//	
		if(grade.equals("VIP")) {
			  System.out.println("추가 혜택");
			   //if문 하나일 땐 리턴으로 행위를 끝낸다는 의미.end는 안나온다.
		}
		System.out.printf("%s, %s, %f\n", grade, gender, sum);

		System.out.println("end....");
	

	}
	
}	
