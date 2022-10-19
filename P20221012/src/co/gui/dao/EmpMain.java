package co.gui.dao;

import java.util.List;

public class EmpMain {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		EmployeeVO vo = new EmployeeVO(0, null,null, null,null, "IT_PROG");
		
		List<EmployeeVO> list = dao.empList(vo);
		for(EmployeeVO emp : list) {
			System.out.println(emp);
		}
	}
}
