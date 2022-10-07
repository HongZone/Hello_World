package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

public class MorningenCode {
	public static void main(String[] args) {
		String tok = "Hello World Good friend";
		Scanner scn = new Scanner("Hello world Good friend");
		Scanner scanner = new Scanner(System.in);
		
		
//		while(scn.hasNext()) //들고올게 몇개인지 체크를 하고
//		System.out.println(scn.next());  //들고오겠다
		
		String[] toks = tok.split(" "); //구분자 공백을 기준으로 나눠서 새로운 배열에 넣어주겠다 split
		for(String str : toks)
			System.out.println(str);
		
//		사용자값을 입력
		boolean run = true;
		ArrayList<Employee1> list = new ArrayList<Employee1>();
	    while(run) {
	    System.out.println("입력>> ex)사번 이름 급여");
		String inputVal = scanner.nextLine();
		String[] emp = inputVal.split(" ");
	    String empId = "";
	    String empName = "";
	    String salary = "";
	    for(int i =0 ; i<emp.length; i++) {
	    	if(i % 3 == 0) {
	    		empId =emp[i];
	    	}else if(i % 3 == 1) {
	    		empName = emp[i];
	    	}else if(i % 3 == 2) {
	    		salary = emp[i];
	    	}
	    }
	  
	    
	     Employee1 empgg = new Employee1(empId,empName,salary);
	     list.add(empgg);
	     for(Employee1 empsda : list) {
		    	System.out.println(empsda);
		    }
	     
	    }
	    System.out.println("end of program");
//	    for(int i =0; i< empList.size(); i++) {
//	    	System.out.println(empList.get(i));
//	    }
	    
//	    
		
		
		//첫번째 값 -> empId에 담고 두번째 값 => empName, 세번째 값 => salary에 담기
		//Employee 클래스의 인스턴트를 생성하고
		//ArrayList에 저장
		//종료 quit를 치면
		
		//for(반복문)으로 담은 내용을 출력
		
	}
}
