package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.CartDaoImpl;
import com.kbstar.dao.CustDaoImpl;
import com.kbstar.dao.ItemDaoImpl;
import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.frame.DAO;
import com.kbstar.frame.ShopService;

public class ShopServiceImpl implements ShopService<Cust, Cart> {

	// db에 접근할 수 있게
	DAO<String, String, Cust> custDao;

	DAO<String, String, Item> itemDao;

	DAO<String, String, Cart> cartDao;

	// 위에 필요한 dao 선언한 뒤, 아래처럼 컨스트럭터 만들어서 사용하면 된다~
	public ShopServiceImpl() {
		custDao = new CustDaoImpl();
		itemDao = new ItemDaoImpl();
		cartDao = new CartDaoImpl();
	}

	// 화면에서 회원가입~로그인(custDao필요)~나의 카트조회(carttDao필요) 기능
	@Override // 로그인
	public Cust login(String id, String pwd) throws Exception {
		// db에서 id확인
		// db에서 pwd확인
		// if 일치 시 로그인 / else 예외처리로 로그인 실패 안내

		Cust cust = null; // 돌려받을건 cust
		cust = custDao.select(id); // 고객정보 가지고 있는 custDao에서 k값(고객id)을 먼저 가져오기
		if (cust != null) { // db에 id 값 있다면?
			if (cust.getPwd().equals(pwd)) { // 비밀번호 비교해서 값이 같을 때 다음
				//System.out.println("로그인 성공"); //App에서 이미 프린트 되고있음.
			} else {
				throw new Exception("비밀번호를 다시 확인해 주시기 바랍니다.");
			}
		} else {
			throw new Exception("id가 존재하지 않습니다. 다시 확인해 주시기 바랍니다.");
		}
		return cust;
	}

	@Override // 회원가입
	public void register(Cust v) throws Exception {
		try {
			custDao.insert(v); // 고객이 작성준 고객정보를 cust db로 보내주도록.
		} catch (Exception e) {
			throw new Exception("회원가입 오류가 발생했습니다.");
		}
		// 참고.notification.sendEmail(v.getEmail(), "회원 등록을 축하합니다"); // v값엔(id부터 연락처까지 다 있음)
		// 참고.notification.sendSMS(v.getContact(), "회원 등록을 축하합니다");

	}

	@Override // **search 기능을 사용** : 사용자의 id를 입력하면 '나의(해당id만)' 카트조회
	public List<Cart> myCart(String id) throws Exception {
		List<Cart> list = null; // 조회내역 담는 빈바구니 만들기

		try {
			list = cartDao.search(id);
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

}
