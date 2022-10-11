package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Emp implements Serializable{ //이게 선언되어야지 ObjectOutputStream또는 인풋을 쓸 수 있음(오브젝트타입관련 해당)
	int id;
	String name;
	String dept;
	
	public Emp(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "사원id: " + id + ", 이름: " + name + ", 부서: " + dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}

public class ObjectExample {
	public static void main(String[] args) {
		
		try (FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
				ObjectInputStream oss = new ObjectInputStream(fis);
				){
			ArrayList<Emp> list = (ArrayList<Emp>) oss.readObject();
			
			for(Emp emp : list) {
				System.out.println(emp.toString());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void writeObj() {
		//입출력 스트림 => Class 인스턴스 생성 => 파일입출력.
				//objectInputStream ,objectOutputStream : Object 기반
				ArrayList<Emp> empList = new ArrayList<>();
				empList.add(new Emp(100, "홍길동", "인사"));
				empList.add(new Emp(200, "김민식", "개발"));
				empList.add(new Emp(300, "이유진", "총무"));
				
				
				try(FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos);) {
					
					
					oos.writeObject(empList);
					
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
//				new ObjectOutputStream(fos);//보조스트림이라고 함
				
				System.out.println("completed");
	}
}
