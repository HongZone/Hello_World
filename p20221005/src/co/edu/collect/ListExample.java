package co.edu.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListExample {
	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList<String>();
		//추가
		strs.add("홍길동");
		strs.add("김민식");
		strs.add("박유식");
		
		strs.remove(0);
		strs.remove("박유식");
		
		strs.add(0, "최기분"); // 특정한 위치에 값을 넣을 때
		
		System.out.println("collect크기" + strs.size());
		
		for(String str : strs) {
			System.out.println(str);
		}
		for(int i = 0; i<strs.size(); i++) {
			System.out.printf("%d번째의 값은 %s\n", i, strs.get(i));
		}
		//반복자를 생성 // iterator() 반복자 만드는 메소드 hasNext()값이 있는지 확인하는 메소드  next()있다면 값을 꺼내오는 메소드
		Iterator<String> itr = strs.iterator();
		while(itr.hasNext()) {
			String result = itr.next();
			System.out.println(result);
		}
		
		ArrayList<Integer> inAry = new ArrayList<Integer>();
		long start = System.nanoTime();
		for(int i =0; i<10000; i++) {
			inAry.add(i);
		}
		long end = System.nanoTime();
		System.out.println("ary" + (end - start));
		
		LinkedList<Integer> lnAry = new LinkedList<Integer>();
		start = System.nanoTime();
		for(int i =0; i<10000; i++) {
			lnAry.add(i);
		}
		end = System.nanoTime();
		System.out.println("lna" + (end - start));
//		LinkedList<Integer> InAry = new LinkedList<Integer>();
	}
}
