package variable;

public class p81_3 {

	public static void main(String[] args) {
		//90점 이상이면 a 80점 이상이면 b 그 외 f 
		int a = 95;
		String result = (a >= 90) ? "A" : (a >= 80) ? "B" : "F";
		System.out.println(result);
	}

}
