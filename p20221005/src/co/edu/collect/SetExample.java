package co.edu.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/////////////////////////////Set컬렉션///////////////////////////

class Employee{
	int empId;
	String name;
	int salary;
	public Employee(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	
	@Override//해쉬코드랑 이퀄코드 값이 같으면 논리적으로 동일한 개체다
	public int hashCode() {
		return empId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee1) {
			Employee1 target = (Employee1) obj; //casting
			
			return (this.empId == target.empId && this.name.equals(target.name)&& this.salary == target.salary);
		}else {
			return false;
		}
	}
}

public class SetExample {
	public static void main(String[] args) {
		Set<Employee1> employees = new HashSet<Employee1>();
		employees.add(new Employee1(100, "홍길동", 1000));
		employees.add(new Employee1(200, "박유식", 2000));
		employees.add(new Employee1(300, "최윤기", 3000));
		employees.add(new Employee1(100, "박길동", 1000));
		
		employees.remove(new Employee1(100, "박길동", 1000));
		
		System.out.println(employees.size());
		
		Iterator<Employee1> iter = employees.iterator();
		while(iter.hasNext()) {
			Employee1 emp = iter.next();
			System.out.printf("사번은 %d, 이름은 %s, 급여는 %d\n", emp.empId, emp.name, emp.salary);
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size() < 7) {
			set.add((int)(Math.random()*45)+1);
		}
		for(int n : set) {
			System.out.println(n);
		}
		
		//중복저장 불가
		int[] lotto = new int[7];
		for(int i =0; i <lotto.length; i++) {
			int temp = (int) (Math.random() *7) + 1 ;
			//현재 인덱스 값보다 작은 위치에 temp와 같은 값이 있는지 체크
			boolean exists = false;
			for(int j = 0; j < i; j++) {
				if(lotto[i-1] == temp) {
					
				}
				exists = true;
			}
			if(exists)
				continue;
			lotto[i] = temp; 
			
		}
		for(int n : lotto) {
			System.out.printf("%d ", n);
		}
	}
}
