package dataLayer;

import java.sql.*;

import businessLayer.Token;
/**
 * 	@author Noah Peterham
 * 	@author Brian Duffy
 * 	@author Jon Koch
 */

public class people extends Db_base {
	
	int id;  // unique identifier from people
	String fName;	// fist name
	String lName;	// last name
	String email;	// primary email

	public people(Token t) {
		super(t);
		this.id = 0;
		this.fName = null;
		this.lName = null;
		this.email = null;
	}
	public people(int ID, Token t) {
		super(t);
		this.id = ID;
	}
	public people(int ID,String FName, String LName, String Email, Token t) {
		super(t);
		this.id = ID;
		this.fName = FName;
		this.lName = LName;
		this.email = Email;
	}
	
	// getters and setters
		/**
		 * @return the person id
		 */
		public int getID(){
			return id;
		}
		/**
		 * @return the first name
		 */
		public String getFName() {
			return fName;
		}
		/**
		 * @return the last name
		 */
		public String getLName() {
			return lName;
		}
		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param set the person id
		 */
		public void setID(int pID) {
			this.id = pID;
		}
		/**
		 * @param set the first name
		 */
		public void setFName(String FName) {
			this.fName = FName;
		}
		/**
		 * @param set the last name
		 */
		public void setLName(String LName) {
			this.lName = LName;
		}
		/**
		 * @param set the last name
		 */
		public void setEmail(String Email) {
			this.lName = Email;
		}
		/**
		 * gets the id, first name, last name & email with people id
		 *
		 */
		public boolean fetchPeople(){
			try{

				PreparedStatement pstmt = getConn().prepareStatement("SELECT "
						+ "id, first_name, last_name, email FROM people "
						+ "WHERE id= ?" );
				//set values for the prepared statement
				pstmt.setInt(1, getID());

				//execute the preparedStatement query
				ResultSet rs = pstmt.executeQuery();

				//sets the objects values
				setFName(rs.getString("first_name"));
				setLName(rs.getString("Last_name"));
				setEmail(rs.getString("email"));

			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			// returns true if no issues are found.
			return true;
		}
		/**
		 * sets the first name, last name & email with people id
		 *
		 */
		public boolean postPeople(){
			try{
				PreparedStatement pstmt = getConn().prepareStatement("UPDATE  people "
						+ "SET first_name = ?, last_name = ?, email = ? where id = ?");

				
				pstmt.setString(1, getLName());
				pstmt.setString(2, getFName());
				pstmt.setString(3, getEmail());
				pstmt.setInt(4, getID());

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
		}
		/**
		 * creates a new people record
		 *
		 */
		public boolean newPeople(){
			try{
				PreparedStatement pstmt = getConn().prepareStatement("INSERT INTO people "
						+ "('first_name', 'last_name', 'email') VALUES (?, ?, ?)");

				
				pstmt.setString(1, getLName());
				pstmt.setString(2, getFName());
				pstmt.setString(3, getEmail());

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
		}
}
