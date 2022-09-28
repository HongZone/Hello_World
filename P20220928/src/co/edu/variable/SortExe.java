package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {34, 21, 12};
		//반복적인 처리.
		//numAry = {12,21,34}
		// 케이스 : n1>n2>n3 =>
		// 케이스 : n1<n2>n3 =>
		
		if(numAry[0] >numAry[1]) { //34>21
			int temp = numAry[0];
			numAry[0] = numAry[1]; //21 
			numAry[1] = numAry[0];
		}
		for(int n : numAry) {
			System.out.println(n);
		}
	}
}
	
	