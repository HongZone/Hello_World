package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

//컬렉션을 활용해서 데이터 저장
public class EmployeeArrayList implements EmployeeService {

	int idx = 0;
	ArrayList<Employee> list;
	Scanner scn = new Scanner(System.in);
			
	@Override //사원초기화
	public void init() {
		list = new ArrayList<Employee>(); 
		System.out.println("초기화가 되었습니다");
	}

	@Override //사원정보입력
	
	public void input() {
		try {
		System.out.println("사번>>");
		int eId = Integer.parseInt(scn.nextLine());
		System.out.println("이름>>");
		String name = scn.nextLine();
		
		boolean all = true;
		int detpId =0;	
		while(all) {
		System.out.println("부서>>");
		detpId = Integer.parseInt(scn.nextLine());
		if(detpId == 10||detpId == 20||detpId == 30) {
			break;
		}else {
			System.out.println("부적절한 부서입니다");
			}
		}
		System.out.println("급여>>");
		int sal = Integer.parseInt(scn.nextLine());
		System.out.println("이메일>>");
		String email = scn.nextLine();
		Employee emp = new Employee(eId, name, sal, detpId, email);
		list.add(emp);
		}catch(NumberFormatException e) {
			System.out.println("맞지않는 형식입니다");
		}
	}
	

	@Override //사원검색 (사원번호를 넣으면 사원 이름이 나오는)
	public String search(int employeeId) {
		String result = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getEmployeeId() == employeeId) {
				result = list.get(i).getName();
				
				break;
				
			}
//			for(Employee emp : list) {
//				if(emp.getEmployeeId() == employeeId) {
//					result = emp.getName();
//					break;
//				}
//			}
			
		}
		return result;
		
	}

	@Override //사원리스트
	public void print() {
		for(int i =0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	@Override //사원급여
	public int searchSal(int employeeId) {
		int salresult = -1;
		for(int i = 0; 0 < list.size(); i++) {
			if(list.get(i).getEmployeeId() == employeeId) {
				salresult = list.get(i).getSalary();
				break;
			}
		}
		return salresult;
	}

}
