package co.ReTask;

import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int i = 0;
		
		while(run) {
			
			for(Board bod : dao.list()) {
				System.out.println(bod.subString());
			}
			
			System.out.println("\n1.글등록 2.상세보기 3.내가 쓴 글 4.종료 5.로그인 6.회원가입");
			int menu = scn.nextInt();scn.nextLine();
			if(menu == 1) {
				//글등록
				System.out.println("로그인 후 이용가능합니다");
			}else if(menu == 2) {
				//상세보기
				System.out.println("상세보기 글번호>>");
				int num = scn.nextInt();scn.nextLine();
				dao.detail(num);
			}else if(menu == 3) {
				//내가 쓴 글 보기
				System.out.println("로그인 후 이용가능합니다");
			}else if(menu == 4) {
				//종료
				break;
			} else if(menu == 5) {
				//로그인
				System.out.println("아이디를 입력해주세요>>");
				String id = scn.nextLine();
				System.out.println("비밀번호를 입력해주세요>>");
				String pw = scn.nextLine();
					if(dao.login(id, pw) == 1) {
						System.out.println("로그인 되었습니다");
						
						
						while(run) {
							for(Board bod : dao.list()) {
								System.out.println(bod.subString());
							}
							System.out.println("1.글등록 2.상세보기 3.내가 쓴 글 보기 4.종료");
							int submenu = scn.nextInt();scn.nextLine();
							if(submenu == 1) {
								//글등록
								System.out.println("글제목>>");
								String title = scn.nextLine();
								System.out.println("글내용>>");
								String content = scn.nextLine();
								Board boad = new Board(title, content, id);
								dao.insert(boad);
								
							}else if(submenu == 2) {
								//상세보기
									System.out.println("상세보기 번호>>");
									int detaile = scn.nextInt();scn.nextLine();
								while(true) {
											System.out.println(dao.detail(detaile));
											System.out.println("1.수정 2.삭제 3.목록");
											int detailmenu = scn.nextInt();scn.nextLine();
											if(detailmenu == 1) {
												System.out.println("제목 수정>>");
												String retitle = scn.nextLine();
												System.out.println("내용 수정>>");
												String recontent = scn.nextLine();
												if(dao.update(detaile, retitle, recontent, id) == 1) {
													System.out.println("수정되었습니다");
												}else {
													System.out.println("작성자만 수정할 수 있습니다");
												}
											}else if(detailmenu == 2) {
													if(dao.delete(detaile, id) == 1 ) {
														System.out.println("삭제되었습니다");
														break;
													}else {
														System.out.println("작성자만 삭제할 수 있습니다");
													}
												
											}else if(detailmenu == 3) {
												break;
										}
										}
							}else if(submenu == 3) {
								//내가 쓴 글 보기
								for(Board bod2 : dao.mylist(id)) {
									System.out.println(bod2.subString());
								}
								 
							}else if(submenu == 4) {
								//종료
								run = false;
								}
						}//end of while
					}else {
						System.out.println("아이디와 비밀번호를 확인해주세요");
					}
					
			}else if(menu == 6) {
				//회원가입
				System.out.println("아이디를 입력해주세요>>");
				String id = scn.nextLine();
				System.out.println("비밀번호를 입력해주세요>>");
				String pw = scn.nextLine();
				System.out.println("이름을 입력해주세요>>");
				String name = scn.nextLine();
				dao.memberShip(id, pw, name);
			}
		}//end of while
	}
}
