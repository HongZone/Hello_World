package co.edu.complex;

import java.util.Scanner;

public class ObjextExe {
	public static void main(String[] args) {
		
		String s1 = "홍길동";
		int i1 = 20;
		double d1 = 162.3;
		
		Person p1 = new Person();  //인스턴스 생성, 생성자 호출
		p1.name = "김민기";
		p1.age = 22;
		p1.height = 172.3;
		
		System.out.println(p1);
		
		Person p2 = new Person();
		p2.name="김경미";
		p2.age=23;
		p2.height = 163.2;
		
		Person p3 = new Person();  
		p3.name = "주소영";
		p3.age = 22;
		p3.height = 172.3;
		System.out.println(p3);
		
		
		System.out.println("이름:" + p1.name);
		System.out.println("나이:" + p1.age);
		System.out.println("키:" + p1.height);
		
		Person[] persons = {p1, p2, p3}; //Person 형태의 배열을 만들기 위한 정의
		System.out.println(persons[1].name);
		System.out.println(persons[1].age);
		System.out.println(persons[1].height);
		
		//p1변수값고 persons[0]값 비교 = true
		System.out.println(persons[0] == p1);
		
//		p3.name = "송지은"; //객체 이름 변경
		
		//문제 김경미 이름을 찾아서 나이를 23 => 22로 변경
		//반복 for
		
//		String kim = "김경미"; //문자열 리터럴,
		Scanner scn = new Scanner(System.in);
		System.out.println("변경할 이름>>>" );
		String name = scn.nextLine();
	    System.out.println("변경할 나이>>>");
		int age = scn.nextInt();
		for(int i = 0; i < persons.length; i++) {
		  if(persons[i].name.equals(name)) {
			persons[i].age = age;
		}
	}
		
		
		
		
		
		for(int i =0; i < persons.length; i++) {
			System.out.println(i+1+"번째 이름:"+ persons[i].name+ ", 나이:" + persons[i].age);
		}
//		
//		
//		String n1 = new String("홍길동"); //이렇게 하면 다릅니다
//		String n2 = new String("홍길동");
//		String m1 = "홍길동"; //이렇게 입력할 때는 new String 과 다르게 m2에도 같은 주소를 전달해준다
//		String m2 = "홍길동";
//		System.out.println(m1 == m2);
//		
//		//내용은 같아도 저장된 주소가 다르기 떄문에 같을 수가 없다 = false
//		System.out.println(p1==p3);
		
		
	}
}
