package co.edu;

import java.util.Arrays;

public class Student {
	
	//필드
	private String number; //공유하고 싶지 않은 내용은 private를 달아준다
	private String name;
	private String major;
	private int age; //정수값 23, 0, -12 등이 들어갈 수 있다
	 //메소드로 학번을 넣고 가져오는
	private String[] hobbies = new String[5];
	
	//정적 메소드
	public static void staticMethod() {
		System.out.println("staticMethod call");
	}
	
	//생성자(필드의 값을 초기화 해주는 역할) 생성자 오버로딩 (동일한 이름의 생성자를 여러번 정의)
	public Student() {
		//매개값이 없는 생성자 => 기본생성자
		this.name = "기본값";
		this.number = "000-000";
	}
	
	public Student(String number, String name) {
		this.name = name;
		this.number = number;
	}
	public Student(String number, String name, String major) {
		this(number, name); // 기본생성자 호출
		this.major = major;
	}
	
	//메소드
	void setHobbies(String[] hobbies) {
//		this.hobbies = hobbies;
		for(String hobby : hobbies) {
			for(int i=0; i<this.hobbies.length; i++) {
				if(this.hobbies[i]==null) {
					this.hobbies[i] = hobby;
					break;
				}
			}
		}
	}
	String[] getHobbies() {
		return this.hobbies;
	}
	String getHobb() {
		String str = "취미는 ";
		for(String hobby :  hobbies) {
			if(hobby != null) {
			str += hobby + " ";
			}
		}
		str += "입니다";
		return str;
	}
	
	// 취미추가.
	void addHobby(String hobby) {
		for(int i=0; i<hobbies.length; i++) {
			if(hobbies[i] == null) {
				hobbies[i] = hobby;
				break;
			}
		}
	}
	
	void setStudNo(String number) {
		this.number = number;
	}
	
	String getStudNo(){
		return this.number;
	}
	
		//학생이름 set.get
	void setStudName(String name) {
		this.name = name;
	}
	String getStudName() {
		return this.name;
	}
	   //전공 set.get
		void setmajor(String major) {
			this.major = major;
		}
		String getmajor() {
			return this.major;
	}
		 //나이 set.get
		void setage(int age) {
			this.age = age;
		}
		int getage() {
			return this.age;
	}
	
		void setAge(int age) { // 값을 담을 수 있도록 메소드를 만듬
		if(age < 0) {
			this.age = 0;   //this를 붙이면 필드에꺼를 불러온다 / 매개변수랑 필드 이름을 맞춰주는게 관례
		}else {
			this.age =age;
		}
	}
	int gerAge() {
		return this.age;
	}
	//show Info()
	public String showInfo() {
		return "이름은" + this.name + "이고 학번은"+ this.number +"나이는" + this.age;
	}
	
	void study() {
		System.out.println("공부를 한다");
	}
	void game() {
		System.out.println("게임을 한다");
	}
	void sleep() {
		System.out.println("잠을 잔다");
	}

	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", major=" + major + ", age=" + age + ", hobbies="
				+ Arrays.toString(hobbies) + "]";
	}
	
	

}
