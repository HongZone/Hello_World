package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {
		 String fileName = "src/co/edu/api/Birth.txt";
		 File file = new File(fileName);
		 Scanner scn = null;
		 			try {
				 scn = new Scanner(file);
				 while (true) {
					 String str = scn.nextLine();
					 
				 if(str.replace("-","").charAt(6) % 2 == 1) {
					 System.out.println("남자입니다");
				 }else if(str.replace("-","").charAt(6) % 2 == 0) {
					 System.out.println("여자입니다");
				 }else { //년, 월, 일이 잘못되었을 때 
					 System.out.println("잘못된 번호입니다");
				 }
			 }
		 }catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }catch(NoSuchElementException e1) {
			 
		 }
		 System.out.println("end of prog.");
	}
}
