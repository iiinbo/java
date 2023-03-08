package com.kbstar.frame;

public interface DAO<K,V> {
	//예시상황) db에 접속할 때 ip를 이용한 접근방법이 새로 생겼다 가정
	public static final String IP = "172.0.0.1";
	//public static final 타입 상수명(변수아님) = 값;
	//특징. 맨 앞에 퍼블릭 스태틱 붙는다. 상수명은 대문자다.
	//추상함수 선언
	public void insert(V v) throws Exception; //안될 때 대비해서 예외상황 선언 미리해주기
	public void delete(K k) throws Exception; //key값이야
	public void update(V v) throws Exception;
	
	//디폴트도 넣을 수 있다
	default void connect() {
		System.out.println(IP+"에 접속하였습니다.");
	}
	default void close() {
		System.out.println(IP+"접속이 해제되었습니다.");
	}
}
