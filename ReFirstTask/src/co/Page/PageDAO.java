package co.Page;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageDAO extends DAO  {

	public List<Board2> list() {
		// 글목록
		List<Board2> boadlist = new ArrayList<Board2>();
		String sql = "select * from board order by board_num";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				boadlist.add(new Board2(String.format("%-15s", rs.getString("board_title")).substring(0, 9) + "...",
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boadlist;

	}
	
}//end of class
