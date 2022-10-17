package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends DAO {
	Board board = null;

	public int login(String id, String passwd) {
		int a = 0;
		String sql = "select passwd from users where id = ? ";
		conn = getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(passwd)) {
					a=1;
				}else {
					a=2;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
	public void insert(Board board, String id) {
		// 글등록
		String sql = "insert into board(board_num, board_title, board_content, board_writer)\r\n" + "values(?,?,?,?)";
		conn = getConnection();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getNum());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getContent());
			psmt.setString(4, id);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 추가되었습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}

	public int update(String title, String content, int num, String id) {
		// 글수정
		int a=0;
		String sql = "update board set board_title=?, board_content = ? where board_num = ? and board_writer = ?";
		conn = getConnection();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, num);
			psmt.setString(4, id);
			
			int r = psmt.executeUpdate();
			if( r == 1) {
				a=1;
			}else {
				a=2;
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnection();
		}
		return a;
	}

	public int delete(int num, String id) {
		// 글삭제
		int a = 1;
		String sql = "delete from board where board_num = ? and board_writer = ?";
		conn = getConnection();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.setString(2, id);
			
			int r = psmt.executeUpdate();
			if( r == 1) {
				a=1;
			}else {
				a=2;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnection();
		}
		return a;
	}

	public List<Board> list() {
		// 글목록
		List<Board> list = new ArrayList<>();
		String sql = "select * from board order by board_num";
		conn = getConnection();
		
		try {
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_num"),
								rs.getString("board_title"),
								rs.getString("board_writer"),
								rs.getString("creation_date")
						));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnection();
		}
		return list;
		
	}

	public Board detail(int num) {
		// 상세보기
		String sql1 = "update board set cnt = cnt+1 where board_num = ?";
		String sql = "select * from board where board_num = ?";
		Board detail2 = null;
		conn = getConnection();
		
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, num);
			psmt.executeUpdate();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
					  detail2 = new Board(rs.getInt("board_num"),
										  rs.getString("board_title"),
										  rs.getString("board_content"),
										  rs.getString("board_writer"),
										  rs.getString("creation_date"),
										  rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnection();
		}
		return detail2;
		
	}
}
