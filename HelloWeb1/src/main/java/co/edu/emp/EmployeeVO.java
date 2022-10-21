package co.edu.emp;

public class EmployeeVO {
	private int employeeId; 
	private String firstName;
	private String lastName;
	private String email;
	private String hireDate;
	private String jobId;
	
	public EmployeeVO(int employeeId, String firstName, String lastName, String email, String hireDate, String jobId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email=email;
		this.hireDate = hireDate;
		this.jobId = jobId;
	}
	public EmployeeVO(String firstName, String lastName, String email, String hireDate, String jobId) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email=email;
		this.hireDate = hireDate;
		this.jobId = jobId;
	}
	public EmployeeVO(int employeeId, String lastName, String email, String hireDate, String jobId) {
		super();
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.email=email;
		this.hireDate = hireDate;
		this.jobId = jobId;
	}
	public EmployeeVO(String lastName, String email, String hireDate, String jobId) {
		super();
		this.lastName = lastName;
		this.email=email;
		this.hireDate = hireDate;
		this.jobId = jobId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "EmployeeVO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", hireDate=" + hireDate + ", jobId=" + jobId + "]";
	}
	
	
	
	
	
	
}
