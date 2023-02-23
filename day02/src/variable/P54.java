package variable;

public class P54 {

	public static void main(String[] args) {
		//boolean
		boolean b1 = 10 > 5;
		
		//정수
		int n1 = 10;
		long n2 = 0L;
		n2 = 222222222222L;
		
		//실수
		double d1 = 1.0;
		float f1 = 1.0F;
		
		double d3 = 10.0/3.0;
		System.out.println(d3);
		
		float d4 = 10.0F/3.0F;
		System.out.println(d3);
		
		//char캐릭터
		char c1 = 'A';
		System.out.println(c1);
		
		char c2 = 65;
		System.out.println(c2);
		
		//int 와 double이 만날 경우, int -> double 로 치환해줄 것.
		//int로 변환하는건 리스크가 있어서.
		int n3 = 10;
		double n4 = 10.0;
		double result = n3 + n4;
		
	}

}
