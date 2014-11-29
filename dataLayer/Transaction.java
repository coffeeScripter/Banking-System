/**
 * 
 */
package dataLayer;

import java.text.SimpleDateFormat;

/**
 * @author Noah
 *
 */
public class Transaction {
	SimpleDateFormat date;
	char type;
	String location;
	double transAmt;
	double newBalance;
	
	/**
	 * 
	 */
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param type the type of transaction d,w,u
	 */
	public Transaction(char type){
		this.type = type;
	}
	/**
	 * @param type
	 * @param location
	 * @param transAmt
	 */
	public Transaction(char type, String location, double transAmt) {
		this.type = type;
		this.location = location;
		this.transAmt = transAmt;
	}
	public double computeBalance(){
		return 20;
	}
	public boolean isValid(){
		return false;
	}
	
	// getters and setters
	public SimpleDateFormat getDate() {
		return date;
	}

	public char getType() {
		return type;
	}

	public String getLocation() {
		return location;
	}

	public double getTransAmt() {
		return transAmt;
	}

	public double getNewBalance() {
		return newBalance;
	}


}
