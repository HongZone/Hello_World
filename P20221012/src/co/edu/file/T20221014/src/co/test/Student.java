package co.test;

// 학생번호, 이름, 나이, 영어, 수학
public class Student {
	private int studNo;
	private String studName;
	private int studAge;
	private int engScore;
	private int mathScore;

	public Student(int studNo, String studName, int studAge, int engScore, int mathScore) {
		super();
		this.studNo = studNo;
		this.studName = studName;
		this.studAge = studAge;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	public int getStudNo() {
		return studNo;
	}

	public void setStudNo(int studNo) {
		this.studNo = studNo;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getStudAge() {
		return studAge;
	}

	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

}
