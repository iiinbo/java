package board;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Service service = new Service(); //서비스라는 클래스의 기능들을 받아서 객체를 생성할거다.
		while(true) {
			System.out.println("input cmd(r, m, d, g, q)");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				System.out.println("bye");
				break;
				
			}else if(cmd.equals("r")) {
				System.out.println("input contents");
				String content = sc.next();
				service.register(content); //글을 등록하는 기능에다가 글을 넣어준다.
				
			}else if(cmd.equals("g")) {
				System.out.println("input number");
				int num = Integer.parseInt(sc.next());
				String result = service.get(num); //해당 글의 정보를 받아야해!!
				System.out.println(result); //받은 정보를 화면에 출력해라!!
				
			}else if(cmd.equals("d")) {
				System.out.println("input number");
				int num = Integer.parseInt(sc.next());
				String result = service.get(num);
				service.remove(num);
				
			}else if(cmd.equals("m")) {
				System.out.println("modify number");
				int num = Integer.parseInt(sc.next());
				System.out.println("modify contents");
				String content = sc.next();
				service.modify(num, content);
				
			}
			
		}
		
		sc.close();
	}

}
