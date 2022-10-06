package co.edu.api;

public class StringEdu2 {

	public static void main(String[] args) {
//		byte[] bytes = new byte[100];
//		
//		System.out.println("입력 : ");
//		int readByteNo = System.in.read(bytes);
//		
//		String str = new String(bytes, 0 ,readByteNo-2);
//		System.out.println(str);
		
//		String subject = "자바 프로그래밍";
//		char charValue = subject.charAt(3);
//		System.out.println(charValue);
		
		String ssn = "123123-1231231";
		
		char sex = ssn.charAt(7);
		
		switch(sex) {
		case '1':
			System.out.println("남자입니다");
			break;
		case '2':
			System.out.println("여자입니다");
			break;
		}
	}
}
