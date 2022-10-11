package co.edu.memo.except;

public class MenuException extends Exception {
	 int choice ;
	 
	 public MenuException(int choice) {
		 this.choice = choice;
	 }
	 public void showErrMessage() {
		 System.out.println(choice+"는 없는 메뉴 입니다");
	 }
}
