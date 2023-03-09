package com.kbstar.frame;

import java.util.List;

public interface DAO<K,V> {
	//SIUD 중점기능 정의하는 곳
	public void insert(V v) throws Exception; //insert : v밸류값을 db에 입력기능 정의
	public void delete(K k) throws Exception;
	public void update(V v) throws Exception;
	public V select(K k) throws Exception; //키값 받으면 1건 조회
	public List<V> select() throws Exception; //리스트에 담아서 전체 조회
}
