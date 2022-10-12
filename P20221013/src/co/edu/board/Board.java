package co.edu.board;

public class Board {
	int num;
	String title;
	String content;
	String writer;
	String date;
	int cnt;
	
	public Board(int num, String title, String content, String writer, String date, int cnt) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.cnt = cnt;
	}
	
	public Board(int num, String title, String content, String writer) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public Board(int num, String title, String content, String writer, String date) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}
	public String nowdate() {
		long time = System.currentTimeMillis();
		
		String times = (time/1000)/60/60/24+"일 "+(time/1000)/60/60+"시 "+(time/1000)/60+"분 " + time/100 +"초";
		
		return times;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
		return "글번호: "+ num +" 제목: "+title +" 내용: "+content+" 작성자: "+writer+" 작성일시: "+date+" 읽은횟수: "+cnt;
	}
	
}
