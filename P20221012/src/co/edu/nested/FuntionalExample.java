package co.edu.nested;

import java.util.List;
import java.util.function.Consumer;

import co.edu.jdbc.Employee;
import co.edu.jdbc.EmployeeDAO;

public class FuntionalExample {
	public static void main(String[] args) {
		
		Consumer<String> consumer = (String t) -> {
				System.out.println(t +" 는 흥미롭습니다.");
			};
		consumer.accept("자바");
		
		// 함수적 프로그래밍 -> 데이터 처리
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = dao.search();
		
		
		list.stream().forEach((t) -> System.out.println(t.toString()));
	}
}
