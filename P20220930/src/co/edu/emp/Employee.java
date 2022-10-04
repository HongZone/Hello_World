package co.edu.emp;

// 데이터 한건 처리용
public class Employee {
   //사원번호, 사원이름, 부서번호, 부서명, 급여, 이메일
	private int employeeId;	//사원번호
	private String name;	//이름
	private int deptId; // 부서번호 10:인사 20:개별 30:영업(기본값)
	private String deptName; // 부서명
	private int salary; // 급여
	private String email;
	
	//생성자
	public Employee() {
		//기본생성자
		this.deptId = 30;
		this.deptName = "영업";
	}
	public Employee(int employeeId,String name,int salary, int deptId) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.deptId = deptId;
		if(this.deptId == 10) {
			this.deptName = "인사";
		}else if(this.deptId == 20){
			this.deptName = "개발";
		}else {
			this.deptName = "영업";
		}
	}
	
	//매개값이 3개 있는 생성자.
	public Employee(int employeeId,String name,int salary) {
		this(employeeId, name, salary, 30); //매개값을 다 써도 되지만 Employee를 사용하면 더 쉬움
	}
	
	//매개값이 2개 있는 생성자
	public Employee(int employeeId,String name) {
		this(employeeId, name, 0);
	}
	
	//매가값이 5개 있는 생성자
	public Employee(int employeeId,String name,int salary, int deptId, String email) {
		this(employeeId, name, salary, deptId);
		this.email=email;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
		if(this.deptId == 10) {
			this.deptName = "인사";
		}else if(this.deptId == 20){
			this.deptName = "개발";
		}else {
			this.deptName = "영업";
		}
	}
	public String getDeptName() {
		return deptName;
	}
//	public void setDeptName(String deptName) {
//		this.deptName = deptName;
//	}  //setDeptId가 정해지면 바뀌니까
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
