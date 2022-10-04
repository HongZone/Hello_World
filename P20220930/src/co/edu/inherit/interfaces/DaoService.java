package co.edu.inherit.interfaces;
//인터페이스
public interface DaoService {
	//필드 x, 생성자x
	//메소드는 있지만 생성 되는 모든 메소드는 추상메소드.
	//필드 대신 상수값을 정의해서 사용할 수 있음
	
	public void insert(); // interface의 메소드는 abstract를 안붙어도 자동 추상메소드
	public void search(); // 추상메소드
	public void delete(); // 추상메소드
}
