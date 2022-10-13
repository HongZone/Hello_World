package co.edu.board;

public class Reply {
 int num;
 int boardnum;
 String repcontent;
 String repwriter;
 String date;
 
 public Reply(int num, int boardnum, String repcontent, String repwriter, String date) {
	 this.num = num;
	 this.boardnum = boardnum;
	 this.repcontent = repcontent;
	 this.repwriter = repwriter;
	 this.date = date;
 }
 
 public Reply(int num, int boardnum, String repcontent, String repwriter) {
	 this.num = num;
	 this.boardnum = boardnum;
	 this.repcontent = repcontent;
	 this.repwriter = repwriter;
 }

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public int getBoardnum() {
	return boardnum;
}

public void setBoardnum(int boardnum) {
	this.boardnum = boardnum;
}

public String getRepcontent() {
	return repcontent;
}

public void setRepcontent(String repcontent) {
	this.repcontent = repcontent;
}

public String getRepwriter() {
	return repwriter;
}

public void setRepwriter(String repwriter) {
	this.repwriter = repwriter;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

@Override
public String toString() {
	return "Reply [num=" + num + ", boardnum=" + boardnum + ", repcontent=" + repcontent + ", repwriter=" + repwriter
			+ ", date=" + date + "]";
}
 

 
}
