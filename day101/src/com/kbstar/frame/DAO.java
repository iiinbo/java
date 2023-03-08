package com.kbstar.frame;

import java.util.List;

public interface DAO<K,V> { //DML문
	//CRUD(create, read, update, delete)할 수 있게 기능정의완료
	public void insert(V v) throws Exception;
	public void update(V v) throws Exception;
	public void delete(K k) throws Exception;
	public V select(K k) throws Exception; //1개의 key값 가져오고 v값으로 리턴해
	public List<V> select() throws Exception; //고객 다 가져와. List에 담아서
	
}
