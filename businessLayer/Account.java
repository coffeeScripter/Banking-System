/**
 * 
 */
package businessLayer;

import java.util.*;

/**
 * @author Noah
 *
 */
public class Account {
	
	String name;
	int number;
	double balance;
	ArrayList<Transaction> transHist;
	/**
	 * represnts an account having a 
	 *  name,
	 *  number, 
	 *  balance, 
	 *  and transaction history
	 */
	public Account() {
		// TODO Auto-generated constructor stub
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public ArrayList<Transaction> getTransHist() {
		return transHist;
	}
	public void setTransHist(ArrayList<Transaction> transHist) {
		this.transHist = transHist;
	}
	

}
