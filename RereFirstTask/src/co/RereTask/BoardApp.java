package co.RereTask;

import java.util.List;
import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Board bod = new Board();
		Board bod3 = new Board();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int j = 0;
		int index = 0;
		int pageNum=1, from=0, to=0;
		List<Board> sublist = dao.sublist();
		while (run) {
// 첫화면글목록
			List<Board> list = dao.list();
			int totalCnt = list.size();
			int totalPage =(int) Math.ceil(totalCnt/5.0);
			
//			int pageNum=1, from=0, to=0;
			from = (pageNum-1)*5; // 0
			to = (pageNum*5)-1; // 4
			System.out.println(String.format("%-5s", "Best") + dao.listRank().subString());
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			for (j = 0; j < totalCnt; j++) {
				if(j >= from && j <= to) {
				bod = list.get(j);
				System.out.println(String.format("%-5s", j + 1) + bod.subString());
				
				}
			}
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"+pageNum+"/"+totalPage+"ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("                      7.이전   8.다음");
			System.out.println("====0.검색 1.글등록 2.상세보기 3.내가 쓴 글 4.종료 5.로그인 6.회원가입====");
			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
// 글등록
				System.out.println(">>>>로그인 후 이용가능합니다<<<<");

			} else if (menu == 2) {
// 상세보기
				System.out.println("상세보기 번호>>");
				int detaile2 = scn.nextInt();
				scn.nextLine();
				while (true) {
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
					System.out.println(detaile2 + dao.detail(sublist.get(detaile2 - 1).getNum()).toString());
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
					for (int e = 0; e < dao.comlist(sublist.get(detaile2 - 1).getNum()).size(); e++) {
						Comment com = dao.comlist(sublist.get(detaile2 - 1).getNum()).get(e);
						System.out.println(e + 1 + com.toString());
					}
					System.out.println("====1.수정 2.삭제 3.목록 4.댓글쓰기 5.댓글수정 6.댓글삭제====");
					int detailmenu2 = scn.nextInt();
					scn.nextLine();
					if (detailmenu2 == 1) {
						System.out.println(">>>>로그인 후 사용가능합니다<<<<");
						break;
					} else if (detailmenu2 == 2) {
						System.out.println(">>>>로그인 후 사용가능합니다<<<<");
						break;
					} else if (detailmenu2 == 3) {
						break;
					} else if (detailmenu2 == 4) {
						System.out.println(">>>>로그인 후 사용가능합니다<<<<");
						break;
					} else if (detailmenu2 == 5) {
						System.out.println(">>>>로그인 후 사용가능합니다<<<<");
						break;
					} else if (detailmenu2 == 6) {
						System.out.println(">>>>로그인 후 사용가능합니다<<<<");
						break;
					}
				}
			} else if (menu == 3) {
// 내가 쓴 글 보기
				System.out.println(">>>>로그인 후 이용가능합니다<<<<");
			} else if (menu == 4) {
// 종료
				break;
			} else if (menu == 5) {
// 로그인
				System.out.println("아이디를 입력해주세요>>");
				String id = scn.nextLine();
				System.out.println("비밀번호를 입력해주세요>>");
				String pw = scn.nextLine();
				if (dao.login(id, pw) == 1) {
					System.out.println(">>>>로그인 되었습니다<<<<");

					while (run) {
						list = dao.list();
						totalCnt = list.size();
						totalPage =(int) Math.ceil(totalCnt/5.0);
						from = (pageNum-1)*5; // 0
						to = (pageNum*5)-1; // 4
						System.out.println(String.format("%-5s", "Best") + dao.listRank().subString());
						System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
						for (int y = 0; y < totalCnt; y++) {
							if(y >= from && y <= to) {
							bod = list.get(y);
							System.out.println(String.format("%-5s", y + 1) + bod.subString());
							}
						}
						System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"+pageNum+"/"+totalPage+"ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
						System.out.println("               7.이전   8.다음");
						System.out.println("====0.검색 1.글등록 2.상세보기 3.내가 쓴 글 4.종료====");
						int submenu = scn.nextInt();
						scn.nextLine();
						if (submenu == 1) {
// 로그인 후 글등록
							System.out.println("글제목>>");
							String title = scn.nextLine();
							System.out.println("글내용>>");
							String content = scn.nextLine();
							Board boad = new Board(title, content, id);
							dao.insert(boad);
							continue;
						} else if (submenu == 2) {
// 로그인 후 상세보기
							System.out.println("상세보기 번호>>");
							int detaile = scn.nextInt();
							scn.nextLine();
							while (true) {
								System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
								System.out.println(
										detaile + dao.detail(sublist.get(detaile - 1).getNum()).toString());
								System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//댓글목록
//댓글번호대로 정렬
								for (int e = 0; e < dao.comlist(sublist.get(detaile - 1).getNum()).size(); e++) {
									Comment com = dao.comlist(sublist.get(detaile - 1).getNum()).get(e);
									System.out.println(e + 1 + com.toString());
								}
								System.out.println("====1.수정 2.삭제 3.목록 4.댓글쓰기 5.댓글수정 6.댓글삭제====");
								int detailmenu = scn.nextInt();
								scn.nextLine();
								if (detailmenu == 1) {
//상세글 수정
									System.out.println("제목 수정>>");
									String retitle = scn.nextLine();
									System.out.println("내용 수정>>");
									String recontent = scn.nextLine();
									if (dao.update(sublist.get(detaile - 1).getNum(), retitle, recontent,
											id) == 1) {
										System.out.println(">>>>수정되었습니다<<<<");
									} else {
										System.out.println(">>>>작성자만 수정할 수 있습니다<<<<");
									}
								} else if (detailmenu == 2) {
//상세글 삭제
									if (dao.delete(sublist.get(detaile - 1).getNum(), id) == 1) {
										System.out.println(">>>>삭제되었습니다<<<<");
										break;
									} else {
										System.out.println(">>>>작성자만 삭제할 수 있습니다<<<<");
									}

								} else if (detailmenu == 3) {
//상세글 목록으로 돌아가기
									break;
								} else if (detailmenu == 4) {
//댓글쓰기
									System.out.println("댓글 내용>>");
									String comment = scn.nextLine();
									dao.cominsert(id, comment, sublist.get(detaile - 1).getNum());
								} else if (detailmenu == 5) {
//댓글수정
									System.out.println("수정할 댓글번호>>");
									int comnum = scn.nextInt();
									scn.nextLine();
									System.out.println("수정할 내용>>");
									String comcon = scn.nextLine();
									// dao.comupdate(comcon, comnum);
									if (dao.comupdate(comcon, dao.comlist2(sublist.get(detaile - 1).getNum())
											.get(comnum - 1).getCnum(), id) != 1) {
										System.out.println(">>>>작성자가 아닙니다<<<<");
									}

								} else if (detailmenu == 6) {
//댓글삭제
									System.out.println("삭제할 댓글번호>>");
									int comnum2 = scn.nextInt();
									scn.nextLine();
									if (dao.comdelete(comnum2, id) != 1) {
										System.out.println(">>>>작성자만 삭제 가능합니다<<<<");
									}

								}

							}
						} else if (submenu == 3) {
//로그인 후 내가 쓴 글 보기
							boolean run7 = true;
							while (run7) {
								System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
								for (int p = 0; p < dao.mylist(id).size(); p++) {
									bod3 = dao.mylist(id).get(p);
									System.out.println(dao.mylistindex(id).get(p) + bod3.subString());
								}
								System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
								System.out.println("====1.상세보기 2.목록====");
								int menu6 = scn.nextInt();
								scn.nextLine();
								if (menu6 == 1) {
									System.out.println("상세보기 번호>>");
									int detailenum0 = scn.nextInt();
									scn.nextLine();
									boolean run4 = true;
									while (run4) {
//내가 쓴 글에서 상세글
										System.out
												.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
										System.out.println(detailenum0
												+ dao.detail(sublist.get(detailenum0 - 1).getNum()).toString());
										System.out
												.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
										// 댓글번호대로 정렬
										for (int e = 0; e < dao.comlist(sublist.get(detailenum0 - 1).getNum())
												.size(); e++) {
											Comment com = dao.comlist(sublist.get(detailenum0 - 1).getNum())
													.get(e);
											System.out.println(e + 1 + com.toString());
										}
										System.out.println("====1.수정 2.삭제 3.목록 4.댓글쓰기 5.댓글수정 6.댓글삭제====");
										int detailmenu = scn.nextInt();
										scn.nextLine();
										if (detailmenu == 1) {
//내가 쓴 글에서 글수정
											System.out.println("제목 수정>>");
											String retitle = scn.nextLine();
											System.out.println("내용 수정>>");
											String recontent = scn.nextLine();
											if (dao.update(sublist.get(detailenum0 - 1).getNum(), retitle,
													recontent, id) == 1) {
												System.out.println(">>>>수정되었습니다<<<<");
											} else {
												System.out.println(">>>>작성자만 수정할 수 있습니다<<<<");
											}
										} else if (detailmenu == 2) {
//내가 쓴 글에서 글삭제
											if (dao.delete(sublist.get(detailenum0 - 1).getNum(), id) == 1) {
												System.out.println(">>>>삭제되었습니다<<<<");
												break;
											} else {
												System.out.println(">>>>작성자만 삭제할 수 있습니다<<<<");
											}

										} else if (detailmenu == 3) {
//내가 쓴 글에서 목록으로 돌아가기
											run7 = false;
											run4 = false;
										} else if (detailmenu == 4) {
//내가 쓴 글에서 댓글쓰기
											System.out.println("댓글 내용>>");
											String comment = scn.nextLine();
											dao.cominsert(id, comment, sublist.get(detailenum0 - 1).getNum());
										} else if (detailmenu == 5) {
//내가 쓴 글에서 댓글수정
											System.out.println("수정할 댓글번호>>");
											int comnum = scn.nextInt();
											scn.nextLine();
											System.out.println("수정할 내용>>");
											String comcon = scn.nextLine();
											if (dao.comupdate(comcon,
													dao.comlist2(sublist.get(detailenum0 - 1).getNum())
															.get(comnum - 1).getCnum(),
													id) != 1) {
												System.out.println(">>>>작성자가 아닙니다<<<<");
											}

										} else if (detailmenu == 6) {
//내가 쓴 글에서 댓글삭제
											System.out.println("삭제할 댓글번호>>");
											int comnum2 = scn.nextInt();
											scn.nextLine();
											if (dao.comdelete(comnum2, id) != 1) {
												System.out.println(">>>>작성자만 삭제 가능합니다<<<<");
											}

										}

									}

								} else if (menu6 == 2) {
									break;
								}

							}

/////////////////////////////////////
						} else if (submenu == 4) {
// 로그인 후 종료
							run = false;
							System.out.println("종료되었습니다");

						} else if (submenu == 0) {
// 로그인 후 검색
							boolean run3 = true;
							while (run3) {
								System.out.println("검색>>");
								String contentSearch = scn.nextLine();
								for (int o = 0; o < dao.search(contentSearch).size(); o++) {
									System.out.println(dao.listindex(contentSearch).get(o)
											+ dao.search(contentSearch).get(o).subString());
									}
									System.out.println("====1.상세보기 2.목록====");
									int menu3 = scn.nextInt();
									scn.nextLine();
									if (menu3 == 1) {
										System.out.println("상세보기 번호>>");
										int detailenum = scn.nextInt();
										scn.nextLine();
										boolean run4 = true;
										while (run4) {
// 로그인 후 검색에서 상세글
											System.out.println(
													"ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
											System.out.println(detailenum + dao
													.detail(sublist.get(detailenum - 1).getNum()).toString());
											System.out.println(
													"ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
											// 댓글번호대로 정렬
											for (int e = 0; e < dao.comlist(sublist.get(detailenum - 1).getNum())
													.size(); e++) {
												Comment com = dao.comlist(sublist.get(detailenum - 1).getNum())
														.get(e);
												System.out.println(e + 1 + com.toString());
											}
											System.out.println("====1.수정 2.삭제 3.목록 4.댓글쓰기 5.댓글수정 6.댓글삭제====");
											int detailmenu = scn.nextInt();
											scn.nextLine();
											if (detailmenu == 1) {
// 로그인 후 검색에서 상세글 수정
												System.out.println("제목 수정>>");
												String retitle = scn.nextLine();
												System.out.println("내용 수정>>");
												String recontent = scn.nextLine();
												if (dao.update(sublist.get(detailenum - 1).getNum(), retitle,
														recontent, id) == 1) {
													System.out.println(">>>>수정되었습니다<<<<");
												} else {
													System.out.println(">>>>작성자만 수정할 수 있습니다<<<<");
												}
											} else if (detailmenu == 2) {
// 로그인 후 검색에서 상세글 삭제
												if (dao.delete(sublist.get(detailenum - 1).getNum(), id) == 1) {
													System.out.println(">>>>삭제되었습니다<<<<");
													break;
												} else {
													System.out.println(">>>>작성자만 삭제할 수 있습니다<<<<");
												}

											} else if (detailmenu == 3) {
// 로그인 후 검색에서 상세글 목록으로 돌아가기
												run3 = false;
												run4 = false;
											} else if (detailmenu == 4) {
// 로그인 후 검색에서 상세글 댓글쓰기
												System.out.println("댓글 내용>>");
												String comment = scn.nextLine();
												dao.cominsert(id, comment, sublist.get(detailenum - 1).getNum());
											} else if (detailmenu == 5) {
// 로그인 후 검색에서 상세글 댓글수정
												System.out.println("수정할 댓글번호>>");
												int comnum = scn.nextInt();
												scn.nextLine();
												System.out.println("수정할 내용>>");
												String comcon = scn.nextLine();
												if (dao.comupdate(comcon,
														dao.comlist2(sublist.get(detailenum - 1).getNum())
																.get(comnum - 1).getCnum(),
														id) != 1) {
													System.out.println(">>>>작성자가 아닙니다<<<<");
												}

											} else if (detailmenu == 6) {
// 로그인 후 검색에서 상세글 댓글삭제
												System.out.println("삭제할 댓글번호>>");
												int comnum2 = scn.nextInt();
												scn.nextLine();
												if (dao.comdelete(comnum2, id) != 1) {
													System.out.println(">>>>작성자만 삭제 가능합니다<<<<");
												}

											}

										}

									} else if (menu3 == 2) {
										run3 = false;
									}
							}
						}else if(submenu ==7) {
							if(pageNum > 1) {
								pageNum = pageNum-1;
							}else {
								System.out.println("첫번째 페이지 입니다");
							}
						}else if(submenu ==8) {
							if(pageNum < totalPage) {
								pageNum = pageNum+1;
							}else{
								System.out.println("마지막 페이지 입니다");
							}
						}
					} // end of while
				} else {
					System.out.println(">>>>아이디와 비밀번호를 확인해주세요<<<<");
				}

			} else if (menu == 6) {
// 회원가입		
				MailApp mailApp = new MailApp();
				System.out.println("아이디를 입력해주세요>>");
				String id = scn.nextLine();
				System.out.println("비밀번호를 입력해주세요>>");
				String pw = scn.nextLine();
				System.out.println("이름을 입력해주세요>>");
				String name = scn.nextLine();
				System.out.println("메일을 입력해주세요>>");
				String email = scn.nextLine();
				mailApp.sendMail("ghdtlr1233@naver.com", email, "인증", "64");
				while(true) {
				System.out.println("메일 확인 후 인증번호를 입력해주세요");
				String check = scn.nextLine();
				if(check.equals("64")) {
					dao.memberShip(id, pw, name, email);
					break;
					}
				}

			} else if (menu == 0) {
//로그인 전 검색
				boolean run1 = true;
				while (run1) {
					System.out.println("검색>>");
					String contentSearch = scn.nextLine();
					for (int o = 0; o < dao.search(contentSearch).size(); o++) {
						System.out.println(
								dao.listindex(contentSearch).get(o) + dao.search(contentSearch).get(o).subString());
						}
						System.out.println("====1.상세보기 2.목록====");
						int menu5 = scn.nextInt();
						scn.nextLine();
						if (menu5 == 1) {
							System.out.println("상세보기 번호>>");
							int detailenum = scn.nextInt();
							scn.nextLine();
							boolean run5 = true;
							while (run5) {
// 로그인 전 상세글
								System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
								System.out.println(
										detailenum + dao.detail(sublist.get(detailenum - 1).getNum()).toString());
								System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
// 댓글번호대로 정렬
								for (int e = 0; e < dao.comlist(sublist.get(detailenum - 1).getNum())
										.size(); e++) {
									Comment com = dao.comlist(sublist.get(detailenum - 1).getNum()).get(e);
									System.out.println(e + 1 + com.toString());
								}
								System.out.println("====1.수정 2.삭제 3.목록 4.댓글쓰기 5.댓글수정 6.댓글삭제====");
								int detailmenu2 = scn.nextInt();
								scn.nextLine();
								if (detailmenu2 == 1) {
//로그인 전 글수정
									System.out.println(">>>>로그인 후 이용가능<<<<");
									break;
								} else if (detailmenu2 == 2) {
//로그인 전 글삭제
									System.out.println(">>>>로그인 후 이용가능<<<<");
									break;

								} else if (detailmenu2 == 3) {
//로그인 전 글 목록으로 돌아가기
									run5 = false;
								} else if (detailmenu2 == 4) {
//로그인 전 댓글쓰기
									System.out.println(">>>>로그인 후 이용가능<<<<");
									break;
								} else if (detailmenu2 == 5) {
//로그인 전 댓글수정
									System.out.println(">>>>로그인 후 이용가능<<<<");
									break;

								} else if (detailmenu2 == 6) {
//로그인 전 댓글삭제
									System.out.println(">>>>로그인 후 이용가능<<<<");
									break;

								}

							}
							run1 = false;
						} else if (menu5 == 2) {
							run1 = false;
							break;
						}
				}
			}else if(menu == 7){
				if(pageNum > 1) {
					pageNum = pageNum-1;
				}else {
					System.out.println("첫번째 페이지 입니다");
				}
			}else if(menu == 8) {
				if(pageNum < totalPage) {
					pageNum = pageNum+1;
				}else{
					System.out.println("마지막 페이지 입니다");
				}
			}
		} // end of while
	}
}
