package co.edu.board;

public class Board {
	int num;
	String title;
	String content;
	String user;
	String date;
	int cnt;
	
	public Board() {}
	public Board(int num, String title, String content, String user, String date, int cnt) {
		this.num=num;
		this.title = title;
		this.content =content;
		this.user = user;
		this.date = date;
		this.cnt = cnt;
	}
	public Board(int num, String title, String user, String date, int cnt) {
		this.num=num;
		this.title = title;
		this.user = user;
		this.date = date;
		this.cnt = cnt;
	}
//	public Board(int num, String title, String user, String date) {
//		this.num=num;
//		this.title = title;
//		this.user = user;
//		this.date = date;
//	}
	public Board(int num, String title, String content) {
		this.num=num;
		this.title = title;
		this.content =content;
	}
	public Board(int num, String title, String user, String date) {
		this.num=num;
		this.title = title;
		this.user = user;
		this.date = date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "글번호:" + num + ", 제목:" + title + ", 내용:" + content + ", 글쓴이" + user + ", 날짜" + date + ", 조회수" + cnt;
	}
	
	public String subString() {
		return "글번호:" + num + ", 제목:" + title + ", 글쓴이" + user + ", 날짜" + date;
	}
	
	
}
