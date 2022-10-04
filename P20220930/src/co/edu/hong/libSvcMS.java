package co.edu.hong;

import java.util.Scanner;

public class libSvcMS {

	
	libSvc[] lib = new libSvc[50];
	
	Scanner scn = new Scanner(System.in);
	boolean run = true;
	
	public void exe() {
		
		while(run) {
					
		System.out.println("1.도서등록 2.도서조회 3.도서상세보기 4.도서삭제 5.종료");
		int all = scn.nextInt();scn.nextLine();
		switch (all) {
		case 1:
			addBook();
			break;
		case 2:
			list();
			break;
		case 3:
			details();
			break;
		case 4:
			bookDel();
			break;
		case 5:
			System.out.println("종료되었습니다");
			run = false;
			break;
			}
		}
		
	}//end of exe
	
	
//	1.도서등록
	
	
	public void addBook(){
		System.out.println("도서번호 입력 >>");
		int num = scn.nextInt();scn.nextLine();
		System.out.println("도서명 입력 >>");
		String name = scn.nextLine();
		System.out.println("도서분류 입력 >>");
		String Ctg = scn.nextLine();
		System.out.println("저자 입력 >>");
		String writer = scn.nextLine();
		System.out.println("출판사 입력 >>");
		String pub = scn.nextLine();
		System.out.println("내용 입력 >>");
		String contents = scn.nextLine();
		libSvc Svc = new libSvc(num, name, Ctg, writer, pub, contents);
		for(int i=0; i < lib.length; i++) {
			if(lib[i] == null) {
				lib[i] = Svc;
				break;
			}else if(lib[i].getBookName().equals(name)) {
				System.out.println("이미 등록된 도서입니다");
				break;
			}
		}
		
	}
	
//	2.도서조회
	public void list(){
		System.out.println(">도서목록<");
		for (int i =0; i <lib.length; i++) {
			if(lib[i] != null) {
				System.out.println(lib[i].getBookName());
			}
		}
	}
//	3.도서상세보기
	public void details() {
			System.out.println("상세보기 도서명>>");
			String ddt = scn.nextLine();
			for(int i =0; i <lib.length; i++) {
				if(lib[i] != null && lib[i].getBookName().equals(ddt)) {
					System.out.println(lib[i].toString());
					
				}
				
			}
		
		}
//	4.도서삭제
	public void bookDel() {
		System.out.println("도서삭제");
		System.out.println("삭제할 도서명>>");
		String Del = scn.nextLine();
		for(int i =0; i <lib.length; i++) {
			if(lib[i] != null && lib[i].getBookName().equals(Del)) {
				lib[i] = null;
				System.out.println("삭제되었습니다");
				break;
			}
		}
	}

	
}//end of class
