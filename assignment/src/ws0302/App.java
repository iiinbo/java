package ws0302;

import ws0302.Account;

public class App {

	public static void main(String[] args) {
		//1. 6개의 Account 객체 배열만들기
		Account[] acc = new Account[6]; //이름, 입금금액, 이자율, 등급
		acc[0] = new Account("james1", 10000, 0.35, "VIP");
		acc[1] = new Account("james2", 10000, 0.45, "GOLD");
		acc[2] = new Account("james3", 10000, 0.55, "SIVER");
		acc[3] = new Account("james4", 10000, 0.15, "GOLD");
		acc[4] = new Account("james5", 10000, 0.28, "SIVER");
		acc[5] = new Account("james6", 10000, 0.31, "VIP");

		//2. 6개의 계좌 정보를 모두 출력하기.
		for(Account data :acc) {
			System.out.printf("고객이름 %s 계좌번호 %s 계좌잔액 %f원 이자금액 %f 등급 %s 입니다. \n", data.getAccName(), data.getAccNum(), data.getBalance(), data.getRate(), data.getGrade());
		}
		//3. 모든 계좌의 잔액과 현재 이자금액 출력하기.
		// 정보 출력
	    System.out.println("모든 계좌의 잔액과 현재 이자금액을 출력합니다. ");
	    for(Account data :acc) {
	    	System.out.printf("고객 %s의 \t", data.getAccName()); 
	    	System.out.printf("계좌 잔액은 %4.1f\t", data.getBalance());
	    	System.out.printf("현재 이자금액은 %4.1f 입니다.\n", data.getInterest());
	    }
	    
	    //4.vip들의 잔액의 합과 평균을 출력하시오.
	    double sum = 0;
	    double avg = 0;
	    int cnt = 0;
	    
	    for(int i=0; i < acc.length; i++) {
	    	if(acc[i].getGrade().equals("VIP")) {
	    		sum += acc[i].getBalance();
	    		cnt++;
	    	}
	    } avg = (sum/cnt)*1.0;
	System.out.printf("VIP들의 계좌 잔액 합은 %4.1f\t",sum);
	System.out.printf("VIP들의 계좌 잔액 평균은 %4.1f\t",avg);
		
		}

	}


