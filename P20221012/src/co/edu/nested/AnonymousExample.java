package co.edu.nested;

class People{
	int height;
	int weight;
	
	void showInfo() {
		System.out.println("showInfo");
	}
}

class Student extends People{
	int studNo;
}

public class AnonymousExample {
	public static void main(String[] args) {
		//익명상속클래스
		People people = new Student() {
			
			String color;
			
			@Override
			void showInfo() {
				System.out.println("익명 showInfo.");
				showColor();
			}
			
			void showColor() {
				System.out.println(this.color);
			}
		};
		people.showInfo();
	}
}
