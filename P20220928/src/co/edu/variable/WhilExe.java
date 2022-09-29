package co.edu.variable;

import java.util.Scanner;

public class WhilExe {
	public static void main(String[] args) {
		whileFnc3();
	}
	
	public static void whileFnc3(){
		//보고싶은 달을 입력. 종료하고 싶으면 9입력
		Scanner scn = new Scanner(System.in);
		while(true) {
		System.out.println("월을 선택하세요. 종료는 -1");
		int input = scn.nextInt();
		if(input == -1) {
			break;
		}
		MethodCalendar.makeCal(input);
		System.out.println();
		}
		System.out.println("end of program");
		scn.close();
	}

	public static void whileFnc2() {
		// while 구문
		Scanner scn = new Scanner(System.in); // System.in = 키보드를 통해서 어떤 값을 입력받겠다 //import = ctlr +shf + o
		while (true) {
			System.out.println("값을 입력하세요 종료하려면 stop 입력");
			String inputVal = scn.nextLine(); // nextLine() + 입력값을 가져오겠다
			if (inputVal.equals("stop")) {
				break;
			}
			System.out.println("사용자 입력 값 >" + inputVal);
		}
		System.out.println("end of progarm");
		scn.close(); // 시스템자원을 반환
	}

	// for 반복문은 반복횟수를 알고 있을 때 사용하면 좋음
	public static void whileFnc() {
		int i = 0;
		while (i < 4) {
			System.out.println(i);
			i++;
		}
		System.out.println("end of program");
	}
}// calss end
