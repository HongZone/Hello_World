package co.edu.file;

import java.io.FileReader;

public class FileApp2 {
	public static void main(String[] args)throws Exception {
		
		FileReader reader = new FileReader("c:/Temp/memberList.txt");
		
		int ch;
		while((ch = reader.read()) != -1) {
			
		}
		
		
		
	}
	
	
}
