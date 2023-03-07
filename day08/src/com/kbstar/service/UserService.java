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
	public void register(UserDTO v) {
		System.out.println("Security Check!"); //1저장 전 보안검증
		dao.insert(v); //2받은 고객정보(v)를 db에 저장시키자
		System.out.println("send mail"); //3가입완료 메일
		System.out.println("send SMS"); //4가입완료 문자
	}

	@Override
	public void remove(String k) {
		dao.delete(k); //key값만 입력하면 db에서 전체정보 삭제된다.
		System.out.println("Send SMS"); //삭제 후 문자발송
		
	}

	@Override
	public void modify(UserDTO v) {
		dao.update(v); //
		System.out.println("Send SMS"); //수정 후 문자발송
		
	}
	
	
}
