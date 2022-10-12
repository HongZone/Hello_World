package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD기능 구현 Create /Read /Update /Delete
public class BoardDAO extends DAO {

	public void insert(Board bord) {
		//글등록
		String sql = "insert into board (board_num, board_title, board_content, board_writer)\r\n"
				+ "values("+bord.getNum()+","
				+ bord.getTitle()+","
				+ bord.getContent()+","
				+ bord.getWriter()+","
				+ bord.getDate()+")";
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "개의 글이 등록되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	public void update(Board bord) {
		//글수정
		String sql = "update board\r\n"
				+ "set board_title = ?,\r\n"
				+ "    board_content = ?,\r\n"
				+ "    board_writer = ?,\r\n"
				+ "    creation_date = ?\r\n"
				+ "where board_num = ?";
				
		conn = getConnect();
		try {
			psmt =conn.prepareStatement(sql);
			psmt.setString(1, bord.getTitle());
			psmt.setString(2, bord.getContent());
			psmt.setString(3, bord.getWriter());
			psmt.setString(4, bord.getDate());
			psmt.setInt(5, bord.getNum());
			
			int r = psmt.executeUpdate();
			System.out.println("변경되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
		
		
		
	public void delete(int Num) {
		//글삭제
		String sql = "delete from board where board_num = ?";
		
		try {
			conn = getConnect();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Num);
			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	public List<Board> list() {
		//글목록
		List<Board> bdlist = new ArrayList<>();
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs =stmt.executeQuery("select * from board");
			while(rs.next()) {
				bdlist.add(new Board(rs.getInt("board_num"),
						   rs.getString("board_title"),
						   rs.getString("board_content"),
						   rs.getString("board_writer"),
						   rs.getString("creation_date"),
						   rs.getInt("cnt")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return bdlist;
	}
	public Board search(int Num) {
		//상세조회
		String sql = "select * from board where board_num = ?";
		conn = getConnect();
		Board bod = null;
		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Num);
			rs = psmt.executeQuery();
			if(rs.next()) {
				bod = new Board(rs.getInt("board_num"),
						   rs.getString("board_title"),
						   rs.getString("board_content"),
						   rs.getString("board_writer"),
						   rs.getString("creation_date"),
						   rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return bod;
	}
}
