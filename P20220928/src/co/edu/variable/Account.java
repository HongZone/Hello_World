package co.edu.variable;

public class Account {
	 private String accNo; //계좌번호
	 private String owner; //예금주
	 private int balance; //예금액
	
	 public Account() {}
	
	public Account(String accNo, String owner) {
		this.accNo = accNo;
		this.owner = owner;
		
		
	}
	
	//계좌번호
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccNo() {
		return this.accNo;
	}
	//예금주
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOwner() {
		return this.owner;
	}
	//예금주
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return this.balance;
	}
	
}
