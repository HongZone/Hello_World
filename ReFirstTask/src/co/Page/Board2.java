package co.Page;

public class Board2 {
	int num;
	String title;
	String content;
	String writer;
	String date;
	int view;
	
	public Board2() {}
	public Board2(int num, String title, String content, String writer, String date, int view) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.view = view;
	}
	public Board2(String title, String content, String writer, String date, int view) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.view = view;
	}
	public Board2(int num, String title, String writer, String date, int view) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.date = date;
		this.view = view;
	}
	public Board2(int num, String title, String content, String writer) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public Board2(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public Board2(String title,String writer, String date, int view) {
		this.title = title;
		this.writer = writer;
		this.date = date;
		this.view = view;
	}
	public Board2(int num) {
		this.num = num;
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
		return " 제목:" + title + " 내용:" + content + " 작성자:" + writer + " 작성날짜:"
				+ date + " 조회수:" + view;
	}
	
	public String subString() {
		return " 제목:" + String.format("%-15s",title) + " 작성자:" + writer + " 작성날짜:" + date + " 조회수:" + view;
	}
//	public String subString() {
//		return String.format("%-5s", " 제목:") + String.format("%-20s", title) + String.format("%3s", " 작성자:") 
//		+ String.format("%3s",writer) + String.format("%3s"," 작성날짜:") + String.format("%10s",date) + String.format("%3s"," 조회수:") + String.format("%3s",view);
//	}
	
	public String detaileString() {
		return num + "  제목:" + title + "\n내용:" + content + "\n작성자:" + writer + " 작성날짜:"
				+ date + " 조회수:" + view;
	}
	
	
}
