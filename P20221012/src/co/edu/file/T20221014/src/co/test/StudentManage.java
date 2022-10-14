package co.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class StudentManage {

	File file = new File("c:/Temp/studentList.txt");
	ArrayList<Student> studentList;

	// 싱글톤 인스턴스 생성.
	private static StudentManage instance = new StudentManage();

	private StudentManage() {

	}

	public static StudentManage getInstance() {
		return instance;
	}

	// 등록.
	public void add(Student student) {

	}

	// 삭제.
	public void del(int studNo) {

	}

	// 목록(입력순서).
	public void list() {

	}

	// 순위(총점순서).
	public void ord() {

	}

	// 저장된 파일을 읽어오기.
	public void readFromFile() {

		try {
			FileReader fr = new FileReader(file); //
			BufferedReader br = new BufferedReader(fr);//

			String studentInfo = null;
			String[] itemAry = null;

			while (true) {
				studentInfo = br.readLine();
				if (studentInfo == null) { // 파일의 끝부분이면 종료.
					break;
				}
				itemAry = studentInfo.split(" ");
				int no = 0;
				String name = null;
				int age = 0;
				int eng = 0;
				int math = 0;
				Student student = new Student(no, name, age, eng, math);
				studentList.add(student);

			}
			br.close();
			fr.close();

		} catch (Exception e) {
			System.out.println("읽을 파일이 없습니다.");
		}
	} // 입력스트림

	// 입력된 내용을 파일에 저장하기.
	public void storeToFile() {
		try {
			FileWriter fw = new FileWriter(file);

			for (Student student : studentList) {
				fw.write("");
			}

			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 출력스트림

}
