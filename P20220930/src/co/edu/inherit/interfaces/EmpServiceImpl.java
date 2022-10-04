package co.edu.inherit.interfaces;
//구현클래스(인터페이스를 상속하는 클래스)
//interface를 상속받을 때는 extend가 아니라 implements로 상속
public class EmpServiceImpl implements DaoService{
	private String db;
	
	public EmpServiceImpl() {}
	public EmpServiceImpl(String db) {
		this.db = db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	public String getDb() {
		return this.db;
	}
	

	@Override
	public void insert() {
		System.out.println(db + "저장");
		
	}

	@Override
	public void search() {
		System.out.println(db + "조회");
		
	}

	@Override
	public void delete() {
		System.out.println(db + "삭제");
		
	}

}
