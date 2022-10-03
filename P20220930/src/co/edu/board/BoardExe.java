package co.edu.board;

//정적 메소드를 호출하는 방식으로 

public class BoardExe {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
//		BoardDAO dao = BoardDAO.getInstance(); //정적 메소드를 호출하는 방식으로 호출
		dao.exe();
	}
}
