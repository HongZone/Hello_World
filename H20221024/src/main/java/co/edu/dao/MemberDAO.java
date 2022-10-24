package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO{
	//생성, 수정, 삭제, 한건조회, 목록조회
	
	public void memberInsert(MemberVO vo) {
		String sql = "insert into members(id, passwd, name, email) values(?,?,?,?)";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력 가능");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	
	public MemberVO memberSearch(String id) {
		String sql = "select * from members where id = ?";
		conn = getConnect();
		MemberVO member = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO (rs.getString("id"),rs.getString("passwd"),rs.getString("name"),rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return member;
	}
	
	
	public void memberUpdate(MemberVO vo) {
		String sql = "update members set id=? passwd=? name=? email=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 수정되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	
	public void memberDelete(String id) {
		String sql = "delete from members where id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	
	}
	
	public List<MemberVO> memberList(){
		List<MemberVO> member = new ArrayList<MemberVO>();
		String sql = "select * from members";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				member.add(new MemberVO(rs.getString("id"),rs.getString("passwd"),rs.getString("name"),rs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return member;
	}
	
}
