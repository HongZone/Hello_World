package co.edu.inherit;

public class Parent{ //기본적으로 Object라는걸 상속받아서 사용 최상위 클래스 
	String field;
	Parent() {
		System.out.println("Parent() call.");
	}
	Parent(String args) {
		System.out.println("Parent(String args) call.");
	}
	void method() {
		System.out.println("parnet method() call.");
	}
	@Override
	public String toString() {
		return "Parent [field=" + field + "]";
	}
	
}
