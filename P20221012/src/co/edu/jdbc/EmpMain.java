package co.edu.jdbc;

import java.util.List;
import java.util.Scanner;

public class EmpMain {

		public static void main(String[] args) {
			EmployeeDAO dao = new EmployeeDAO();
			Scanner scn = new Scanner(System.in);
			//메뉴 =. 1.사원등록 2. 한건조회 3.수정(ID기준) 4.삭제(ID기준) 5.목록조회 9.종료
			
			
			
			
			while(true) {
				
				System.out.println("1.사원등록 2. 한건조회 3.수정 4.삭제 5.목록조회 6.일괄등록 9.종료");
				int menu = scn.nextInt();
				
				if(menu == 1) {
					//사원등록
					System.out.println("사원번호>> ");
					int id = scn.nextInt();scn.nextLine();
					System.out.println("이름>> ");
					String name = scn.nextLine();
					System.out.println("이메일>> ");
					String mail = scn.nextLine();
					System.out.println("입사일>> ");
					String hiredate = scn.nextLine();
					System.out.println("직무>> ");
					String jobid = scn.nextLine();
					Employee emp2 = new Employee(id, name, mail, hiredate, jobid);
//					if(emp2.getEmployeeId() ==  )
					dao.insert(emp2);
					
				}else if(menu == 2) {
					//한건조회
					System.out.println("조회할 사원번호>> ");
					int id2 = scn.nextInt();scn.nextLine();
					System.out.println(dao.getEmp(id2)); 
					
				}else if(menu == 3) {
					//수정
					System.out.println("(수정)사원번호>> ");
					int id = scn.nextInt();scn.nextLine();
					System.out.println("(수정)이름>> ");
					String name = scn.nextLine();
					System.out.println("(수정)이메일>> ");
					String mail = scn.nextLine();
					System.out.println("(수정)입사일>> ");
					String hiredate = scn.nextLine();
					System.out.println("(수정)직무>> ");
					String jobid = scn.nextLine();
					Employee emp3 = new Employee(id, name, mail, hiredate, jobid );
					dao.update(emp3);
					
					System.out.println("수정되었습니다");
					
				}else if(menu == 4) {
					//삭제
					System.out.println("삭제할 사원번호>> ");
					int id4 = scn.nextInt();scn.nextLine();
					dao.delete(id4);
					System.out.println(id4+" 사원이 삭제되었습니다");
					
				}else if(menu == 5) {
					//목록조회
					List<Employee> emp = dao.search();
					for(Employee emp2 : emp) {
						System.out.println(emp2);
					}
					
				}else if(menu ==6 ) {	
					//일괄등록
				}else if(menu == 9) {
					//종료\
					dao.disconnect();
					break;
				}
			}//end of while
			System.out.println("프로그램이 종료되었습니다");
		}
}
