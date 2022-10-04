package co.edu.ingerit.friend;
//추상클래스 추상메소드 구현
public class Cat extends Animal {
	
	@Override
	public void eat() {
		System.out.println("고양이가 먹이를 먹습니다");
	}
	
	@Override
	public void speak() {
		System.out.println("야옹야옹");
	}
}
