package ws0309;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	private HashSet<Integer> winningNum; // 당첨번호
	private double prizeMoney; // 상금
	private int rank;

	Random rd = new Random();

	public Lotto() {
		winningNum = new HashSet<Integer>();
	}

	public void makeWinningNumberMoney() {
		// 당첨번호를 랜덤으로 생성한다. // 1~25까지 숫자 add. 총 3개 랜덤하게 생성
		while (winningNum.size()<3) {
			winningNum.add(rd.nextInt(25)+1); 
		}
		// 당첨금을 랜덤으로 생성한다.
		prizeMoney = ((rd.nextInt(1000000000)+1)*1.0) + ((rd.nextInt(1000000000)+1)*1.0) ;
		
	}

	public int checkRanking(ArrayList<Integer> myNum) {
		int grade = 0; // 등수
		int cnt = 0; // 일치 갯수 확인

		for (Integer data : myNum) {
			if (winningNum.contains(data)) {
				cnt++;
			}
		}

		// 1등 : 3개 일치
		if (cnt == 3) {
			grade = 1;
			// 2등 : 2개 일치
		} else if (cnt == 2) {
			grade = 2;
			// 3등 : 1개 일치
		} else if (cnt == 1) {
			grade = 3;
			// 4등 : 0개 일치
		} else {
			grade = 4;
		}
		return grade;
	}

	// 로또번호 사용자에게 입력 받는 함수
	public ArrayList<Integer> getNumUser() {
		ArrayList<Integer> userNum = new ArrayList<>(); // 사용자의 로또번호 set
		int num = 0; // 사용자에게 받는 번호
		Scanner sc = new Scanner(System.in);

		// 1~25까지 숫자 3개를 받아 넣어준다.
		System.out.println("== 1~25까지의 숫자 3개를 입력 받겠습니다. ==");
		while (userNum.size() < 3) {
			System.out.println("== 숫자를 입력해주세요 ==");
			try {
				num = Integer.parseInt(sc.next());
				if (!(num >= 1 && num <= 25)) {
					System.out.println("== 1~25까지의 숫자를 입력해주세요 ==");
				} else {
					if (userNum.contains(num)) {
						System.out.println("== 중복된 숫자가 있어 재입력 바랍니다 ==");
					} else {
						userNum.add(num); // set에 추가
						System.out.println("== " + userNum.size() + "개 입력되었습니다 ==");
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("== 숫자로 입력해주세요 ==");
			}
		}
		makeWinningNumberMoney(); // 당첨번호를 생성한다.
		
		return userNum;
	}

	// 사용자가 입력한 로또번호를 출력하는 함수
	public void showNumber(ArrayList<Integer> list) {
		System.out.println("== 로또 번호를 출력합니다 ==");

		if (list != null) {
			for (Integer data : list) {
				System.out.print(data + " ");
			}
			System.out.println("");
		} else {
			System.out.println("== 조회할 내용이 없습니다. 로또번호를 생성해보세요! ==");
		}
	}
	
	// 당첨번호 가져오기
	public HashSet<Integer> getWinningNum() {
		return winningNum;
	}
	
	// 등수 가져오기
	public int getRank() {
		return rank;
	}

	// 상금 가져오기
	public double prizeMoney(int grade) {
		
		// 1등
		if (grade == 1) {
			return (prizeMoney*0.6); // 60%
		// 2등
		} else if (grade == 2) {
			return (prizeMoney*0.2); // 20%
		// 3등
		} else if (grade == 1) {
			return (prizeMoney*0.2); // 20%
		// 4등
		} else {
			return 0.0 ; // 0%
		}

	}
	
	//전체 상금 가져오기
	public double getPrizeMoney() {
		return prizeMoney;
	}
	
	// 체크용
	public void check(ArrayList<Integer> myNum) {
		int grade = 0; // 등수
		int cnt = 0; // 일치 갯수 확인

		for (Integer data : myNum) {
			if (winningNum.contains(data)) {
				cnt++;
			}
		}

		// 1등 : 3개 일치
		if (cnt == 3) {
			grade = 1;
			// 2등 : 2개 일치
		} else if (cnt == 2) {
			grade = 2;
			// 3등 : 1개 일치
		} else if (cnt == 1) {
			grade = 3;
			// 4등 : 0개 일치
		} else {
			grade = 4;
		}
		
		System.out.print("체크용: ");
		System.out.println("grade "+grade+", "+"cnt "+cnt);
	}
	
	
}