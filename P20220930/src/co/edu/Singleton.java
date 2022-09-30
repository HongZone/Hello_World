package co.edu;

public class Singleton {
	//필드 정적
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
}
