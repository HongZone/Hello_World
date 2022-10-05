package co.edu.emp.list;

import java.util.ArrayList;

import co.edu.emp.Employee;

public class ListApp {
		public static void main(String[] args) {
			//컬렉션(ArrayList, HashSet(중복된 값은 처리하지 않고 처리),HashMap(키와 값위주로 저장)
			
			ArrayList<String> list = new ArrayList<String>(); //타입을 정할 수 있는 명령어(제너릭타입) <String> or <int>.
			list.add("Hello");
			list.add("Employee");
			
			for(int i = 0; i<list.size(); i++) {
				System.out.println(list.get(i)); //list에 담겨 있는 i번째 배열을 가져오겠습니다
			}
			
			
			
			ArrayList<Integer> intList = new ArrayList<Integer>();
			intList.add(1);
			intList.add(123);
			
			ArrayList<Employee> empList = new ArrayList<Employee>();
			empList.add(new Employee(100, "홍길동", 1000));
			empList.add(new Employee(200, "김민수", 2000));
			empList.add(new Employee(300, "박인기", 3000));
			empList.add(new Employee(400, "황석용", 4000));
			
			String result = null;
			int salary = 0;
			for(int i = 0; i<empList.size() ; i++) {
				if(empList.get(i).getEmployeeId() == 200) {
					result = empList.get(i).getName();
					salary = empList.get(i).getSalary();
				}
			}
			System.out.println("이름은 "+result+"이고 급여는 "+ salary+"원 입니다.");
			
		}

}
