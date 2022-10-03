package co.edu.hong;

public class libSvc {
	private int bookNum;
	private String bookName;
	private String bookCtg;
	private String bookWriter;
	private String pubHouse;
	private String contents;
	
	
	public libSvc() {}
	public libSvc(int bookNum,String bookName,String bookCtg,String bookWriter,String pubHouse,String contents) {
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookCtg = bookCtg;
		this.bookWriter = bookWriter;
		this.pubHouse = pubHouse;
		this.contents = contents;
	}
	public int getBookNum() {
		return this.bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return this.bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCtg() {
		return this.bookCtg;
	}
	public void setBookCtg(String bookCtg) {
		this.bookCtg = bookCtg;
	}
	public String getBookWriter() {
		return this.bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getPubHouse() {
		return this.pubHouse;
	}
	public void setPubHouse(String pubHouse) {
		this.pubHouse = pubHouse;
	}
	public String getContents() {
		return this.contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	@Override
	public String toString() {
		return "도서정보 [도서번호= " + this.bookNum + ", 도서명= " + this.bookName + ", 카테고리= " + this.bookCtg + ", 저자= "
				+ this.bookWriter + ", 출판사=" + this.pubHouse + ", 내용=" + this.contents + "]";
	}
	
	
}
