package co.edu.api;

public class MorningExe {
	public static void main(String[] args) {
		
		int num = 1;
	for(int i=1; i < 5; i++) {
		for(int j = 1; j <= i; j++) {
			System.out.printf("%2s",num++);
			}
		System.out.println();
		}
	
	System.out.println();
	System.out.println();
	
	int num1 = 1;
	for(int i=1; i < 5; i++) {
		for(int g = 3; g >= i; g--) {
			System.out.printf("%2s"," ");
		}
		
		for(int j = 1; j <= i; j++) {
			System.out.printf("%2s", num1++); 
			
			}
		System.out.println();
		}
	
	}
}
