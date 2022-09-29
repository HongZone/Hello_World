package co.edu.variable;

public class MethodCalendar {
	
	public static void main(String[] args) {
		makeCal(7);
	}
	
	public static void makeCal(int year) {
		System.out.println("          >>>" +year +"월<<<");
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fir","Wen"};
		for(String day : days) {
			System.out.printf("%4s", day); //4개의 문자공간씩 day각각 배열에 넣어주겠습니다
		}
		System.out.println();
		
		//1의 위치지정.
		for (int i=0; i < getFirstDay(year) ; i++) {
			System.out.printf("%4s", " ");
		}
		//날짜출력
		for (int i=1; i <= getLastDate(year) ; i++) {
			System.out.printf("%4d", i); //d로 바꿔주면 숫자형
				if((i+getFirstDay(year))%7 == 0) {
				System.out.println();
			}
		}
	}//end of makeCal()
	
	public static int getFirstDay(int month) {
		if(month == 9) {
			return 4;
		}else if(month ==8) {
			return 1;
		}else if(month ==7) {
			return 5;
		}else if (month ==6) {
			return 3;
		}else {
			return 6;
		}
	}//end of hetFirstDay()
	public static int getLastDate(int month) {
		switch(month) {
			case 9:
				return 30;
			case 8:
				return 31;
			case 7:
				return 31;
			case 6:
				return 30;
			default:
				return 30;
		}
	}
}//end of class
