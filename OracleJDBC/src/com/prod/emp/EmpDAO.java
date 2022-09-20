package com.prod.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {

	// 전체조회
	public List<Employee> empList() {
		List<Employee> employees = new ArrayList<Employee>();

		conn = getConnect();
		try {
			psmt = conn.prepareStatement("select * from empl");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id")); // employees.employee_id
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));

				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return employees;
	}
	// 한건조회

	// 입력처리 executeUpdate()
	public boolean insertEmp(Employee emp) {
		conn = getConnect();
		String sql = "insert into empl (employee_id, last_name, email, hire_date, job_id)"
				+ "values (?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql); // ? <= 매개변수값중에서 employeeId 필드값.
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());
			int r = psmt.executeUpdate(); // 실행된 건수 반환.
			System.out.println(r + "건 입력됨.");
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
//			e.printStackTrace();

		} finally {
			// 정상실행, 예외발생 => 반드시 실행코드.
			disconnect();
		}
		return false;
	}

	// 수정처리
	public boolean updateEmp(Employee emp) {
		conn = getConnect();
		String sql = "update empl " //
				+ "set first_name = ?, " //
				+ "    phone_number = ?, " //
				+ "    salary = ? " //
				+ "where employee_id = ?"; // 쿼리 작성 => ? 작성.
		try {
			psmt = conn.prepareStatement(sql);
			// 파라메터(?) 값을 지정.
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getPhoneNumber());
			psmt.setInt(3, emp.getSalary());
			psmt.setInt(4, emp.getEmployeeId());

			int r = psmt.executeUpdate(); // 실행.
			System.out.println(r + "건 수정됨.");
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 삭제처리
	public void deleteEmpl(int empId) {
		conn = getConnect();
		String sql = "delete from empl where employee_id = ?"; // 쿼리 작성 => ? 작성.
		try {
			psmt = conn.prepareStatement(sql);
			// 파라메터(?) 값을 지정.
			psmt.setInt(1, empId);

			int r = psmt.executeUpdate(); // 실행.
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// Employee
	public Employee searchEmp(int eid) {
		conn = getConnect();
		Employee emp = null;
		String sql = "select * from empl where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eid);
			rs = psmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id")); // employees.employee_id
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setPhoneNumber(rs.getString("phone_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
//		Employee emp = new Employee();
//		emp.setLastName("Hello\r\nNiceWorld");
		return emp;
	}

}
