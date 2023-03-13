package com.kbstar.frame;

public class Sql {
	//입력.삭제.수정/조회하는 sql문 복사하기. 이때 맨 앞에 public static
	public static String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
	public static String deleteSql = "DELETE FROM cust WHERE id = ?";
	public static String updateSql = "UPDATE cust SET pwd=?,name=?,age=? WHERE id = ?";
	public static String selectSql = "SELECT * FROM cust WHERE id = ?";
	public static String selectAllSql = "SELECT * FROM cust";
	
	
}	
