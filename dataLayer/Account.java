/**
 * 
 */
package dataLayer;// should be in dataLayer

import java.sql.*;
import java.util.*;

/**
 * @author Noah, Brian
 *
 */
public class Account extends Db_base{

	int acctId;		// unique identifier for the account
	String custId;	// unique identifier for the customer
	double balance;	// the current balance for the account
	double intRate; // the current interest rate on the account
	ArrayList<Transaction> transHist;
	/**
	 * Represents an account having a 
	 *  CustId,
	 *  number, 
	 *  balance, 
	 *  and transaction history
	 */


	public Account(String userId, String userPassword) {
		super(userId, userPassword);
		this.acctId = 0;
		this.custId = null;
		this.balance = 0;
		this.intRate = 0;
	}
	public Account(int AccID,String userId, String userPassword){
		super(userId, userPassword);
		this.acctId = AccID;
	}
	public Account(int AccID, String CustID, double Bal, double Rate ,String userId, String userPassword){
		super(userId, userPassword);
		this.acctId = AccID;
		this.custId = CustID;
		this.balance = Bal;
		this.intRate = Rate;
	}	


	// getters and setters
	/**
	 * @return the customer id
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * @return the account id
	 */
	public int getAcctId() {
		return acctId;
	}
	/**
	 * @return the account balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @return the interest rate
	 */
	public double getIntRate() {
		return intRate;
	}
	/**
	 * @param set the account balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @param set the interest rate
	 */
	public void setIntRate(double IntRate) {
		this.intRate = IntRate;
	}
	/**
	 * @param set the customer id
	 */
	public void setCustId(String CustID) {
		this.custId = CustID;
	}
	/**
	 * @param set the account id
	 */
	public void setAcctId(int AccID) {
		this.acctId = AccID;
	}

	/*
	public ArrayList<Transaction> getTransHist() {
		return transHist;
	}

	protected double withdraw(double amt){
		d.getConn();
		d.startTrans();
		fetch();
		d.setData(sql);
		getBalance();
		return newBalance;
	}

	protected double deposit(double amt){
		return newBalance;
	}
	 */
	/**
	 * gets all the account information from the database
	 * @param acctId the number of the account being fetched
	 */
	public boolean fetch(){
		try{

			PreparedStatement pstmt = getConn().prepareStatement("SELECT "
					+ "balance, custId, interest_rate FROM Account "
					+ "WHERE acctId= ?" );
			//set values for the prepared statement
			pstmt.setInt(1, getAcctId());

			//execute the preparedStatement query
			ResultSet rs = pstmt.executeQuery();

			//sets the objects values
			setBalance(rs.getDouble("balance"));
			setCustId (rs.getString("custId"));
			setIntRate(rs.getInt("interest_rate"));


		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

		// returns true if no issues are found.
		return true;
	}// end fetch

	/**
	 * updates the account balance in the database
	 * @param acctId the number of the account being updated
	 */
	public boolean postBal(){

		try{
			PreparedStatement pstmt = getConn().prepareStatement("UPDATE account SET balance =? where account_number = ?");

			pstmt.setDouble(1, getBalance());
			pstmt.setInt(2, getAcctId());

			int num = pstmt.executeUpdate();
			if (num == 1){
				return true;
			}
		}
		catch(SQLException sqlEX) {
			System.out.println("statement unsuccessful");
			System.out.println(sqlEX.getMessage());
		}
		//  close();
		return false;
	} // end postBal

	/**
	 * updates the account interest rate in the database
	 * @param acctId the number of the account being updated
	 */
	public boolean postRate(){

		try{
			PreparedStatement pstmt = getConn().prepareStatement("UPDATE account SET interest_rate =? where sccount_number = ?");

			pstmt.setDouble(1, getIntRate());
			pstmt.setInt(2, getAcctId());

			int num = pstmt.executeUpdate();
			if (num == 1){
				return true;
			}
		}
		catch(SQLException sqlEX) {
			System.out.println("statement unsuccessful");
			System.out.println(sqlEX.getMessage());
		}
		//  close();
		return false;
	} // end postRate




}