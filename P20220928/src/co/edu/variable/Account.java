package co.edu.variable;

public class Account {
	private String accNo; //계좌번호
	private	String owner; //예금주
	private int balance; //예금액
	
	//계좌번호
	void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	String getAccNo() {
		return this.accNo;
	}
	//예금주
	void setOwner(String owner) {
		this.owner = owner;
	}
	String getOwner() {
		return this.owner;
	}
	//예금주
	void setBalance(int balance) {
		this.balance = balance;
	}
	int getBalance() {
		return this.balance;
	}
	
}
