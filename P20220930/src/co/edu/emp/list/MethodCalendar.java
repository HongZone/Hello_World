package co.edu.emp.list;

import java.util.Calendar;

public class MethodCalendar { 
	
	private static MethodCalendar instance = new MethodCalendar(); //메소드캘린더라는 클래스가 사용되어지면
	private MethodCalendar() {}
	public static MethodCalendar getInstance() {
		return instance;
	}
	
	public void makeCal(int year, int month) {
		System.out.println("          >>>" +year+"년"+month +"월<<<");
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fir","Wen"};
		for(String day : days) {
			System.out.printf("%4s", day); //4개의 문자공간씩 day각각 배열에 넣어주겠습니다
		}
		System.out.println();
		
		//1의 위치지정.
		for (int i=0; i < getFirstDay(year, month) ; i++) {
			System.out.printf("%4s", " ");
		}
		//날짜출력
		for (int i=1; i <= getLastDate(year,month) ; i++) {
			System.out.printf("%4d", i); //d로 바꿔주면 숫자형
				if((i+getFirstDay(year, month))%7 == 0) {
				System.out.println();
			}
		}
	}//end of makeCal()
	public int getFirstDay(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year , month - 1,1 );
		return cal.get(Calendar.DAY_OF_WEEK)-1;
	}
	
	
//	public int getFirstDay(int month) {
//		if(month == 9) {
//			return 4;
//		}else if(month ==8) {
//			return 1;
//		}else if(month ==7) {
//			return 5;
//		}else if (month ==6) {
//			return 3;
//		}else {
//			return 6;
//		}
//	}//end of getFirstDay()
	public int getLastDate(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1,1 );
		return cal.getActualMaximum(Calendar.DATE);
	}
}//end of class
