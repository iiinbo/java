package variable;

public class P64 {

	public static void main(String[] args) {
		int a = 10;
		int d = 10;
		String str1 = "abc";
		String str2 = "abc";
		str1 = "def"; //abc값은 메모리에 남아있고, str1의 주소도 바뀌고 def가 새로 만들어진다.
		System.out.printf("%d %4.2f %s\n",a,d,str1);
		if (str1 == str2) {
			System.out.println("ok");
		}
		if (str1.equals(str2)) {
			System.out.println("ok2");
		}
		String str3 = new String("abc");
		String str4 = new String("abc");

		
	}

}
