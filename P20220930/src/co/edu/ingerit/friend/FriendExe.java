package co.edu.ingerit.friend;
	//친구를 등록하는데 학교친구인지 회사친구인지 그 외 그냥 친구인지

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe {
	boolean run = true;
	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList();
	
	public void exe() {
		while(run) {
			System.out.println("1.등록 2.조회 3.종료");
			System.out.println("선택>>");	
			int menu = scn.nextInt();scn.nextLine();
			if(menu == 1) {
				System.out.println("1.회사친구 2.학교친구 3.친구");
				int subMenu = scn.nextInt();scn.nextLine();
				if (subMenu == 1) {
					addComFriend();
					
				}else if (subMenu == 2) {
					addUnivFriend();	
					
				}else if (subMenu == 3) {
					addFriend();	
					
				}
				
			}else if(menu == 2) {
				searchFriend();
				
			}else if(menu == 3) {
				run = false;
			}else {
				System.out.println("잘못된 메뉴를 선택했습니다");
			}
		}
		System.out.println("프로그램 종료");
	}//end of exe()
	//추가 메소드
	//친구등록
	public void addComFriend() {
		System.out.println("이름>>");
		String name = scn.nextLine();
		System.out.println("전화번호>>");
		String num = scn.nextLine();
		System.out.println("회사명>>");
		String com = scn.nextLine();
		System.out.println("부서>>");
		String depart = scn.nextLine();
		ComFriend cfrnd = new ComFriend(name, num, com, depart);
//		for(int i =0; i<friends.length ; i++) {
//			if(friends[i] == null) {
//				friends[i] = cfrnd;
//				break;
//			}	
//		}
			friends.add(cfrnd);
			
	}
	public void addUnivFriend() {
		System.out.println("이름>>");
		String name = scn.nextLine();
		System.out.println("전화번호>>");
		String num = scn.nextLine();
		System.out.println("학교명>>");
		String univer = scn.nextLine();
		System.out.println("학과>>");
		String mj = scn.nextLine();
		UnivFriend ufrnd = new UnivFriend(name, num, univer, mj);
//		for(int i =0; i<friends.length ; i++) {
//			if(friends[i] == null) {
//				friends[i] = ufrnd;
//				break;
//			}
//		}
		
			friends.add(ufrnd);
			
	}
	public void addFriend() {
		System.out.println("이름>>");
		String name = scn.nextLine();
		System.out.println("전화번호>>");
		String num = scn.nextLine();
		Friend jfrnd = new Friend(name, num);
//		for(int i =0; i<friends.length ; i++) {
//			if(friends[i] == null) {
//				friends[i] = jfrnd;
//				break;
//			}
//		}
		
			friends.add(jfrnd);
			
	}
//end of 친구등록	
	
	//친구조회 //자바 문자열 포함 권수미, 권미현, 강민기 = "권"만 넣어도 권수미, 권미현이 검색되도록 
	public void searchFriend() {
		System.out.println("조회할 친구이름 입력>>");
		String findFrnd = scn.nextLine();
//		for(int i =0; i<friends.length ; i++) {
//			if(friends[i] != null && friends[i].getName().contains(findFrnd)) { 
//				System.out.println(friends[i].showInfo());
		
		for(int i = 0; 0 < friends.size(); i++) {  
			Object frnd = friends.get(i);
			if(frnd instanceof Friend) { 
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo());
				
			}else if(frnd instanceof ComFriend) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo());
				
			}else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}
//			System.out.println(frnd.showInfo());
			break;
	 	}												
	}	
}
