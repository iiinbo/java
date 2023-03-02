package overloading;

//아규먼트가 다르면 sum 이라고 동일하게 사용가능해! 이게 오버로딩

public class Calculator {
	public int sum(int a,double b) {
		int result = 0;
		result = a+(int)b;
		return result;
	}
	public int sum(int a,int b, int c) {
		int result = 0;
		result = a+b+c;
		return result;
	}
	public int sum(int a,int b, int c, int d) {
		int result = 0;
		result = a+b+c+d;
		return result;
	}
	
}
