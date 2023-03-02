package board;

public class Service {
	
	DAO dao; //db에 입력하려면 dao가 필요하니까 선언해준다
	
	public Service() {
		dao = new DAO();
	}
	
	public void register(String str) {
		//Security or log를 처리한다.
		dao.insert(str); //들어온 정보를 dao보고 db에 집어넣으라고 하는 것
	}

	public void remove(int num) {
		dao.delete(num); //들어온 정보를 dao보고 db에 수정하라고
	}

	public void modify(int num, String str) {
		dao.update(num, str);
	}

	public String get(int num) {
		return dao.select(num);

	}
}
