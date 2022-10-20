package co.ReTask;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import co.Page.Board2;
import co.Page.PageDAO;

public class BoardDAO extends DAO {
	
	public void pageList() {
		//페이징 목록
		Scanner scn = new Scanner(System.in);
		Queue<Board> queue = new LinkedList<>();
		
		
		for(int i=0; i<list().size();i++) {
			queue.add(list().get(i));
		}
		
		for(int j =0; j<(double) list().size()/3;j++) {
			for(int a=0 ; a<5; a++) {
				if(queue.peek() == null) {
					break;
				}
				System.out.println(queue.poll()); 
			}
			System.out.println("====="+(j+1)+"/"+(int)Math.ceil((double)list().size()/3)+"=====");
			
				System.out.println("1.다음");
				int paging = scn.nextInt();
				if(paging != 1) {
					break;
			} else if(paging == 1){
				if(queue.peek() == null) {
					System.out.println("마지막 페이지입니다");
				}
			}
		}
	}
	
	
	public List<Board> sublist() {
		// 상세보기 불러오기용
		List<Board> subboadlist = new ArrayList<Board>();
		String sql = "select * from board order by board_num";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				subboadlist.add(new Board(rs.getInt("board_num")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return subboadlist;
	}

	public List<Board> list() {
		// 글목록
		List<Board> boadlist = new ArrayList<Board>();
		String sql = "select * from board order by board_num";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				boadlist.add(new Board(String.format("%-15s", rs.getString("board_title")).substring(0, 9) + "...",
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boadlist;

	}

	public ArrayList listindex(String search) {
		// 글목록 인덱스
//		int index = 0;
		ArrayList index = new ArrayList();
		List<Board> boadlist = new ArrayList<Board>();
		String sql = "select * from board order by board_num";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				boadlist.add(new Board(String.format("%-15s", rs.getString("board_title")).substring(0, 9) + "...",
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt")));
			}

			for (int t = 0; t < boadlist.size(); t++) {
				if (boadlist.get(t).getTitle().contains(search) == true) {
					index.add(t + 1);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return index;

	}

	public ArrayList mylistindex(String id) {
		// 내가쓴글 인덱스
//		int index = 0;
		ArrayList index = new ArrayList();
		List<Board> boadlist = new ArrayList<Board>();
		String sql = "select * from board order by board_num";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				boadlist.add(new Board(String.format("%-15s", rs.getString("board_title")).substring(0, 9) + "...",
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt")));
			}

			for (int t = 0; t < boadlist.size(); t++) {
				if (boadlist.get(t).getWriter().equals(id)) {
					index.add(t + 1);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return index;

	}

	public Board listRank() {
		// 글목록랭킹
//		List<Board> boadlist= new ArrayList<Board>(); 
		Board boadlist = new Board();
		String sql = "select * from board where cnt = (select max(cnt) from board)";
//		String sql = "select * from board order by cnt desc limit 1";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				boadlist = new Board(String.format("%-15s", rs.getString("board_title")).substring(0, 9) + "...",
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boadlist;

	}

	public int login(String id, String pw) {
		// 로그인
		int a = 0;
		String sql = "select passwd from users where id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("passwd").equals(pw)) {
					a = 1;
				} else {
					a = 2;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return a;

	}

	public void memberShip(String id, String passwd, String name) {
		// 회원가입
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
		} finally {
			disconnect();
		}
	}

	public void insert(Board board) {
		// 글등록
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
		} finally {
			disconnect();
		}

	}

	public int update(int num, String title, String content, String id) {
		// 글수정
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
			if (r == 1) {
				a = 1;
			} else {
				a = 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return a;

	}

	public int delete(int num, String id) {
		// 글삭제
		int a = 0;
		String sql1 = "delete from comments where boardnumm = ?";
		String sql = "delete from board where board_num = ? and board_writer = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, num);
			psmt.executeUpdate();

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.setString(2, id);

			int r = psmt.executeUpdate();
			if (r == 1) {
				a = 1;
			} else {
				a = 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return a;

	}

	public Board detail(int num) {
		// 글 상세보기
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
			if (rs.next()) {
				boad = new Board(rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boad;

	}

	public List<Board> mylist(String id) {
		// 내가 쓴 글 보기
		List<Board> boad = new ArrayList<Board>();
		String sql = "select * from board where board_writer = ? order by board_num";

		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			while (rs.next()) {
				boad.add(new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_writer"),
						rs.getString("creation_date"), rs.getInt("cnt")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boad;

	}

	public List<Comment> comlist(int num) {
		// 댓글목록
		List<Comment> comlist = new ArrayList<Comment>();
		String sql = "select * from comments where boardnumm = ? order by boardnumm";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			while (rs.next()) {
				comlist.add(new Comment(rs.getInt("comment_num"), rs.getString("comment_writer"),
						rs.getString("comment_content"), rs.getString("comment_date"), rs.getInt("comment_cnt")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return comlist;

	}

	public List<Comment> comlist2(int num) {
		// 댓글목록NUM
		List<Comment> comlist = new ArrayList<Comment>();
		String sql = "select * from comments where boardnumm = ? order by boardnumm";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			while (rs.next()) {
				comlist.add(new Comment(rs.getInt("comment_num")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return comlist;

	}

	public void cominsert(String id, String comment, int num) {
		// 댓글쓰기
		String sql = "insert into comments(comment_num,comment_writer,comment_content, boardnumm)\r\n"
				+ "values(seq2.nextval,?,?,?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, comment);
			psmt.setInt(3, num);

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public int comupdate(String content, int num, String id) {
		// 댓글수정
		int a = 0;
		String sql = "update comments set comment_content=? where comment_num=? and comment_writer=? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, content);
			psmt.setInt(2, num);
			psmt.setString(3, id);
			int r = psmt.executeUpdate();
			if (r == 1) {
				a = 1;
			} else {
				a = 2;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return a;
	}

	public int comdelete(int num, String id) {
		// 댓글삭제
		int a = 0;
		String sql = "delete from comments where comment_num=? and comment_writer=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.setString(2, id);
			int r = psmt.executeUpdate();
			if (r == 1) {
				a = 1;
			} else {
				a = 2;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return a;
	}

	public List<Board> search(String content) {
		List<Board> boad = new ArrayList();
		String sql = "select * from board where board_title like '%'||?||'%' order by board_num";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, content);

			rs = psmt.executeQuery();

			while (rs.next()) {
				boad.add(new Board(String.format("%-15s", rs.getString("board_title")).substring(0, 9) + "...",
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boad;
	}
}
