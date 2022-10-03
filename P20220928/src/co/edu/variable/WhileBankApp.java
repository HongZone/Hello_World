package co.edu.variable;

import java.util.Scanner;

//계좌정보 선언:계좌번호, 예금주, 잔고
//은행 계좌생성:Account[] banks;
public class WhileBankApp {
	
	
	
	public static void main(String[] args) {
		//메뉴: 1.예금, 2.출금, 3.잔액, 4.종료
		boolean run = true;
		
		
		Account[]banks = new Account[10];
				
		Scanner scn = new Scanner(System.in);
		while (run) {
			System.out.println("0.계좌생성, 1.예금, 2.출금, 3.잔액, 4.종료");
			int menu = scn.nextInt();scn.nextLine();
			
			if(menu == 1) {
				//예금기능 . 어떤 계좌번호에 얼마를 넣겠습니까
				System.out.println("계좌번호>>>");
				String accNo = scn.nextLine();
				
				System.out.println("예금할 금액>>>");
				int money = scn.nextInt();
				
				
				for(int i = 0; i < banks.length; i++) {
					if(banks[i] != null && banks[i].getAccNo().equals(accNo)) {
					banks[i].setBalance(banks[i].getBalance() + money);			
					}
				}
				
			}else if(menu ==2) {
				//출금
				System.out.println("계좌번호>>>");
				String outNo = scn.nextLine();
				System.out.println("얼마를 출금하시겠습니까?");
				int outmoney = scn.nextInt();
				for(int i =0; i< banks.length; i++) {
					if(banks[i] != null && banks[i].getAccNo().equals(outNo)) {
						if(banks[i].getBalance()<outmoney) {
							System.out.println("출금할 수 없습니다");
						}else {
							banks[i].setBalance(banks[i].getBalance()-outmoney);
						}
					}
				}
				
						
			}else if(menu ==3) {
				System.out.println("조회할 계좌번호 입력>>>");
				String accNo = scn.nextLine();
				for(int i=0; i< banks.length; i++) {
					if(banks[i] != null && banks[i].getAccNo().equals(accNo)) {
						System.out.println("잔액 :" + banks[i].getBalance());
					}
				}
			}else if(menu ==4) {
				System.out.println("종료되었습니다");
				run = false;
			}else if(menu ==0) {
				//계좌번호 생성
				System.out.println("계좌번호 입력>>>");
				String accNo = scn.nextLine();
				System.out.println("예금주>>>");
				String owner = scn.nextLine();
				
				Account acc = new Account(accNo, owner); // 인스턴트 생성
				
				//계좌가 비어있는지 확인 후 없으면 넣고 있으면 다음 넘어가고
				for(int i=0;i<banks.length;i++) {
					if(banks[i] == null) {
						//한건입력.break
						banks[i] = acc;
						break;
					}
				}
							System.out.println("계좌생성완료");
			}
		}
		
	}
	
}
