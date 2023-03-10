package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MSg;
import com.kbstar.frame.Notification;
import com.kbstar.frame.CRUDService;
import com.kbstar.noti.NotificationImpl;

public class UserService implements CRUDService<String, UserDTO> {
	// Service가 사용하고 있는 것들을 써주기.
	// 1.DAO는 userDao로 호출해서 사용 2.Noitfication은 소문자로 호출사용

	DAO<String, UserDTO> userDao;
	Notification notification;

	public UserService() {
		userDao = new UserDAO();
		notification = new NotificationImpl();
	}

	@Override
	public void register(UserDTO v) throws Exception {
		// 비밀번호 암호화
		try {
			userDao.insert(v); // 아래 throw 추가가 없었으면, 내부 에러코드가 화면에 전송됨.
		} catch (Exception e) {
			throw new Exception("(ER0001)회원가입이 실패했습니다.");
			// 개선! 화면정의를 돕는 UserService에서 throw + db에러 문구를 다시 직관적으로 바꿈
		}
		notification.sendEmail(v.getEmail(), MSg.registerMsg1); // v에서 이메일주소 가져와
		notification.sendSMS(v.getContact(), MSg.registerMsg2); // v에서 연락처 가져와. 메세지는 미정
	}

	@Override
	public void remove(String k) throws Exception {
		UserDTO user = null;
		user = userDao.select(k); // 1.문자발송을 위해 db에서 고객정보 가져와놓고
		try {
		userDao.delete(k); // 2. 삭제했다.
		} catch(Exception e) {
			throw new Exception("탈퇴 오류가 발생했습니다.");
		}
		notification.sendEmail(user.getEmail(), MSg.removeMsg3);
		notification.sendSMS(user.getContact(), MSg.removeMsg4); // 3.탈퇴 후 메세지
	}

	@Override
	public void modify(UserDTO v) throws Exception {
		try {
			userDao.update(v);
		} catch (Exception e) {
			throw new Exception("입력한 정보로 수정이 실패했습니다.");
		}
	}

	@Override
	public UserDTO get(String k) throws Exception {
		UserDTO obj = null;
		obj = userDao.select(k);

		return obj;
	}

	@Override
	public List<UserDTO> get() throws Exception {
		List<UserDTO> list = null;
		try {
			list = userDao.select();
		} catch (Exception e) {
			throw new Exception("전체조회 실패");
		}
		return list;
	}

}
