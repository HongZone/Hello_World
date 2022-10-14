package co.edu.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileApp {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		List<Member> memlist = new ArrayList<>();

		Writer writer = new FileWriter("C:/Temp/memberList.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Temp/memberList.txt"));

		while (true) {
			System.out.println("아이디입력>>");
			String id = scn.nextLine();
			System.out.println("회원이름입력>>");
			String name = scn.nextLine();
			System.out.println("회원포인트입력>>");
			String point = scn.nextLine();
			Member list = new Member(id, name, point);
			memlist.add(list);
			if (memlist.size() == 3) {
				break;
			}

		}

		for (Member member : memlist) {

			bw.write(member.getId()+"\t"+member.getName()+"\t"+member.getPoint());
			bw.write("\n");
		}
		bw.close();
		writer.close();
//		

	}
}
