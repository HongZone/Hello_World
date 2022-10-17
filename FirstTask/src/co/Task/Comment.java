package co.Task;

public class Comment {
	int Cnum;
	String Cwriter;
	String Ccontent;
	String Cdate;
	int Ccnt;
	
	public Comment() {}
	public Comment(int Cnum,String Cwriter,String Ccontent,String Cdate,int Ccnt) {
		this.Cnum=Cnum;
		this.Cwriter = Cwriter;
		this.Ccontent = Ccontent;
		this.Cdate = Cdate;
		this.Ccnt = Ccnt;
	}


	public int getCnum() {
		return Cnum;
	}
	public void setCnum(int cnum) {
		Cnum = cnum;
	}
	public String getCwriter() {
		return Cwriter;
	}
	public void setCwriter(String cwriter) {
		Cwriter = cwriter;
	}
	public String getCcontent() {
		return Ccontent;
	}
	public void setCcontent(String ccontent) {
		Ccontent = ccontent;
	}
	public String getCdate() {
		return Cdate;
	}
	public void setCdate(String cdate) {
		Cdate = cdate;
	}
	public int getCcnt() {
		return Ccnt;
	}
	public void setCcnt(int ccnt) {
		Ccnt = ccnt;
	}
	@Override
	public String toString() {
		return "글번호:" + Cnum + " 작성자:" + Cwriter + " 내용:" + Ccontent + " 날짜:" + Cdate
				+ " 추천수" + Ccnt;
	}
	
	
	
}
