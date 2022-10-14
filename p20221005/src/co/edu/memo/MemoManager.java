package co.edu.memo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {
	
	List<Memo> memoStorage = new ArrayList<>(); //정보담아놓기 위한 컬렉션\
	File file = new File("C:/Temp/memobook.dat");
	Scanner scn = new Scanner(System.in);
	
		//싱글톤
		private static MemoManager instance = new MemoManager();
		private MemoManager() {
			readFromFile();
		}
		public static MemoManager getInstance() {
			return instance;
		}
		
		//추가
		public void inputData() {
			System.out.println("번호> ");
			int no = Integer.parseInt(scn.nextLine());
			System.out.println("날짜> ");
			String date = scn.nextLine();
			System.out.println("내용> ");
			String content = scn.nextLine();
			
			memoStorage.add(new Memo(no, date, content));
		}
		//조회.(날짜)
		public void searchData() {
			System.out.println("날짜> ");
			String sDate = scn.nextLine();
			boolean exists = false;
			for (int i = 0; i < memoStorage.size(); i++) {
				if(sDate.equals(memoStorage.get(i).getDate())) {
					System.out.println(memoStorage.get(i).toString());
					exists = true;
				}
			}
			if(!exists) {
				System.out.println("해당날짜의 메모가 없습니다");
			}
		}
		
		//번호를 입력하면 한건 삭제.
		public void deleteData() {
			System.out.println("삭제할 번호 입력>>");
			int del = scn.nextInt();scn.nextLine();
			for(int i = 0; i < memoStorage.size();i++) {
			if(memoStorage.get(i).getNo() == del) {
				memoStorage.remove(i);
			}
			}
		}
		
		//파일을 읽어서 데이터 memoStorage 기능
		public void readFromFile() {
			
			try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
					){
					
				
				
				memoStorage = (List<Memo>) ois.readObject();
				
			}catch(Exception e) {
//				e.printStackTrace();
				return;
			}
		}
		
		//종료하면 파일저장.
		public void storeToFile() {
			try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
					){
				oos.writeObject(memoStorage); //파일저장
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
