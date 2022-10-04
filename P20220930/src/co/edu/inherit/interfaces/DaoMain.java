package co.edu.inherit.interfaces;

public class DaoMain {
	public static void main(String[] args) {
		EmpServiceImpl service = new EmpServiceImpl();
		service.setDb("인사");
		service.insert();
		service.delete();
		
		
			DeptServiceImpl service2 = new DeptServiceImpl();
			service2.insert();
			service2.search();
			service2.delete();
			
			DaoService dao = new EmpServiceImpl(); // 구현클래스.
//			dao = new DeptServiceImpl();
			dao = new EmpServiceImpl("인사");
			dao.insert();
			dao.search();
			dao.delete();
		
	}
}
