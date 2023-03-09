package com.kbstar.frame;

import java.util.List;

public interface CRUDService<K, V> {
	//화면과 회원(get, update, delete), 계좌정보(입출금이체조회) 중점 기능 정의하는 곳
	public void register(V v) throws Exception; 
	public void remove(K k) throws Exception;
	public void modify(V v) throws Exception;
	public V get(K k) throws Exception; //키값 받으면 1건 조회(가져와)
	public List<V> get() throws Exception; //리스트에 담아서 전체 조회(가져와)

}
