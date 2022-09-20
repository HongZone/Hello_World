package com.prod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ojdbc라이브러리, 오라클DB 연결(db접속주소,hr,hr), Connection객체,
// query실행(Statement, PreparedStatement)
public class JDBCSample {
//	DriverManager
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement psmt;

	public static Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.14:49161:xe", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("연결성공!!");
		return conn;
	}

	public static void disconnect() {
		try {
			if (rs != null)
				rs.close();

			if (stmt != null)
				stmt.close();

			if (psmt != null)
				psmt.close();

			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		conn = getConnect();
		// Statement 생성.
		try {

			// 입력. 사원번호, last_name, 입사일자, 이메일, job_id
			int emp_id = 302;
			String last_name = "홍길동";
			String hire_date = "2020-03-05";
			String email = "kdong@email.com";
			String job = "IT_PROG";

			String fn = "kildong";
			String pn = "010-xxxx-7xx4";
			int salary = 8000;

			String sql = "delete from emp_java\r\n"
					+ "where employee_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp_id);

			int r = psmt.executeUpdate(); // 입력, 수정, 삭제
			System.out.println(r + "건 삭제됨.");

			// 조회.
//			rs = stmt.executeQuery("select * from emp_java order by employee_id");
//			while (rs.next()) { //
//				System.out.println("사원번호: " + rs.getInt("employee_id"));
//				System.out.println("이름: " + rs.getString("first_name"));
//			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		disconnect();

	}
}
