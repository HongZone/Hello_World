package co.edu.nested;

interface Run{
	void run();
}

class Runner implements Run{

	@Override
	public void run() {
		System.out.println("run.");
	}
	
}
public class AnonymousExample2 {
	public static void main(String[] args) {
		
		//익명구현객체: 상황에 따라 기능이 달라지 
		Run runner = new Run() {
			String kind;
			void runkind() {
				System.out.println("육상");
			}
			@Override
			public void run() {
				System.out.println("구현 run.");
				runkind();
			}
			
		};
		runner.run();
		
		Runner runner2 = new Run() {

			@Override
			public void run() {
				System.out.println("구기종목");
				
			}
			
		};
		runner2.run();
	}
}
