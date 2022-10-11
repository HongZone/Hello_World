package co.edu.collect;

import java.util.LinkedList;
import java.util.Queue;

public class QueExample {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		//추가
		que.offer("Hong");
		que.offer("Park");
		que.offer("Choi");
		
		while(!que.isEmpty()) {
			System.out.println(que.poll());
		}
	}
}
