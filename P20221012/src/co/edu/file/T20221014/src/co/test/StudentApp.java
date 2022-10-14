package co.test;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {

		StudentManage app = StudentManage.getInstance();
		Scanner scn = new Scanner(System.in);

		while (true) {
			int menu = scn.nextInt();

			if (menu == 1) { // 등록.

			} else if (menu == 2) { // 삭제.

			} else if (menu == 3) { // 목록.

			} else if (menu == 4) { // 순위.

			} else if (menu == 9) { // 종료.

				break;
			}

		}

		scn.close();
		System.out.println("프로그램 종료.");
	}
}
