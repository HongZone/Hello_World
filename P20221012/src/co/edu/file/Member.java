package co.edu.file;

public class Member {
	String id;
	String name;
	String point;
	
	public Member(String id, String name, String point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", point=" + point;
	}
	
	
	
}
