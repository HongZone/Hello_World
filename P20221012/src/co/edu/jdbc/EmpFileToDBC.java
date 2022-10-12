package co.edu.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;

public class EmpFileToDBC {
	public static void main(String[] args) {

		String[] emps = null;
		Employee employee = null;
		EmployeeDAO dao = new EmployeeDAO();

		try (FileReader fr = new FileReader("c:/Temp/emplist.txt"); BufferedReader br = new BufferedReader(fr);) {
			while (true) {
				String emp = br.readLine();
				if (emp == null)
					break;

				emps = emp.split(" ");
				employee = new Employee(Integer.parseInt(emps[0]), emps[1], emps[2], emps[3], emps[4]);
				dao.insert(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("완료");
	}
}
