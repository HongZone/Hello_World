package co.edu;

//프로그램이 실행되려면 하나의 실행클래스(main 클래스를 담고 있는)와 여러개의 라이브러리용 클래스가 필요
public class AppMain {
	public static void main(String[] args) {
//		Object => Class => Instance
//		Person kim = new Person(); //인스턴스 생성 후 클래스에 값을 넣어줘야 한다
//		kim.name = "김민기";
//		kim.age = 20;
//		kim.sleep("렘수면");
//		kim.eat("라면");
//		kim.run();
//		System.out.println(kim);
//		
//		Person lee = new Person();
//		lee.name = "이순신";
//		lee.age = 25;
//		lee.sleep("가수면");
//		lee.eat("사과");
//		kim.run();
		
		Student stud1 = new Student();
//		stud1.number = "1-123123";
//		stud1.name = "김홍식";
//		stud1.major = "언론영상학과";
//		stud1.study();
//		stud1.game();
//		stud1.sleep();
		stud1.setStudNo("123-123");
		stud1.setStudName("김홍식");
		
		Student stud2 = new Student();
//		stud2.number = "2-233423";
//		stud2.name = "김유경";
//		stud2.major = "귀여운학과";
//		stud2.study();
//		stud2.game();
//		stud2.sleep();
		stud2.setStudNo("321-321");
		stud2.setStudName("김유경");
		
		Student stud3 = new Student();
		
		
		Student[] students; // 배열이 많을때는 이렇게도 사용한다
		students = new Student[] {stud1,stud2,stud3};
		for(Student stud :students) {    //student 라는 배열을 stud라는 변수에 차례로 불러들이겠습니다
			System.out.println(stud.getStudNo() +" "+ stud.getStudName());
//			System.out.println("학번:"+ stud.major + ", 학생이름:" + stud.name);
		}
		
		
		//상속.
		WorkMan wman = new WorkMan(); //자식 클래스는 부모 클래스의 필드내용을 상속받아 쓸 수 있다
		wman.name ="직장인";
		wman.age =  30;
		
		StudMan sman = new StudMan();
		sman.school = "고등학교";
		sman.height =164.3;
		
		
	}
}
