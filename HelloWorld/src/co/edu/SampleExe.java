package co.edu;

// SampleExe.java -> SampleExe.class: 실행.
public class SampleExe {
	public static void main(String[] args) {
		String myName = "김홍식"; //문자를 담을 변수 (String)
		int myAge = 41; //정수를 담을 변수(int)
		System.out.println("안녕하세요!!!" + myName + "입니다."); //System.out.println = console에 ()을 출력.
		System.out.println("나이는 " + myAge +"살 입니다.");
		
		sum(20, 30);
		diff(50,20);
		
	} //end of main().
	
	//method는 기능을 정의.
	public static void sum(int first, int last) {
		int result = first + last;
		System.out.println("두 수의 합은" + result);
	}
	
	public static void diff(int num1, int num2) {
		int result = num1 - num2;
		System.out.println("두 수의 차이는" + result);
		
	}
}
