package co.edu.emp.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateExe {
	//Date = 날짜, 시간
	public static void main(String[] args) {
		Date today = new Date();//1970.1.1.~2022.10.5 (50년을 계산)=> 50*12*30*24*60*1000
//		today.setYear(2022);
//		today.setMonth(11);
		String ymd = "2022-10-05 13:14:15";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// 2022-10-05 우리가 원하는 형식의 날짜 포멧을 지정하는 클래스를 써야함 = SimpleDateFormat
		
		System.out.println(sdf.format(today));
		try {    //밑에껄 실행하다가 에러가 나면 그 다음껄 실행하고 종료해라
			today = sdf.parse(ymd);
			System.out.println(today);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		//날짜 (LocalDate), 시간(LocalTime) => LocalDateTime //이제 이걸로 대체 해서 써야함
		LocalDateTime day = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh시mm분ss초");//원하는 형식으로 볼때DateTimeFormatter.ofPattern()
//		day.format(dtf);
		day = LocalDateTime.of(2022, 10, 5, 10, 20); //원하는 날짜를 설정하고 싶을때 of
		System.out.println(day.format(dtf));
	}
}
