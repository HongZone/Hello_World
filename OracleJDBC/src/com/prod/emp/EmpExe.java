package com.prod.emp;

import java.util.List;
import java.util.Scanner;

public class EmpExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		EmpDAO dao = new EmpDAO();

		// 메뉴: 1.사원리스트 2.입력 3.수정 4.삭제 5.한건조회 9.종료
		while (true) {
			System.out.println("1.사원리스트 2.입력 3.수정 4.삭제 5.한건조회 9.종료");
			System.out.println("메뉴선택>> ");

			int menu = scn.nextInt();
			if (menu == 1) { // 리스트.
				List<Employee> list = dao.empList(); // 전체조회기능.

				System.out.println("사원리스트.");
				for (Employee emp : list) {
					System.out.println(emp.toString());
				}
			} else if (menu == 2) { // 입력.
				// 사원번호, lastName, email, hireDate, jobId
				System.out.println("사원번호입력>>> ");
				int eId = scn.nextInt();
				System.out.println("lastNam입력>>> ");
				String lastN = scn.next();
				System.out.println("email입력>>> ");
				String email = scn.next();
				System.out.println("입사일자입력(ex: 2021-03-04)>>> ");
				String hd = scn.next();
				String job = "IT_PROG";
				Employee emp = new Employee();
				// 생성자, set메소드.
				emp.setEmail(email);
				emp.setEmployeeId(eId);
				emp.setLastName(lastN);
				emp.setHireDate(hd);
				emp.setJobId(job);

				boolean okOrNot = dao.insertEmp(emp); // boolean 타입으로 결과값을 받아와서..
				if (okOrNot) {
					System.out.println("정상처리되었습니다.");
				} else {
					System.out.println("오류가 발생했습니다.");
				}

			} else if (menu == 3) { // 수정.
				// 사원번호, 전화번호, firstName, salary

				Employee emp = new Employee();
				// 생성자, set메소드.
				System.out.println("변경할 아이디를 입력>> ");
				int changeId = scn.nextInt();scn.nextLine();
				System.out.println("이름을(firstName)입력>> ");
				String fName =scn.nextLine();
				System.out.println("연락처 입력>> ");
				String phone = scn.nextLine();
				System.out.println("급여를 입력>> ");
				int salary = scn.nextInt();
				
				emp.setEmployeeId(changeId);
				emp.setFirstName(fName);
				emp.setPhoneNumber(phone);
				emp.setSalary(salary);

				boolean result = dao.updateEmp(emp);
				// 300 6000
				if (result)
					System.out.println("정상적으로 처리.");
				else
					System.out.println("정상처리 안됐습니다.");

			} else if (menu == 4) { // 삭제.
				// 삭제할 사원번호
				System.out.println("삭제할 사원번호 입력>> ");
				int delID = scn.nextInt();
				dao.deleteEmpl(delID);

			} else if (menu == 5) { // 한건조회.
				System.out.println("조회할 사원번호 입력>>>> ");
				int eid = scn.nextInt();

				Employee emp = dao.searchEmp(eid);
//				Employee emp = new Employee();
				
				if (emp == null)
					System.out.println("조회결과 없습니다");
				else
					System.out.println(emp.getLastName());

			} else if (menu == 9) { // 종료.
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		} // end of while
		System.out.println("end of program");
		scn.close();

	} // end of main
}
