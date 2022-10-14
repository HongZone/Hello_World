package co.edu.nested;

//익명 구현 객체.
//추상메소드 하나만 존재하는 인터페이스 => Functional 인터페이스

interface MyInterface{
	void run();
}

interface MyInterface2{
	void run(String kind);
}

interface MyInterface3{
	void run(String kind);
}
public class AnonymousExample3 {
	public static void main(String[] args) {
		
		
		

		
		
		MyInterface2 intf2 = new MyInterface2() {
			@Override
			public void run(String kind) {
				System.out.println(kind + "Run.");
			};
		};
		intf2.run("농구종목");
		
//		MyInterface2 intf2 = kind -> System.out.println(kind+"Run."); //위에꺼를 람다표현식으로
//		intf2.run("농구종목");
		
		
		MyInterface intf = new MyInterface() {
			@Override
			public void run() {
				System.out.println("MyInterface Run.");
			}
		};
		intf.run();
//		MyInterface intf = () -> System.out.println("MyInterface Run.");  //위에꺼를 람다표현식으로도 쓸 수 있음
//		intf.run();
	}
}
