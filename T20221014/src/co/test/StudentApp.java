package co.test;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		boolean run = true;
		StudentManage app = StudentManage.getInstance();
		Scanner scn = new Scanner(System.in);

		
		while (run) {
			System.out.println("1.등록, 2.삭제 3.목록(총점) 4.순위 5.종료");
			int menu = scn.nextInt();scn.nextLine();

			if (menu == 1) { // 등록.
				System.out.println("학생번호>>");
				int num = scn.nextInt();scn.nextLine();
				System.out.println("학생이름>>");
				String name = scn.nextLine();
				System.out.println("학생나이>>");
				int age = scn.nextInt();scn.nextLine();
				System.out.println("영어점수>>");
				int eng = scn.nextInt();scn.nextLine();
				System.out.println("수학점수>>");
				int math = scn.nextInt();scn.nextLine();
				Student student = new Student(num, name, age, eng, math);
				
				app.add(student);
				
			} else if (menu == 2) { // 삭제.
				System.out.println("삭제할 학생번호>>");
				int num = scn.nextInt();scn.nextLine();
				app.del(num);
			} else if (menu == 3) { // 목록.
				app.list();
			} else if (menu == 4) { // 순위.

			} else if (menu == 5) { // 종료.
				run = false;
			}

		}
		scn.close();
		System.out.println("프로그램 종료.");
	}
}
