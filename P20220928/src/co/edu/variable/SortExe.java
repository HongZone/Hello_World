package co.edu.variable;

public class SortExe {
		public static void main(String[] args) {
		int[] numAry = {34, 21, 12, 9}; //34, 21, 12, 9 / 21,34,12,9 / 21,12,34,9/21,12,9,34   /12,21,9,34/12,9,21,34/     9,12,21,34
		//반복적인 처리.
		//numAry = {12,21,34}
		// 케이스 : n1>n2>n3 =>
		// 케이스 : n1<n2>n3 =>
	for(int j=0; j < numAry.length - 1; j++) {
		for(int i=0; i<numAry.length - 1; i++) {
			if(numAry[i] > numAry[i+1]) {
				int temp = 0;
				temp=numAry[i];
				numAry[i] = numAry[i+1];
				numAry[i+1] = temp;
				
			}
		}
	}
		
	for(int n : numAry) {
		System.out.print(n + " ");}
		
		
		
//		if(numAry[0] >numAry[2]) {
//		    int temp = numAry[0];
//			numAry[0] = numAry[2]; //21 
//			numAry[2] = temp;
//		}
        //	순서출력	
//		for(int n : numAry) {
//			System.out.print(n + " ");
//		}
		
	}
}
	
	