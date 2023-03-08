package com.kbstar.service;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Service;

//제너릭을 이용한 인터페이스 구성
public class UserService implements Service<String,UserDTO> {

	DAO<String,UserDTO> dao;
	//디폴트 컨스트럭터로 dao 객체를 생성해주자.
	public UserService() {
		dao = new UserDAO();
	}
	
	//자동.
	@Override
	//에러는 UserDAO에서 발생하면 Service 인터페이스 갔다가 App까지 넘어가야한다.
	//그래서 UserService에서 에러에 따른 예외상황 처리를 바로 안하고, throws로  App으로 넘김
	public void register(UserDTO v) throws Exception {
		System.out.println("Security Check!"); //1저장 전 보안검증
		dao.insert(v); //2받은 고객정보(v)를 db에 저장시키자
		System.out.println("send mail"); //3가입완료 메일
		System.out.println("send SMS"); //4가입완료 문자
	}

	@Override
	public void remove(String k) throws Exception {
			try{
				dao.delete(k);
		} catch (Exception e) {
			//여기서 에러나면 log 남는다.
			throw e; //에러로 문제생기면 App으로 던져! (여기서 처리x) & 장점.로그분석 가능
		} //key값만 입력하면 db에서 전체정보 삭제된다.
		System.out.println("Send SMS"); //삭제 성공시만 문자발송
	}

	@Override
	public void modify(UserDTO v) throws Exception {
		dao.update(v); //
		System.out.println("Send SMS"); //수정 후 문자발송
		
	}
	
	
}
