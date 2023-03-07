package com.kbstar.dao;

import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;
//db로 저장/삭제/수정하는 역할
public class ItemDAO implements DAO<Integer,ItemDTO> {
	//설계도 보면 dao에 implements되어있어.
	//제너릭<key값자리(int는 인티저로 써줄것), value값자리(값은 DTO에담김)>

	//자동삽입 //여기에 DML문이 들어온다. insert, delete, select, update
	@Override
	public void insert(ItemDTO v) {
		connect(); //예시)db에 접속.
		System.out.println(v);
		System.out.println("Inserted");
		close();//예시)작업종료.
	}

	@Override //int id = 100; 이라는 값이 k자리에 들어올 수 있다. 여기선 가능하다.
	public void delete(Integer k) {
		connect();
		System.out.println(k); //k:상품번호 int
		System.out.println("deleted");
		close();//예시)작업종료.
	}

	@Override
	public void update(ItemDTO v) {
		System.out.println(v); //k:상품번호 int
		System.out.println("updated");
		
	} 
	
}
