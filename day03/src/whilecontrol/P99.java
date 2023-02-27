package whilecontrol;

public class P99 {

	public static void main(String[] args) {
		out: //(=myfor: //의미 : break 만나면 전체 멈추게 한다.)
		for (int i = 2; i < 10; i++) {
			System.out.printf("%d 단 \n", i);
			
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d \t", i, j, (i * j));
				if(i * j == 21) {
					break out;
				}
			}
				System.out.println(""); //2번째 for문 끝나고 다음줄로
		}
	}

}