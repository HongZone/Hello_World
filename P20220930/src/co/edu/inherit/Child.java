package co.edu.inherit;

public class Child extends Parent{ 
	String field1;
	Child(){
		super("args"); //부모클래스의 생성자호출 //부모클래스에 기본생성자가 있어야함
		System.out.println("Child() call.");
	}
	void method1() {
		System.out.println("method() call.");
	}
	@Override // 어노테이션 : 부모클래스의 메소드(반환값, 메소드의이름, 매개값) 등이 같은지 체크 하는 용도
	void method() { //부모클래스의 메소드를 재정의(수정). = overriding // 데이터타입과 이름과 매개변수가 똑같아야 한다
		System.out.println("Child method() call.");
	}
	@Override
	public String toString() {
		return "Child [field1=" + field1 + "]";
	}
	
}
