/**
 * 
 */
package DataLayer;

import java.text.SimpleDateFormat;

import DataLayer.Token;

/**
 * @author Noah
 *
 */
public class Transaction extends Db_Base{
	double id;				// the id of the transaction object
	SimpleDateFormat date;	// the timestamp of the transaction object
	char type;				// the type of transaction
	String location;		// the location of the transaction
	double transAmt;		// the amount of the transaction
	boolean succeeded;		// if the transaction was completed
	
	/**
	 * This is a bare minimum constructor for a transaction object
	 * @param id	the unique id of the transaction object
	 * @param type 	the type of transaction d,w,u
	 */
	public Transaction(double id, double transAmt, String userId, String userPassword){
		super(userId,userPassword);
		this.id 	= id;
		this.transAmt 	= transAmt;
	}
	public Transaction(double id, double transAmt, Token t){
		super(t);
		this.id 	= id;
		this.transAmt 	= transAmt;
	}
	
	
	public Transaction(double id, char type, String location, double transAmt, String userId, String userPassword) {
		super(userId,userPassword);
		this.id 		= id;
		this.type 		= type;
		this.location	= location;
		this.transAmt 	= transAmt;
		this.date 		= new SimpleDateFormat();
	}
	
	
	/**
	 * @param origBal
	 * @return
	 */
	public double computeBalance(double origBal){
		return origBal - transAmt;
	}


	// getters and setters
	/**
	 * @return the id
	 */
	public double getId() {
		return id;
	}

	/**
	 * @return the date
	 */
	public SimpleDateFormat getDate() {
		return date;
	}

	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the transAmt
	 */
	public double getTransAmt() {
		return transAmt;
	}

	/**
	 * @return succeeded
	 */
	public boolean isSucceeded() {
		return succeeded;
	}

	/**
	 * @param sets if the transaction is effected the database 
	 */
	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}
	
	
}
