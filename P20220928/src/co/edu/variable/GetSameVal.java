package co.edu.variable;

import java.util.Scanner; //Scanner이란걸 쓰겠습니다 밑에 이걸 다 쓰면 너무 기니까 임포트에 담아놓고 밑에서는 Scanner로만 사용
import java.lang.System;

//java.lang 이 베이스 패키지.
public class GetSameVal {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in); // 사용자 입력값을 저장
		System.out.println("이름을 입력하세요>>> ");
		
		String name = scn.nextLine(); //사용자 입력값을 반환
		
		String[] names = {"김현지", "김유리", "남미주", "송지은" };	
			boolean isChecked = false;
		    for(int i = 0; i< names.length; i++) {		
			
			if(names[i].equals(name)) {
			System.out.println((i+1)+ "번째 위치에 있습니다.");
			isChecked = true;
			break;
			} //문자열 비교는 문자열.equals(비교문자열)
			  //"몇번째 위치에 있습니다" 출력
		}
		   if(!isChecked) {
			   System.out.println("찾는 이름이 없습니다.");
		   }
		
		System.out.println("입력값: " + name);
	}

}
