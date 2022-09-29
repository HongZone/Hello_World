package co.edu.variable;

public class methodExe {
	
	//main 메소드 : 첫번쨰 실행.
	public static void main(String[] args) {
//		printStar();	
		printStar(3,3); // 실행부분의 매개변수 부분은 데이터타입을 안적는다
		printCircle("◑",5);
		int resulte = sum(sum(2, 3), sum(3,4));
		System.out.println("최종값" + resulte);
	}
	
	
	public static void printStar() { // 반환값 = 없음, 매개변수 = 없음.
		System.out.println("*");		
	}
	
//	public static void printStar(int times) { // 반환값 = 없음, 매개변수 = 있음.
//		for(int i=0; i<times; i++) {
//			System.out.println("*");
//		}
//	}
//	
	public static void printStar(int times, int circle) { // 반환값 = 없음, 매개변수 = 있음.
		for(int i=0; i<times; i++) {
			System.out.print("*");
		}
		for(int c=0; c < circle; c++) {
			System.out.print("o");
		}
	}
	
	public static void printCircle(String circle) {
		System.out.println(circle);
	}
	
	public static void printCircle(String circle, int times) {
		for(int i=0; i<times; i++) {
			System.out.print(circle);
		}
	}
	
	//반환값을 가지는 메소드
	public static int sum(int n1, int n2) {
		int result = n1*2 + n2*3;
		System.out.println("결과값은"+ result);
		return result; //반환값의 유형은 메소드 정의할 때 적어줌
	}
	
}
