package lotto;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lotto lotto = new Lotto();
		int grade = 0; //등수 선언(while문 밖에 선언)
		while(true) {
			System.out.println("Input cmd..(q.s.c.p)");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				break;
			}else if(cmd.equals("s")) {
				System.out.println("Make Number and Prize Money");
				lotto.makeWinningNumberMoney();
			}else if(cmd.equals("c")) {
				System.out.println("Input 3 number :");
				int num1 = Integer.parseInt(sc.next());
				int num2 = Integer.parseInt(sc.next());
				int num3 = Integer.parseInt(sc.next());
				ArrayList<Integer> nums = new ArrayList<Integer>();
				nums.add(num1);
				nums.add(num2);
				nums.add(num3);
				try {
					grade = lotto.checkRanking(nums);  //내가 입력한 3개 숫자와, 당첨번호가 일치하는게 몇개인지 확인 후 등수체크하는 기능
				} catch (Exception e) { //1~3등이 아니면 예외로 넘어감.
					System.out.println(e.getMessage());//단, 0개 맞출 경우 0등으로 출력되는데, 해당 문구를 직관적으로 변경하기 위해 예외처리.
					continue; //여기서 컨디뉴 만나면 밑으로 실행 하나도 안되고, while문 초기로 돌아간다.
				}
				System.out.println(grade); //정상일 경우 나의 등수출력
				
				
			}else if(cmd.equals("p")) {
				System.out.printf("총 당첨금 %4.1f\n",lotto.getPrizeMoney());
				System.out.printf("당신의 등수 %d\n",grade);
				System.out.printf("당신의 당첨금 %4.0f\n",lotto.prizeMoney(grade));
			}
		}
		sc.close();
	}

}