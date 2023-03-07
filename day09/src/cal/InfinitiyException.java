package cal;

//나만의 exception만들기
public class InfinitiyException extends Exception {
	public InfinitiyException() {

	}

	public InfinitiyException(String msgcode) {
		super(msgcode); //예외발생 시 메세지를 발생시킬거다. 에러코드로
	}
}
