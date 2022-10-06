package co.edu.api;

import java.io.IOException;

public class StringExe2 {
	public static void main(String[] args) {
//		System.out.println("abcDEF".toUpperCase()); //대문자로 바꿔주는 
		while(true) {
			try {
				int bytes = System.in.read(); //system.in 은 키보드 를 통해서 읽어오겠다read()
				if (bytes == 122)
					break;
				
				System.out.println("입력값:" + bytes);
			}catch (IOException e) {
				e.printStackTrace();	
			}
		}
		System.out.println("end of prog");
	}
	
//	public static void changeCapital(String msg) {
	//대문자 => 소문자 , 소문자-대문자(소문자와 대문자의 차가 32)
	//aBcD => AbCd 97:65, 98:66
	//소문자 97~122, 대문자 65~90
	//소문자가 들어오면 대문자로 바꿔주고 대문자는 소문자로 바꿔주는 프로그램 aBcD => AbCd 이렇게
}
