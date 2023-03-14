package com.kbstar.frame;

import java.util.List;

public interface CRUDService<K,V> {
	//화면쪽 기능 담당 사용자정보 등록,조회,삭제,수정 기능이 있다.
	
	public void register(V v) throws Exception;
	public void modify(V v) throws Exception;
	public void remove(K k) throws Exception;
	public V get(K k) throws Exception; //k값 던지면 v값 가져온다
	public List<V> get() throws Exception; //v값을 list에 한번에 담아서 가져온다.
	
}
