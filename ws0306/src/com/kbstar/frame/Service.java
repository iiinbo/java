package com.kbstar.frame;

public interface Service<K,V> {
	public void register(V v) throws Exception;
	public void remove(K k);
	public void modify(V v);
}
