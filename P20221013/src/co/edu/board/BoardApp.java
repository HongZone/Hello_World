package co.edu.board;

import java.util.List;
import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		
		while(true) {
			System.out.println("아이디입력>>");
			String id = scn.nextLine();
			System.out.println("비밀번호입력>>");
			String passwd = scn.nextLine();
			
			if(dao.login(id, passwd) == 1) {
				System.out.println("로그인 성공");
				while(true) {
					System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 9.종료");
					int menu = scn.nextInt();scn.nextLine();
					
					if(menu == 1) {
						//글등록
						System.out.println("글번호>>");
						int num = scn.nextInt();scn.nextLine();
						System.out.println("제목>>");
						String title = scn.nextLine();
						System.out.println("내용>>");
						String content = scn.nextLine();
						Board board = new Board(num, title, content);
						dao.insert(board , id);
					}else if(menu ==2) {
						//글수정
						System.out.println("수정할 글 번호");
						int num = scn.nextInt();scn.nextLine();
						System.out.println("수정할 제목");
						String title = scn.nextLine();
						System.out.println("수정할 내용");
						String content = scn.nextLine();
						
						if(dao.update(title, content, num, id)==1) {
							System.out.println("수정되었습니다");
						}else {
							System.out.println("작성자가 아닙니다");
						}
					}else if(menu ==3) {
						//글삭제
						System.out.println("삭제할 글 번호");
						int num = scn.nextInt();scn.nextLine();
						if(dao.delete(num, id)==1) {
							System.out.println("삭제되었습니다");
						}else {
							System.out.println("작성자가 아닙니다");
						}
					}else if(menu ==4) {
						//글목록
						List<Board>board = dao.list();
						for(Board bbb : board) {
							System.out.println(bbb.subString()); 
						}
						
						
						
					}else if(menu ==5) {
						//상세조회 
						System.out.println("조회할 글 번호");
						int num = scn.nextInt();scn.nextLine();
						System.out.println(dao.detail(num));
					}else if(menu ==9) {
						//종료
						break;
					}
					
				}//end of while
			}else {
				System.out.println("로그인 실패");
			}
		}
		
//		System.out.println("end of prgram");
	}
}
