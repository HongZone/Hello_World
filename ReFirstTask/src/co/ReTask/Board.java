package co.ReTask;

public class Board {
	int num;
	String title;
	String content;
	String writer;
	String date;
	int view;
	
	public Board() {}
	public Board(int num, String title, String content, String writer, String date, int view) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.view = view;
	}
	public Board(int num, String title, String writer, String date, int view) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.date = date;
		this.view = view;
	}
	public Board(int num, String title, String content, String writer) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
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
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	@Override
	public String toString() {
		return num + "  제목:" + title + " 내용:" + content + " 작성자:" + writer + " 작성날짜:"
				+ date + " 조회수:" + view;
	}
	
	public String subString() {
		return num + "  제목:" + title + " 작성자:" + writer + " 작성날짜:" + date + " 조회수:" + view;
	}
	
	
	
}
