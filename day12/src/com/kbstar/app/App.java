package com.kbstar.app;

import java.util.List;
import java.util.Scanner;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.BankServiceImpl;
import com.kbstar.service.UserService;

public class App {

	public static void main(String[] args) {
		//2.
		BankService<UserDTO, AccountDTO, TransactionDTO, String, String> service = new BankServiceImpl();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			UserDTO user = null; //객체를 밖에서 선언하기로 했다.
			System.out.println("Login(l) or Register(r)...(q)");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				break;
			}else if(cmd.equals("r")) {
				System.out.println("Register");
				//1.회원가입에 필요한 정보를 입력받기
				String id = sc.next();
				String pwd = sc.next();
				String name = sc.next();
				String email = sc.next();
				String contact = sc.next();
				user = new UserDTO(id, pwd, name, email, contact); //입력받은 정보로 객체를 생성했다!(그러나, 지역함수로 빼야해)
				try {
					service.register(user); //정상적으로 서비스에 유저정보 가입되면
					System.out.println("환영합니다!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}else if(cmd.equals("l")) {
				System.out.println("Login");
				//로그인에 필요한 정보 받기
				String id = sc.next();
				String pwd = sc.next();
				user = null; //초기화
				
				try {
					user = service.login(id, pwd);//1.받은 정보는 user에 담자
					System.out.println(user); //성공한 정보 출력
					System.out.println("로그인에 성공했습니다."); 
					System.out.println("--------------------------------------");//성공 후 계좌거래 시작할 수 있게 준비하자
					//
					while(true) {
						System.out.println("Menu(m,t,a,i,tr,e)를 이용하세요");
						String cmn = sc.next();
						if(cmn.equals("e")) {
							break; //만나면 시스템 종료.로그아웃
						}else if(cmn.equals("m")) {
							System.out.println("m : Make Account 계좌개설. 신규금액을 입력해 주세요");
							double balnce = Double.parseDouble(sc.next()); //로그인 중이라 id는 보유하고 있으니 금액만 입력받으면 된다.
							service.makeAccount(user.getId(), balnce); //id가져오고 밸런스까지 makeAccount계좌를 개설하는 함수에 입력.
							System.out.println("계좌개설이 완료되었습니다.");
						}else if(cmn.equals("t")) {
							System.out.println("t : Transaction 이체");
							String sendAcc = sc.next(); //보낼계좌 입력받자
							String receiveAcc = sc.next();
							double balance = Double.parseDouble(sc.next());
							String desc = sc.next();
							service.transaction(sendAcc, receiveAcc, balance, desc);
							System.out.println("계좌이체가 완료되었습니다.");
							
							
						}else if(cmn.equals("a")) {
							System.out.println("a : Select Account 계좌 전체조회");
							System.out.println("고객님이 로그인하신 사용자 정보로, 보유 중인 계좌 전체가 조회됩니다.");
							//이미 로그인 한 상태이니, 시스템이 자동으로 user(로그인 한 고객의 정보담겨있는 변수)의 id값 가져오도록.
							 List<AccountDTO> list = null;
							 list = service.getAllAccount(user.getId());//getAllAccount 계좌번호 조회 함수를 입력해주자.
							
							//계좌 여러개라면 모두 다 출력하자.
						    for (AccountDTO data : list) {
								System.out.println(data);
							}
							
						}else if(cmn.equals("i")) {
							System.out.println("i : User Info 계좌 상세조회");
							String rid = user.getId();
							UserDTO ruser = null;
							ruser = service.getUserInfo(rid);
							System.out.println(ruser);
							
							//현재 구현 불가
						}else if(cmn.equals("tr")) {
							System.out.println("tr : Select Transaction 계좌이체내역 조회");
							System.out.println("거래내역을 조회할 계좌번호를 입력해 주세요.");
							String accNo = sc.next();
							List<TransactionDTO> list = null; //담을 바구니 먼저 초기화하고,
							list = service.getAllTr(accNo); //바구니안에 계좌번호 넣어주자
							//계좌내역 여러개이니 모두 출력하자
						    for (TransactionDTO tr : list) {
								System.out.println(tr);
							}
							
						}
						
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		sc.close();
	}

}
