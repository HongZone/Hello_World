package co.edu;

//객체 클래스
//사람의 특징 = 속성(이름, 키, 나이, 몸무게...등)
//           기능(달린다, 먹는다, 잠을잔다, 웃는다...등)
//이런 객체를 자바에서 나타낸 것이 클래스
public class Person {
	//이것들은 속성 => 자바에서는 필드
	String name;
	int age;
	double weight;
	double height;
	
	//이것들은 기능 => 메소드
	void run() {
		System.out.println(name + "가 달립니다");
	}
	void eat(String food) {
		System.out.println(name +"가 "+ food+ "를 먹습니다");
	}
	void sleep(String sleeping) {
		System.out.println(name +"가"+sleeping+ "잠을 잡니다");
	}
}
