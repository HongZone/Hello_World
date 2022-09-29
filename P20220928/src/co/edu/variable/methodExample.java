package co.edu.variable;

public class methodExample {
	// 가로, 세로 값을 넣어주면 => 넓이를 구해주는 
	public static int getArea(int garo, int sero) {
		  int result = garo*sero;
		  return result;
	}
	
	//배열요소의 각 값의 합.
	public static int sumAry(int[] ary) {
		int sum = 0;
		for(int i=0; i < ary.length; i++) {
			sum += ary[i]; 
		}
		    return sum;
	}
	
	// 두 수를 나눈 결과를 반환하는 메소드
	
	public static double divide(double n1, double n2) {
		double result = n1/n2;
		return result;
	}
	
	//두수를 나누는 작업인데 매개변수를 int타입으로 지정해보는
	
	public static double divide(int n1, int n2) {
		//1bit * 8 = 1byte
		//정수유형 : byte(1byte) < short(2byte) < int(4byte) < long(8byte)
		//실수유형 : float(4byte) < double(8byte)
		double result = (double)n1/ n2;  //형태를 변환해주는 것을 캐스팅(형변환) 이라고 한다
		return result;
	}
	
	public static void main(String[] args) {
//		int result = getArea(20,30);
//		System.out.println("전체 너비는"+ result);
//		
//		
		int[] intAry = {23, 45, 12};
		int result = sumAry(intAry);
		System.out.println("전체 배열요소의 합계는 " + result);
		
		//실수를 나타낼 수 있는 데이터 타입 float, double
		double d1 = 23.4567;
		double d2 = 12.34;
		double d3 = d1 + d2;
		
		d3 = divide(d1,d2);
		System.out.println("나눈 결과는 " + d3);
		
		d3 = divide(3,2);
		System.out.println("나눈 결과는 " + d3);
		
	}
}
