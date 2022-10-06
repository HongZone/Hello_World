package co.edu.api;

import java.util.Set;

class Student{
	String name;
	int age;
	
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
	
	@Override
	public String toString() {
		
		return "학생의 이름은 " + name + ", 나이는 " + age + "입니다.";
	}
	@Override
	
	public int hashCode() {
		return age;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Student)) {
			return false;
			
		}
		Student str = (Student) obj;
//		return super.equals(obj);
		if(this.name.equals(str.name) && this.age == str.age)
			return true;
		
		return false;
	   
		
	}
}

public class ObjectExe {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj.equals(obj2));
		
		Student s1 = new Student();
		s1.name = "Hong";
		s1.age = 10;
		Student s2 = new Student();
		s2.name = "Hong";
		s2.age = 10;
		String s3 = "Hong";
		
//		System.out.println(s1.equals(s3));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		//set 컬렉션 : 인터페이스 :  구현클래스를 통해서 인스턴스 생성
		Set<Integer> set = new HashSet<Integer>();
		set.add(new Integer(100));
		set.add(new Integer(100));
		set.add(new Integer(100));
		
		System.out.println("컬렉션의 크기: "+set.size());
				
				//Set 컬렉션 Student 인스턴스 저장
				Set<Student> students = new HashSet<Student>();
				students.add(s1);
				students.add(s2);
				System.out.println("컬렉션의 크기: "+ students.size());
	}
}
