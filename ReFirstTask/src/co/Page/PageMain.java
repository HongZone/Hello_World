package co.Page;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PageMain {
	Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		PageDAO page = new PageDAO();
		Scanner scn = new Scanner(System.in);
		Queue<Board2> queue = new LinkedList<>();
		
		
		for(int i=0; i<page.list().size();i++) {
			queue.add(page.list().get(i));
		}
		
		for(int j =0; j<(double) page.list().size()/3;j++) {
			for(int a=0 ; a<3; a++) {
				if(queue.peek() == null) {
					break;
				}
				System.out.println(queue.poll()); 
			}
			System.out.println("====="+(j+1)+"/"+(int)Math.ceil((double)page.list().size()/3)+"=====");
				System.out.println("1.다음");
				int paging = scn.nextInt();
				if(paging != 1) {
					break;
			}
		}
	}
}

