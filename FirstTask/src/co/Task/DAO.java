package co.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;
	
	public Connection getConnect() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
//			System.out.println("연결성공");
		}catch(Exception e) {
			System.out.println("연결실패");
		}
		return conn;
	}
	
	public void disconnect() {
		try {
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();
		if(psmt != null)psmt.close();
		if(conn != null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
