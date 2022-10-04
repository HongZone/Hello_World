package co.edu.ingerit.friend;

import java.util.ArrayList;

public class ArrayExam {
	public static void main(String[] args) {
		String[] flowers = new String[3];
		flowers[0] = "장미";
		flowers[1] = "해바라기";
		flowers[2] = "무궁화꽃";
//		flowers[3] = "목련";
		
		
		String[] flowers2 = new String[6];
		flowers2[0] = "장미";
		flowers2[1] = "해바라기";
		flowers2[2] = "무궁화꽃";
		flowers2[3] = "목련";
		
		
		for(String str : flowers2) {
			if(str != null) {
				System.out.println(str);
			}
		}
		
		//배열의 크기를 자동적으로 늘려주는 =>컬렉션(ArrayList);
		ArrayList flowers3 = new ArrayList(); // 크기를 지정하지 않으면 일단 10개 공간 생성 
		flowers3.add("장미");//첫번째 위치 장미 저장 //자동으로 빈곳에 저장이 되어서 !=null을 필요 없다
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
//		flowers3.add(123);
		
		for(Object str : flowers3) {  //ArratList는 모든 타입을 담을 수 있도록 object로 되어있음
			String result = (String) str; // (String) 형식으로 str을 불러오고 싶을때 (String)을 붙인다.<=String으로 형변환
			System.out.println(result);
	 	}
		
		//컬렉션의 크기를 보고 싶으면 size(); (들어있는 만큼만 출력)
		for(int i=0; i<flowers3.size(); i++) {
			String result = (String)flowers3.get(i);// get(i) 몇번째 위치로 가져오겠습니다
		}
		
	}
}
