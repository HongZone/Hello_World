package co.edu.board;

public class user {
	String userid;
	String passwd;
	String username;
	
	public user(String userid, String passwd, String username) {
		this.userid=userid;
		this.passwd=passwd;
		this.username=username;
	}
	public user(String userid, String passwd) {
		this.userid=userid;
		this.passwd=passwd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
