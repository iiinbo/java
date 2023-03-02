package board;

public class DAO { //작성한 글과 작성자 등 정보를 db에 넣는 작업.
	public void insert(String str) {
		System.out.println("Inserted Oracle Database Row:"+ str);
	}

	public void update(int num, String str) {
		System.out.println("Updated Oracle Database Row:"+num+ ""+str);
	}

	public void delete(int num) {//글번호 삭제하겠다
		System.out.println("Deleted Oracle Database Row:"+ num);
	}

	public String select(int num) {//해당 글 번호를 상세조회하겠다
		return "Hi Database!";

	}
}
