package co.edu.ingerit.friend;

public class UnivFriend extends Friend {
	private String univ;
	private String major;
	
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}

	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String showInfo() {
		return "학교친구의 이름은 " + getName() + ", 연락처는 " + getPhone()+", 학교이름은 " +this.univ+ ", 전공과목은 "+ this.major;
	}
	
}
