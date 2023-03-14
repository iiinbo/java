package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Item;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class CartDaoImpl implements DAO<String, String, Cart> {

	// 1.Driver Loading
	public CartDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return; // 예외상황 발생 시 종료해줘
		}
		System.out.println("Driver Loading 성공!");
	}

	// Cart에 대한 입력~수정~삭제 기능
	@Override
	public void insert(Cart v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartInsertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getUser_id());
			pstmt.setString(3, v.getItem_id());
			pstmt.setInt(4, v.getCnt());
			pstmt.executeUpdate(); // executeUpdate : sql문을 db에 반영.

		} catch (SQLException e) {
			e.printStackTrace();
			// throw e; //Service로 예외 넘긴다. (예외케이스 : 커넥션 오류 / 입력 오류(동일한 item_id 등))
		}
	}

	@Override
	public void delete(String k) throws Exception {

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartDeleteSql);) {
			pstmt.setString(1, k); // 첫번째 물음표에 k값 세팅
			int result = pstmt.executeUpdate();// 5. 결과 받기// 쿼리문을 db로
			// 삭제할 cart의 id값이 없으면 예외처리
			if (result == 0) {
				throw new Exception("삭제할 id가 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			throw e; // dao에서 처리 안하고 service로 던져

		}
	}

	@Override
	public void update(Cart v) throws Exception {
		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.cartUpdateSql);){
			
			//수정가능한 정보는 item id와 cnt갯수로 물음표 자리에 맞게 세팅.
			pstmt.setString(1, v.getUser_id());
			pstmt.setString(2, v.getItem_id());
			pstmt.setInt(3, v.getCnt());
			pstmt.setString(4, v.getId());
			int result = pstmt.executeUpdate();// 5. 수정한 결과 받기// 쿼리문을 db로
			
			if (result == 0) {
				throw new Exception("수정 가능한 id가 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//throw e; //service로 넘긴다.
		}
	}

	@Override
	public Cart select(String k) throws Exception {
		Cart obj = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartselectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next(); // 한 칸 이동시켜야 select 가능
				String id = rset.getString("id");
				String user_id = rset.getString("user_id");
				String item_id = rset.getString("item_id");
				int cnt = rset.getInt("cnt");
				Date regdate = rset.getDate("regdate");
				obj = new Cart(id, user_id, item_id ,cnt, regdate); // 객체 생성
			} catch (SQLException e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return obj;
	}

	@Override
	public List<Cart> selectAll() throws Exception {
		// 셀렉트all담을 바구니 만들기.
				List<Cart> list = new ArrayList<>();

				try (Connection con = getConnection();
						PreparedStatement pstmt = con.prepareStatement(Sql.cartselectAllSql);) {
					
					try(ResultSet rset = pstmt.executeQuery();){
						//list바구니에 담은 것을 빼내기 위해 while문
						while(rset.next()) { //데이터(rset) 다음칸으로 넘긴 뒤 실행문
							Cart cart = null; // DTO 초기화 하고
							String id = rset.getString("id");
							String user_id = rset.getString("user_id");
							String item_id = rset.getString("item_id");
							int cnt = rset.getInt("cnt");
							Date regdate = rset.getDate("regdate");

							cart = new Cart(id, user_id, item_id ,cnt, regdate); // 객체 생성
							list.add(cart); // 한바퀴 돌아서나온 값은 list에 넣자.
						}
					}catch(Exception e) {
						throw e;
					}
					
				} catch (Exception e) {
					throw e; // 예외발생 시 서비스로 던진다.
				}

				return list;
	}

	@Override
	public List<Cart> search(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
