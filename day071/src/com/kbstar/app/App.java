package com.kbstar.app;

import com.kbstar.dao.AccountMariaDBDAO;
import com.kbstar.dao.UserMariaDBDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;

public class App {

	public static void main(String[] args) {
		DAO dao1 = new UserMariaDBDAO();
		DAO dao2 = new AccountMariaDBDAO();
		UserDTO user = new UserDTO("id01", "pw32", "홍길동");
		dao1.insert(user); //계좌정보를 db에 저장시켜라. 기능해주는 클래스다.
		AccountDTO account = new AccountDTO("000", "적금", 1000);
		dao2.insert(account);
	}

}
