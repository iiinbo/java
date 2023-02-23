package variable;

public class P69 {

	public static void main(String[] args) {
		String str = "abcdef";
		str = str.toUpperCase();
		System.out.println(str);
		//대문자로 바뀌면서 대문자 ABCDEF가 새로운 힙영역에 저장되면서 str주소가 바뀐다.
		
		String str2 = str.replace('A', 'Z'); //z로바뀐 메모리가 새로 생기지만, 기존것도 유지된다.
		System.out.println(str2);
		
		int lng = str.length();
		System.out.println(lng);
		
		int t = str.indexOf("B");
		System.out.println(t);
		
		char c = str.charAt(0);
		System.out.println(c);
		
		String str3 = str.substring(1, 3);
		System.out.println(str3);
		
		//이메일주소 뽑아내기
		String email = "jmlee@tonesol.com";
		
		String id = email.substring(0, 5);
		String domain = email.substring(6, 17);
		
		System.out.printf("%s, %s",id,domain);
		
	}

}
