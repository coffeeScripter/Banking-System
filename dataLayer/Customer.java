package dataLayer;

import java.sql.*;

import businessLayer.Token;

/**
 * 	@author Noah Peterham
 * 	@author Brian Duffy
 * 	@author Jon Koch
 */

public class Customer extends Db_base{

	int id;  // unique identifier from people
	String custId;	// unique identifier for the customer
	String password;	// customer password


	public Customer(Token t) {
		super(t);
		this.id = 0;
		this.custId = null;
		this.password = null;
	}
	public Customer(String CustID, Token t) {
		super(t);
		this.custId = CustID;
	}
	public Customer(String CustID, int pID, String pwd, Token t) {
		super(t);
		this.id = pID;
		this.custId = CustID;
		this.password = pwd;
	}

	// getters and setters
	/**
	 * @return the customer id
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * @return the person id
	 */
	public int getID(){
		return id;
	}
	/**
	 * @return the password
	 */
	public String getPwd() {
		return password;
	}
	/**
	 * @param set the customer id
	 */
	public void setCustId(String CustID) {
		this.custId = CustID;
	}
	/**
	 * @param set the person id
	 */
	public void setID(int pID) {
		this.id = pID;
	}
	/**
	 * @param set the password
	 */
	public void setPwd(String pwd) {
		this.password = pwd;
	}
	/**
	 * gets the id and password from the customer id
	 *
	 */
	public boolean fetchCust(){
		try{

			PreparedStatement pstmt = getConn().prepareStatement("SELECT "
					+ "id, custId, password FROM Customer "
					+ "WHERE custId= ?" );
			//set values for the prepared statement
			pstmt.setString(1, getCustId());

			//execute the preparedStatement query
			ResultSet rs = pstmt.executeQuery();

			//sets the objects values
			setID(rs.getInt("id"));
			setPwd (rs.getString("password"));

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

		// returns true if no issues are found.
		return true;
	} // end fetchCust
	/**
	 * updates customer password
	 *
	 */
	public boolean postCustPwd(){

		try{
			PreparedStatement pstmt = getConn().prepareStatement("UPDATE customer SET cust_password =?"
					+ " where cust_id = ?");

			pstmt.setString(1, getPwd());
			pstmt.setString(2, getCustId());

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
	} // end postCustPwd
	/**
	 * gets the next available customer id
	 *
	 */
	public String nextCid(){
		String curMax = null;
		int cNum = 0;
		String newCid = null;

		try{
			//getting the current largest customer id
			PreparedStatement pstmt = getConn().prepareStatement("SELECT "
					+ "MAX(customer_id) FROM Customer");

			//execute the preparedStatement query
			ResultSet rs = pstmt.executeQuery();

			//sets the objects values
			curMax = rs.getString("customer_id");

		}catch(Exception e){
			e.printStackTrace();
			return newCid;
		}
		// Increment customer id by 1
		cNum = Integer.parseInt(curMax.substring(1));
		cNum++;
		newCid = "C" + cNum;

		// returns new customer id.
		return newCid;
	} //end nextCid
	/**
	 * creates new customer record
	 *
	 */
	public boolean postNewCust(){

		try{
			PreparedStatement pstmt = getConn().prepareStatement("INSERT INTO customer "
					+ "('cust_id', 'id', 'cust_password) VALUES (?, ?, ?)");

			pstmt.setString(1, getCustId());
			pstmt.setInt(2, getID());
			pstmt.setString(3, getCustId());

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
	} // end postNewCust
}
