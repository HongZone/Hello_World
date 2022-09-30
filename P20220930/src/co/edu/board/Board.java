package co.edu.board;

//게시글
public class Board {
	private int boardNo;
	private String title;
	private String content;
	
	public Board() {} //매개변수가 없는 기본생성자

	public Board(int boardNo, String title, String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	@Override
	public String toString() { //내용물을 확인하기 위해서 toString 이라는 메소드를 제공
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}
	
}
