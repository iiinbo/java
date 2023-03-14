package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.CartDaoImpl;
import com.kbstar.dto.Cart;
import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeItemNumber;

public class CartCRUDServiceImpl implements CRUDService<String, Cart> {

	DAO<String, String, Cart> dao;

	public CartCRUDServiceImpl() {
		dao = new CartDaoImpl();
	}

	// 화면에서 Cart 정보를 관리하는 기능
	@Override
	public void register(Cart v) throws Exception {
		// 데이터검증
		// id생성(자동생성)
		// db에 입력

		try {
			String id = MakeItemNumber.makeCartNum();
			v.setId(id); // user_id, item_id, cnt 입력되면 카트의 id 자동생성한다.
			dao.insert(v); // db에 저장한다.
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("이미 카트에 담은 상품과 id가 동일합니다."); // case 1
			} else {
				throw new Exception("시스템 오류로 카트 정보 저장이 실패했습니다."); // case 2
			}
		}
	}

	@Override
	public void modify(Cart v) throws Exception {
		
		try {
		dao.update(v);
		} catch(Exception e) {
			 if (e instanceof SQLRecoverableException) {
		            throw new Exception("수정 중 시스템 장애가 발생했습니다.");
		         } else {
		            throw new Exception("해당 ID는 존재하지 않으므로 정보 수정이 불가합니다.");
		         }
		}
	}

	@Override
	public void remove(String k) throws Exception {
		
		try {
		dao.delete(k);
		} catch(Exception e) {
			if(e instanceof SQLRecoverableException) {
				throw new Exception("시스템 오류가 발생했습니다.");
			} else {
			throw new Exception("삭제할 id가 존재하지 않습니다.");
			}
		}
	}

	@Override
	public Cart get(String k) throws Exception {
		Cart obj = null;
		try {
			obj = dao.select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애입니다.");
			} else {
				// e.printStackTrace();
				throw new Exception("존재하지 않는 카트ID로 조회가 불가합니다.");
			}
		}
		return obj;
	}

	@Override
	public List<Cart> get() throws Exception {
		// 1. 반환받을 바구니(list) 먼저 초기화
				List<Cart> list = null;
				try {
					list = dao.selectAll();
				} catch (Exception e) {
					if (e instanceof SQLRecoverableException) {
						throw new Exception("시스템 장애가 발생했습니다."); // 서버오류일 때
					} else {
						throw new Exception("카트내역이 존재하지 않습니다."); // 조회할 데이터 없을 때
					}
				}
				return list;
			}
	}


