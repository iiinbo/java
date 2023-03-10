package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Lotto {
	private HashSet<Integer> winningNum; // 로또 당첨번호
	private double prizeMoney; // 당첨금
	
	public Lotto() {
	winningNum = new HashSet<Integer>(); //디폴트 컨스트럭터에 생성
	}
	//getter : 총 당첨금 확인하기
	public double getPrizeMoney() {
		return prizeMoney;
	}

	public void makeWinningNumberMoney() {
		//번호 생성, 당첨금 생성
		//prizeMoney가 double로 선언되었기에 실수로 들어간다.
		Random r = new Random();
		prizeMoney = r.nextInt(2000000000)+1;
		while(winningNum.size() < 3) {
			int rn = r.nextInt(25)+1; //rn(랜덤넘버)은 1~25의 숫자
			winningNum.add(rn); //add(넣는다) rn을(랜덤넘버를)
		}
		//출력오류 없는지 보기 위해 확인
		System.out.println(prizeMoney);
		System.out.println(winningNum.toString()); //for each문 안돌려도 나올 수 있다.
	}
	//내가 입력한 번호가 몇개 맞았는지 확인하는 기능
	public int checkRanking(ArrayList<Integer> myNum) throws Exception { //myNum은 사용자가 입력한 번호
		int grade = 0;
		int cnt = 0;
		for(int data : myNum) { //내가 입력한 숫자
			for(int pdata : winningNum) { //winningNum 여기 담긴 pdata는 당첨번호
				if(myNum.equals(winningNum)) {
				cnt++;//당첨번호와 사용자번호가 같을 때만! 카운트 증가.
				}
			} 
		}
		//cnt 개수가 곧 등수.
		switch(cnt) {
		case 3: grade=1; break;
		case 2: grade=2; break;
		case 1: grade=3; break;
		default: throw new Exception("꽝입니다."); //미당첨 시 0등이라고 나오는 것 보다 분명하게 예외 처리
		}
		
		return grade; //당첨개수에 따라 등수로 리턴
	}
	public double prizeMoney(int grade) {
		double pMoney = 0.0;
		switch(grade) {
		case 1: pMoney = prizeMoney *0.7; break;
		case 2: pMoney = prizeMoney *0.2; break;
		case 3: pMoney = prizeMoney *0.1; break;
		default: pMoney = 0.0;
		}
		return pMoney;
	}
	
}
