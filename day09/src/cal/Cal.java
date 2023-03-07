package cal;

public class Cal { //계산기능만들기
	//오버로딩(함수명동일, 아규먼트 다름)
	//static이라고 쓰면, 기능만 정의한 Cal을 사용할 수 있다.
	public static double div(int a, int b) throws Exception {
		double result = 0.0;
		try {
			result = a / b; //이과정에서 에러나면
		} catch(Exception e) {
			throw e; //에러를 '화면으로' 던져줘!
		}
		return result;
	}
	public static double div(double a, double b) throws InfinitiyException {
		double result = 0.0;
		if(b == 0.0) { //나눈게 0.0으로 나오면 b0001 에러를 화면으로 throw한다.
			throw new InfinitiyException("B0001");
		}
		result = a / b;
		return result;
	}
}
