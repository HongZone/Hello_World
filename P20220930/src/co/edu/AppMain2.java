package co.edu;

public class AppMain2 {
	public static void main(String[] args) {
		
		Student.staticMethod();
		Student s1 = new Student();
//		s1.staticMethod();
		
		System.out.println(s1.getStudNo()); //초기값출력
		System.out.println(s1.getStudName());
		
		s1.setStudNo("111.111");
		s1.setStudName("홍길동");
		s1.setmajor("언론영상");
		s1.setage(23);
		
		System.out.println(s1.getStudNo());
		System.out.println(s1.getStudName());
		System.out.println(s1.showInfo());
		
		System.out.println("여기>>"+s1);
		
		Student s2 = new Student();
		s2.setStudNo("222.222");
		s2.setStudName("김유경");
		s2.setage(26);
		System.out.println(s2.showInfo());
		
		String[] hob = {"독서", "자전거"};
		s1.setHobbies(hob);
		s1.addHobby("음악듣기");
		s1.addHobby("차마시기");
		
		System.out.println(s1.getHobb());	
		System.out.println(s2.getHobb());	
		
		Student s3 = new Student();
		System.out.println(s3.getStudName());
		
		Student s4 = new Student("111-111","주소영");
		System.out.println(s4.showInfo());
		
		Student s5 = new Student("222-222","김홍식","영상학과");
		System.out.println(s5.showInfo());
		
	}
}
