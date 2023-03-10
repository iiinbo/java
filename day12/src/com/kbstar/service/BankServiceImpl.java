/**
 * 
 */
package com.kbstar.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dao.TransactionDAO;
import com.kbstar.dao.UserDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeAccountNumber;
import com.kbstar.frame.Notification;
import com.kbstar.noti.NotificationImpl;

/**
 * @author 23.3.10
 *
 */
public class BankServiceImpl implements BankService<UserDTO, AccountDTO, TransactionDTO, String, String> {

	// 객체를 먼저 생성하자
	DAO<String, UserDTO> userDao;
	Notification notification;
	DAO<String, AccountDTO> accountDao; //필요해서 추가했다
	DAO<String, TransactionDTO> transactionDao; //필요해서 추가했다
	
	//db생성하자
	HashMap<String, AccountDTO> db; 

	public BankServiceImpl() {
		userDao = new UserDAO();
		accountDao = new AccountDAO();
		notification = new NotificationImpl();
		transactionDao = new TransactionDAO();
		
		db = new HashMap<String, AccountDTO>(); //id넣었을 때 보유한 계좌정보 모두 나오려면 UserDTO연결해주기
	}

	@Override
	public void register(UserDTO v) throws Exception {
		try {
			userDao.insert(v);
		} catch (Exception e) {
			throw new Exception("등록 오류");
		}
		notification.sendEmail(v.getEmail(), "등록을 축하합니다"); // v값엔(id부터 연락처까지 다 있으니)
		notification.sendSMS(v.getContact(), "등록을 축하합니다");
	}

	@Override
	public UserDTO login(String k, String p) throws Exception {
		// 사용자는 화면에서 id,pw입력
		// db에 있는 id,pw를 가지고 와서 비교
		// 같으면 로그인 성립(UserDTO 정보 던져주기). 아니면 실패
		UserDTO user = null;
		user = userDao.select(k); // k값을 먼저 가져오기
		if (user != null) { // db에 id(k) 값 있다면?
			if (user.getPwd().equals(p)) { // 비밀번호 비교해서 값이 같을 때 다음
				System.out.println("로그인 성공");
			} else {
				throw new Exception("비밀번호를 다시 확인해 주시기 바랍니다.");
			}
		}	else {
			throw new Exception("id가 존재하지 않습니다. 다시 확인해 주시기 바랍니다.");
		}return user;
	}

	

	@Override
	public UserDTO getUserInfo(String k) throws Exception {
		UserDTO user = null;
		user = userDao.select(k);
		return user;
	}

	@Override //계좌생성하는 함수
	public void makeAccount(String k, double balance) throws Exception {
		String accNo = MakeAccountNumber.makeAccNum(); //계좌번호는 문자열. 자동생성한다고 선언
		AccountDTO account = new AccountDTO(accNo, balance, k); //계좌생성 = 계좌번호,금액,고객이름(id) 입력이 모두 필요
		accountDao.insert(account); //생성된 계좌번호 등 정보는 accountDao를 통해 db에 insert하라고 전달.
		UserDTO user = userDao.select(k); //id를 가져온다
		notification.sendEmail(user.getEmail(), accNo+" KB국민은행에 계좌를 생성하셨습니다."); //user.getEmail() : UserDTO에서 고객 이메일주소 가져온다.
		notification.sendEmail(user.getContact(), accNo+" KB국민은행에 계좌를 생성하셨습니다.");
	}

	@Override //사용자가 가진 계좌 모두조회 (고객기본 키값 입력하면 '계좌정보(AccountDTO)'다 나오게)
	public List<AccountDTO> getAllAccount(String k) throws Exception {
		List<AccountDTO> list = null;
		list = accountDao.select();
		
		return list;
	}

	@Override //특정 계좌 이체내역 모두 조회
	public List<TransactionDTO> getAllTr(String acc) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //계좌이체 행위
	public void transaction(String sendAcc, String receiveAcc, double balance, String desc) throws Exception {
		System.out.println("금결원 전송");
		//계좌정보 수정
		//계좌 잔액 정보를 조회하고 잔액에서 이체하는 금액을 차감한 잔액으로 수정
		AccountDTO acc = null;
		acc = accountDao.select(sendAcc); //보내는 계좌에 대한 내용을 가져와 acc로
		double abalance = acc.getBalance() - balance; //보내는 금액을(abalance로 선언) 내 잔액에서 차감해
		acc.setBalance(abalance); //그다음 set으로 balance를 위 금액으로, 상태 변경할거야.
		accountDao.update(acc); //최종 변경된 현재잔액을 내계좌에 업데이트해줘 dao를 이용해서. 끝.
	
		//계좌이체 발생하면 트랜젝션dao에다가 db로 데이터 집어넣으라고 요청하는 기능**거래내역 추가
		TransactionDTO trn = new TransactionDTO(MakeAccountNumber.makeTrNum(), sendAcc, balance, "O", desc); //O : 나가다. I : 입금들어오다.
		transactionDao.insert(trn);
		//sms, email발송
		String uid = acc.getHolder();
		UserDTO u = userDao.select(uid);
		notification.sendEmail(u.getEmail(), sendAcc+"에서 "+balance+" 출금 되었습니다.");
		notification.sendSMS(u.getContact(), sendAcc+"에서 "+balance+" 출금 되었습니다.");
		
		//완료

	}

}
