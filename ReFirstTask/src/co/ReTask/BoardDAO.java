package co.ReTask;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends DAO {

	public List<Board> sublist(){
		//상세보기 불러오기용
		List<Board> subboadlist= new ArrayList<Board>(); 
		String sql = "select * from board";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				subboadlist.add(new Board(rs.getInt("board_num")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return subboadlist;
	}
	
	public List<Board> list() {
		//글목록
		List<Board> boadlist= new ArrayList<Board>(); 
		String sql = "select * from board";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				boadlist.add(new Board(String.format("%-15s",rs.getString("board_title")).substring(0,9)+"...",
										rs.getString("board_writer"),
										rs.getString("creation_date"),
										rs.getInt("cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return boadlist;
		
	}
	
	
	public int login(String id, String pw) {
		//로그인
		int a = 0;
		String sql = "select passwd from users where id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("passwd").equals(pw)) {
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
	
	public void memberShip(String id, String passwd, String name) {
		//회원가입
		String sql = "insert into users(id, passwd,user_name) values(?,?,?)";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			psmt.setString(3, name);
			psmt.executeUpdate();
			System.out.println(">>>>회원가입이 완료되었습니다<<<<");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public void insert(Board board) {
		//글등록
		int NUM = 0;
		String sql = "insert into board (board_num, board_title, board_content, board_writer) values(seq.NEXTVAL,?,?,?)";
		conn = getConnect();
		try {
		
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			
			int r = psmt.executeUpdate();
			System.out.println(board.getWriter() + "님이 " + r + "건의 글을 작성하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	public int update(int num, String title, String content, String id) {
		//글수정
		int a = 0;
		String sql = "update board set board_title=?, board_content = ? where board_num = ? and board_writer = ?";
		
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, num);
			psmt.setString(4, id);
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				a=1;
			}else {
				a=2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return a;
		
		
	}
	
	public int delete(int num, String id) {
		//글삭제 
		int a = 0;
		String sql = "delete from board where board_num = ? and board_writer = ?";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.setString(2, id);
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				a=1;
			}else{
				a=2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return a;
		
	}
	
	public Board detail(int num) {
		//글 상세보기
		Board boad = new Board();
		String sql1 = "update board set cnt = cnt+1 where board_num = ?";
		String sql = "select * from board where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, num);
			psmt.executeUpdate();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				boad = new Board(rs.getInt("board_num"),
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
		return boad;
		
	}
	
	public List<Board> mylist(String id) {
		//내가 쓴 글 보기
		List<Board> boad = new ArrayList<Board>();
		String sql = "select * from board where board_writer = ?";
		
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs=psmt.executeQuery();
			while(rs.next()) {
				boad.add(new Board(rs.getInt("board_num"),
									rs.getString("board_title"),
									rs.getString("board_writer"),
									rs.getString("creation_date"),
									rs.getInt("cnt")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return boad;
		
	}
	
	public List<Comment> comlist(int num) {
		//댓글목록
		List<Comment> comlist= new ArrayList<Comment>(); 
		String sql = "select * from comments where boardnumm = ? order by boardnumm";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			while(rs.next()) {
				comlist.add(new Comment(rs.getInt("comment_num"),
										rs.getString("comment_writer"),
										rs.getString("comment_content"),
										rs.getString("comment_date"),
										rs.getInt("comment_cnt")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return comlist;
		
	}
	public void cominsert(String id,String comment, int num) {
		//댓글쓰기
		String sql = "insert into comments(comment_num,comment_writer,comment_content, boardnumm)\r\n"
					+"values(seq2.nextval,?,?,?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, comment);
			psmt.setInt(3, num);
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	public void comupdate(String content, int num) {
		//댓글수정
		String sql = "update comments set comment_content=? where comment_num=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, content);
			psmt.setInt(2, num);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	public void comdelete(int num) {
		//댓글삭제
		String sql = "delete from comments where comment_num=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	
}
