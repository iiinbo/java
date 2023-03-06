package com.kbstar.frame;

public interface DAO<K,V> {
	public void insert(V v); //i에 들어오는 값은 value야
	public void delete(K k); //key값이야
	public void update(V v);
}
