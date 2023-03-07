package cal;

import java.util.Scanner;

public class CalUi2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Input 2 Number");
		double a = Double.parseDouble(sc.next());
		double b = Double.parseDouble(sc.next());
		double result = 0.0;
		
		try {
			result = Cal.div(a, b); 
			System.out.println(result);
		} catch (InfinitiyException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
