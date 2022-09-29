package co.edu.variable;

import java.util.Scanner;

public class whileBank {
	public static void main(String[] args) {
		bankApp();
	}
	
	public static void bankApp() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int money = 0;
		//메뉴 :  1:예금 2:출금 3:잔고 4:종료
		//저금할 수 있는 금액이 10만원이 넘어서면 예금을 못받는다
		while(run){
			System.out.println("메뉴: 1:예금, 2:출금, 3:잔고, 4:종료");
			int menu = scn.nextInt();
			
	
		
			
			switch(menu) {
			case 1:
				System.out.println("예금처리하는 메뉴");
				System.out.println("예금액을 입력>>>");
				int input = scn.nextInt();
				money = money + input;
				if(money > 100000) {
					System.out.println("잔고 10만원 이상은 예금 불가합니다");
					money = money-input;
				}
				break;
			case 2:
				System.out.println("출금처리하는 메뉴");
				System.out.println("얼마를 출금하시겠습니까");
				int output = scn.nextInt();
				money = money - output;
				if(money < output ) {
					System.out.println("잔고가 0원 입니다");
				    money = money + output;
				}
				break;
			case 3:
				System.out.println("잔고처리하는 메뉴");
				System.out.println("현재 잔고는 :" + money);
				
				break;
			case 4:
				System.out.println("종료하는 메뉴"); 
				run = false;
			}
			
		}//end of wile
		System.out.println("end of program");
	}
	
}//클래스 엔드
