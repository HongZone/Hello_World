package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.dao.BoardDAO;

public class BoardServiceImpl implements BoardService{

	BoardDAO dao = new BoardDAO();
	
	@Override
	public BoardVO insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO findBoard(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
