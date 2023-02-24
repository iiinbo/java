package ifcontrol;

public class P88 {

	public static void main(String[] args) {
		String grade = "";
		String gender = "M";
		double sum = 80.0;

		
		  System.out.println("start...."); 
		 
		if (gender.equals("M")) {
			System.out.println("male");
		} else {
			System.out.println("female");
		}
//
		//100~95 또는 90~85 브잎
		//80~75 또는 60~65 골드
		//나머진 노멀
		
		if((sum <= 100 && sum >= 95.0) || (sum <= 90 && sum >= 85.0)) {
			grade = "VIP";
		} else if((sum <= 80.0 && sum>= 75.0) || (sum <= 60.0 && sum >= 65.0)) {
			grade = "GOLD";
		} else {grade = "NORMAL";}
		//
		
		
		
		
		
//		
		if(grade.equals("VIP")) {
			  System.out.println("추가 혜택");
			   //if문 하나일 땐 리턴으로 행위를 끝낸다는 의미.end는 안나온다.
		}
		System.out.printf("%s, %s, %f\n", grade, gender, sum);

		System.out.println("end....");
	

	}
	
}	
