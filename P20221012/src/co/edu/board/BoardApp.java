package co.edu.board;

import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		
		
		
		while(true) {
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 9.종료");
			int menu = scn.nextInt();
			if(menu == 1) {
				System.out.println("글번호>> ");
				int num = scn.nextInt();
				System.out.println("제목>> ");
				String title = scn.nextLine();
				System.out.println("내용>> ");
				String content = scn.nextLine();
				System.out.println("작성자>> ");
				String writer = scn.nextLine();
				Board dao = new Board(num, title, content, writer);
				bdao.insert(dao);
				
			}else if(menu ==2) {
				System.out.println("(수정)글번호>> ");
				int num = scn.nextInt();
				System.out.println("(수정)제목>> ");
				String title = scn.nextLine();
				System.out.println("(수정)내용>> ");
				String content = scn.nextLine();
				System.out.println("(수정)작성자>> ");
				String writer = scn.nextLine();
				System.out.println("(수정)날짜>> ");
				String date = scn.nextLine();
				Board dao = new Board(num, title, content, writer, date);
				bdao.update(dao);
				
			}else if(menu ==3) {
				System.out.println("삭제할 글번호>> ");
				int num = scn.nextInt();
				bdao.delete(num);
				
			}else if(menu ==4) {
				System.out.println(bdao.list());
				
			}else if(menu ==5) {
				System.out.println("조회할 글번호>> ");
				int num = scn.nextInt();
				System.out.println(bdao.search(num)); 
				
			}else if(menu ==9) {
				bdao.disconnect();
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}
