package co.edu.board;

import java.util.Scanner;

//기능만
public class BoardDAO {
	//Singletone 방식의 인스턴스 생성
//	private static BoardDAO instance = new BoardDAO();
//	private BoardDAO() {}
//	public static BoardDAO getInstance() {
//		return instance;
//	}
	
	
	
	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100];

	//1.글등록
	public void addBoard() {
		System.out.println("글등록 기능");
		System.out.println("글번호 입력>>");
		int bNo = scn.nextInt();scn.nextLine();				
		System.out.println("글제목 입력>>");
		String title = scn.nextLine();
		System.out.println("글내용 입력>>");
		String content = scn.nextLine();
		
		Board brd = new Board(bNo, title, content);
		for(int i=0; i< myBoards.length; i++) {
			if(myBoards[i]==null) {
			myBoards[i] = brd;
			break;
			}
		}
		
		for(int i = 0; i < myBoards.length; i++) {
			if(myBoards[i].getBoardNo() == bNo) {
				System.out.println("중복된 글번호입니다");
				
					break;
			}
		}
		
	}
	
	//2.글목록
	public void boardList() {
		System.out.println("글목록 기능");
		for(Board brd : myBoards) {
			if(brd != null) {
				System.out.println(brd.toString());
			}
		}
	}
	//3.글상세보기 //글번호
	public void boardDetail() {
		System.out.println("상세보기 기능");
		System.out.println("글번호를 입력하세요>>");
		int textnum = scn.nextInt();
		for(int i = 0; i < myBoards.length; i++) {
			if(myBoards[i].getBoardNo() == textnum) {
				System.out.println(myBoards[i]);
				break;
			}
		}
	}
	//4.글삭제 글에다가 널
	public void delBoard() {
		System.out.println("글 삭제 기능");
		System.out.println("삭제할 글번호 입력>>");
		int delNum = scn.nextInt();
		for(int i = 0; i < myBoards.length; i++) {
			if(myBoards[i].getBoardNo() == delNum) {
				myBoards[i] = null;
					break;
			}
		}
		System.out.println("글을 삭제하였습니다");
	}
	//5.전체메뉴
	public void exe() {
		boolean run = true;
		while(run) {
			System.out.println("1.글등록 2.글목록 3.상세보기 4.글삭제 9.종료");
			System.out.print("선택>>");
			
			int menu = scn.nextInt();
			switch(menu) {
			case 1: 
				addBoard(); 
				break;
			case 2: 
				boardList(); 
				break;
			case 3:
				boardDetail();
				break;
			case 4:
				delBoard();
				break;
			case 9:		
				run = false;				
				break;
			default:
				System.out.println("잘못된 메뉴입니다");
			}
		}//end of while
		System.out.println("프로그램 종료");
	}// end of exe()
}
