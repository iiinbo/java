package com.kbstar.frame;

import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;

/**
 * 23.3.10
 * @author jeong inbo
 *
 * @param <V1> UserDTO
 * @param <V2> AccountDTO
 * @param <V3> TranscationDTO
 * @param <K> String id
 * @param <P> String pwd
 * 
 */

public interface BankService<V1, V2, V3, K, P> {
	public void register(V1 v) throws Exception; //회원가입 신청시 사용자에게 value값 입력 받는다.
	public V1 login(K k, P p) throws Exception; //로그인 시 사용자의 정보가 보여준다.(return)
	public V1 getUserInfo(K k) throws Exception; //내정보조회
	public void makeAccount(K k, double balance) throws Exception; //사용자id와 금액 입력 시 계좌개설완료.
	public List<V2>getAllAccount(K k) throws Exception; //사용자가 가진 계좌 모두 조회
	public List<V3>getAllTr(String acc) throws Exception; //계좌에 대한 이체내역 모두조회
	public void transaction(String sendAcc, String receiveAcc ,double balance, String desc) throws Exception; //보내는계좌번호, 받는계좌번호, 금액, 적요 있으면 이체 완료.
	
	
}
