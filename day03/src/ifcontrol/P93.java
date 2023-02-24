package ifcontrol;

import java.util.Scanner;

public class P93 {

	public static void main(String[] args) {
		//1. 숫자 4개를 입력 받는다.
		//2. 단, 2자리수가 아니면 프로그램 종료한다.
		//평균과 합계를 구한다.
		//평균이 90 이상이면 A /  80이상 B / 70이상 C / 60이상 D / 미만 f
		//합계, 평균, 학점을 출력하라.
		
		Scanner sc = new Scanner(System.in);
		int ko = 0;
		int en = 0;
		int ma = 0;
		int si = 0;
		System.out.println("국어성적 입력 : ");
		ko = Integer.parseInt(sc.next()); //string으로 입력 -> 정수로
		if(!(ko>=10 && ko<=99)) { // 2자리수가 아니면 프로그램 종료한다.
	         sc.close();
	         return;
	      }
		
		System.out.println("영어성적 입력 : ");
		en = Integer.parseInt(sc.next()); //string으로 입력 -> 정수로
		if(!(en>=10 && en<=99)) { // 2자리수가 아니면 프로그램 종료한다.
	         sc.close();
	         return;
	      }
		System.out.println("수학성적 입력 : ");
		ma = Integer.parseInt(sc.next()); //string으로 입력 -> 정수로
		if(!(ma>=10 && ma<=99)) { // 2자리수가 아니면 프로그램 종료한다.
	         sc.close();
	         return;
	      }
		System.out.println("과학성적 입력 : ");
		si = Integer.valueOf(sc.next()); //string으로 입력 -> 정수로
		if(!(si>=10 && si<=99)) { // 2자리수가 아니면 프로그램 종료한다.
	         sc.close();
	         return;
	      }
		
		
		int[] score = {ko, en, ma, si}; //배열 만들기
		
		
		int total = 0;
		double avg = 0.0;
		String grade = "";
		
		//배열에 저장된 값 모두 추출해서 total 변수에 더함 *검색*
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}
		avg = total / (double) score.length;
		
		/*
		 * if(avg >= 90) { grade = "A"; } else if (avg >= 80) { grade = "B"; } else if
		 * (avg >= 70) { grade = "C"; }else if (avg >= 60) { grade = "D"; } else {grade
		 * = "F"; }
		 */
		
		//삼항연산자로 변경
		grade = (avg >= 90) ? "A" : (avg >= 80) ? "B" : (avg >= 70) ? "C" :  (avg >= 60) ? "D" : "F";
		
		System.out.printf("합계: %d, 평균: %4.2f, 학점: %s", total, avg , grade);
		sc.close();
	}
}
