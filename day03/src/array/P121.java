package array;

import java.util.Scanner;

public class P121 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input Command[q,i,s]");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("Quit");
				break;
			} else if(cmd.equals("i")) {
				System.out.println("Insert");
				System.out.println("Input ID..");
				String id = sc.next(); //사용자가 화면에 입력한 id값을 받아온단 의미이다.
				System.out.println("Input PW..");
				String pwd = sc.next(); //여기 입력한 값을 db에 저장하면 된다.
				System.out.println("Input NAME..");
				String name = sc.next(); //여기 입력한 값을 db에 저장하면 된다.
				System.out.printf("%s, %s, %s Inserted...\n", id,pwd,name);//저장한다고 알려준다
				//입력끝나면 while로 간다.
				
			} else if(cmd.equals("s")) {
				System.out.println("Select");
			} else {
				System.out.println("Invalid Command");
				System.out.println("Try again.");
			}
		} //end while
		System.out.println("Bye");
		sc.close();
	
	}

}
