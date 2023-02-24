

public class P85 {

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

		if (sum >= 90.0) {
			grade = "VIP";
			
		} else if (sum >= 70.0) {
			grade = "GOLD";
		} else {
			grade = "SILVER";
		}
		if(grade.equals("VIP")) {
			  System.out.println("추가 혜택");
			   //if문 하나일 땐 리턴으로 행위를 끝낸다는 의미.end는 안나온다.
		}
		System.out.printf("%s, %s, %f\n", grade, gender, sum);

		System.out.println("end....");
	

	}
	
}	
