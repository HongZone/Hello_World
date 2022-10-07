package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		//key:Integer, val:String
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "김기영");
		map.put(300, "박문식");
		map.put(300, "윤문식");
		
		map.remove(300); //삭제
		
		System.out.println("컬렉션 : " + map.size());
		System.out.println(map.get(300)); //get이 키값을 입력하면 가지고 오는 메소드
		
		// 반복자 생성.
		
		Set<Integer> keySet = map.keySet(); // 키만 새로운 set컬렉션에 저장.
		for(Integer key : keySet) {
			System.out.println("키 : " + key + ", 값 : "+ map.get(key));
			
		}
		
		Set<Entry<Integer, String>> entSet = map.entrySet(); //키 값고 벨류 값을 둘다 가지고 있는 클래스가 entrySet
		for(Entry<Integer, String> ent : entSet) {
			System.out.println("키: " + ent.getKey() + ", 값: " + ent.getValue());
		}
	}
}
