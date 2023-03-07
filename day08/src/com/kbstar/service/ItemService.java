package com.kbstar.service;

import com.kbstar.dao.ItemDAO;
import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.SearchService;
import com.kbstar.frame.Service;
//상품을 등록하는 역할. db에도 넣어줘야하고 관리자에게 등록완료되었다고 sms등 발송..
public class ItemService implements Service<Integer, ItemDTO>,  SearchService{
	//여기두 설계도 보면 Service에 implements되어있어.
	//제너릭<key값자리(int는 인티저로 써줄것), value값자리(값은 DTO에담김)>
	
	//DB저장을 위해 dao라는 변수를 지정해 사용하겠어.
	DAO<Integer, ItemDTO> dao;
	public ItemService() {
		dao = new ItemDAO(); //dao 상위클래스 변수에 하위 클래스 담기기 가능(프로모션이라 했음)
	}
	
	@Override //서비스 레이어에서 해야할 일들
	public void register(ItemDTO v) {
		System.out.println(v+"Data Check"); //필터링:값이 들어오면 확인/출력
		dao.insert(v); //DB저장.
		System.out.println("Send sms");//예)관리자에게 완료메일 발송
		//sms.send(v); 나중엔 문자발송 이렇게 가능함.
	}

	@Override
	public void remove(Integer k) {
		System.out.println(k+"Data Check"); 
		dao.delete(k); //DB저장.
		System.out.println("Send sms");
		
	}

	@Override
	public void modify(ItemDTO v) {
		System.out.println(v+"Data Check"); 
		dao.update(v); //DB저장.
		System.out.println("Send sms");
		
	}

	@Override
	public void search() {
		System.out.println("Search");
	}

	/*
	 * //기능 단독 추가시 public void search() { System.out.println("search!"); }
	 */
	}
