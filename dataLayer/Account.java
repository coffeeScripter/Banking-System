/**
 * 
 */
package dataLayer;// should be in dataLayer

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @author Noah
 *
 */
public class Account extends Db_base{
	
	int acctId;		// unique identifier for the account
	int custId;	// unique identifier for the customer
	double balance;	// the current balance for the account
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
		// TODO Auto-generated constructor stub
	}
	public int getCustId() {
		return custId;
	}
	public int getAcctId() {
		return acctId;
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
	/*
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
	
	private boolean fetch(){
		try{
			
			PreparedStatement pstmt = getConn().prepareStatement("SELECT "
					+ "balance, custId, FROM Account "
					+ "WHERE acctId LIKE ?" );
			//set values for the prepared statement
			pstmt.setInt(1, getAcctId());
			
			//execute the preparedStatement query
			ResultSet rs = pstmt.executeQuery();
			
			//sets the objects values
			setBalance(rs.getDouble("balance"));
			custId = rs.getInt("custId");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
    // returns true if no issues are found.
		return true;
	}

	// updates this objects data
	private void post(){

		try{
			PreparedStatement pstmt = getConn().prepareStatement(
			Statement st = conn.createStatement();

			int num = st.executeUpdate(sql);
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
	} // end set data
		
	}

}