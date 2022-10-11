package co.edu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

//class Emp implements Serializable {
//	int id;
//	String name;
//	String dept;
//	
//	public Emp(int id, String name, String dept) {
//		this.id = id;
//		this.name = name;
//		this.dept = dept;
//	}
//
//	@Override
//	public String toString() {
//		return "사원id: " + id + ", 사원이름: " + name + ", 부서: " + dept + "]";
//	}
//	
//	
//}

public class EmpObjectExam {
	public static void main(String[] args) throws Exception {
		
		//C:/Temp/emp.dat 를 읽어들이는 기능
		FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject();
		
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.사원등록 2.목록출력 3.삭제 4.종료");
			System.out.println("선택>>");
			
			
			int menu = scn.nextInt();
			if(menu == 1) {
				System.out.println("사원번호>>");
				int id = scn.nextInt();scn.nextLine();
				System.out.println("이름>>");
				String name = scn.nextLine();
				System.out.println("부서>>");
				String dept = scn.nextLine();
				
				Emp emp = new Emp(id, name, dept);
				empList.add(emp);
				System.out.println("등록되었습니다");
				
				fis.close();
				ois.close();
				
			}else if(menu == 2) {
			
				for(Emp eemp : empList) {
					System.out.println(eemp.toString());
				}
				
			}else if(menu == 3) {
				System.out.println("삭제할 사원번호 입력>>");
				int delId=scn.nextInt();scn.nextLine();
				
				for(int i=0; i < empList.size(); i++) {
				if(empList.get(i).getId() == delId) {
					empList.remove(i);
				}
					}
//			 사원번호를 기준으로 삭제
			}else if(menu == 4) {
				//컬렉션에 있던 ObjectOutputStream을 활용해 C:/Temp/emp.dat 저장
				
				FileOutputStream Fout = new FileOutputStream("C:/Temp/emp.dat");
				ObjectOutputStream Oout = new ObjectOutputStream(Fout);
				
				Oout.writeObject(empList);
				
				Fout.close();
				Oout.close();
				System.out.println("End of program");
				
				break;
			}else {
				System.out.println("잘못된 메뉴를 선택했습니다");
			}
			
		}
	}
}
