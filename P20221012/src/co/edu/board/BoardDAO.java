package co.edu.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD기능 구현 Create /Read /Update /Delete
public class BoardDAO extends DAO {
	
//	public int login(String id, String psw) {
//		String sql = "select passwd from users where id = ?";
//		try {
//			conn = getConnect();
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
//			
//			
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				if(rs.getString(1).equals(psw)) {
//					System.out.println("로그인 성공");
//					return 1;
//				}else {
//					System.out.println("비밀");
//					return 0;
//				}
//			}
//			System.out.println("아이디가 없음");
//			return -1;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			disconnect();
//		}
//		return -2;
//	}
	
//	public int login(String id, String psw) {
//		String sql = "select * from users where id = ? and passwd = ?";
//		int a = 0;
//		try {
//			conn = getConnect();
//			psmt = conn.prepareStatement(sql , ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//			psmt.setString(1, id);
//			psmt.setString(2, psw);
//			
//			
//			rs = psmt.executeQuery();
//			rs.last();
//			if(rs.getRow() == 1) {
//				a = 1;
//				
//			}else {
//				a = 2;
//			}
//				
//				
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			disconnect();
//		}
//		return a;
//		
//	}
	
	public int login(String id, String psw) {
		String sql = "select passwd from users where id = ?";
		int a = 0;
		try {
			conn = getConnect();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(psw)) {
					
					a = 1;	
					
				}else {
					a = 2;
				}
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return a;
		
	}
	

	public void insert(Board bord) {
		//글등록
		String sql = "insert into board (board_num, board_title, board_content, board_writer)\r\n"
				+ "values(?,?,?,?)";
		try {
			conn = getConnect();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bord.getNum());
			psmt.setString(2, bord.getTitle());
			psmt.setString(3, bord.getContent());
			psmt.setString(4, bord.getWriter());
			
			int r = psmt.executeUpdate();
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
				+ "    board_content = ?\r\n"
				+ "where board_num = ?\r\n"
				+ "and board_writer = ?\r\n";
				
		conn = getConnect();
		try {
			psmt =conn.prepareStatement(sql);
			psmt.setString(1, bord.getTitle());
			psmt.setString(2, bord.getContent());
			psmt.setInt(3, bord.getNum());
			psmt.setString(4, bord.getWriter());
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				System.out.println("수정되었습니다");
			}else {
				System.out.println("작성자가 아닙니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
		
//	public void update(Board bord) {
//		//글수정
//		String sql = "update board\r\n"
//				+ "set board_title = ?,\r\n"
//				+ "    board_content = ?,\r\n"
//				+ "where board_num = ?\r\n"
//				+ "and board_writer = ?\r\n";
//				
//		conn = getConnect();
//		try {
//			psmt =conn.prepareStatement(sql);
//			psmt.setString(1, bord.getTitle());
//			psmt.setString(2, bord.getContent());
//			psmt.setInt(3, num);
//			psmt.setString(4, userid);
//			
//			int r = psmt.executeUpdate();
//			if(r == 1) {
//				
//			}else {
//				
//			}
//			System.out.println("변경되었습니다");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			disconnect();
//		}
//	}
		
	
	public void delete(int Num, String userid) {
		//글삭제
		String sql = "delete from board where board_num = ? and board_writer = ?";
		
		try {
			conn = getConnect();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Num);
			psmt.setString(2, userid);
			int r = psmt.executeUpdate();
			
			if(r == 1) {
				System.out.println("삭제되었습니다");
			}else {
				System.out.println("작성자가 틀립니다");
			}
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
						   rs.getString("board_writer"),
						   rs.getString("creation_date")
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
		String sql1 = "update board set cnt=cnt+1 where board_num = ?";
		String sql = "select * from board where board_num = ?";
		conn = getConnect();
		Board bod = null;
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, Num);
			psmt.executeUpdate();
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
	
	public List<Reply> reply(){
		List<Reply> replelist = new ArrayList<>();
		String sql = "select * from reply2";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				replelist.add(new Reply(rs.getInt("rep_seq"),
										rs.getInt(" board_num"),
										rs.getString("rep_content"),
										rs.getString("rep_writer"),
										rs.getString("creation_date")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return replelist;
	}
}
