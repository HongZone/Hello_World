package co.edu.jdbc;

public class Employee {
	private int employeeId;
	private String lastName;
	private String email;
	private String hireDate;
	private String jobId;
	
	public Employee(int employeeId,String lastName, String email,String hireDate,String jobId) {
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHireDate() {
		return hireDate;
	}


	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	@Override
	public String toString() {
		return "사원번호: " +employeeId+ ", 이름: " +lastName+ ", 이메일: " +email+ ", 입사일자: " +hireDate+ ", 직무: " +jobId; 
	}
}
