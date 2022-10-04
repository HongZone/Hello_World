package co.edu.inherit.interfaces;

public class DeptServiceImpl implements DaoService {
	@Override
	public void insert() {
		System.out.println("부서저장");
		
	}

	@Override
	public void search() {
		System.out.println("부서조회");
		
	}

	@Override
	public void delete() {
		System.out.println("부서삭제");
		
	}
}
