/**
 * 
 */
package DataLayer;


import java.sql.*;
import java.util.ArrayList;

import DataLayer.Token;

/**
 * 	This class creates the variables and constructors for any database abstraction layer. This should be paired with the Db_Abstraction interface.
 * 	@author Noah Peterham
 * 	@author Brian Duffy
 * 	@author Jon Koch
 *	@version 1.1.1.1, 11-25-14
 */
public class Db_Base {
	//	Default connection variables
	// 	These are set in the event that a user doesn't specify a database to connect to.
	protected String dbString	= "jdbc:mysql://";
	protected String uri        = "localhost/travel";
	protected String driver     = "com.mysql.jdbc.Driver";
	protected String userId     = "root";	// testing only
	protected String userPasswd = "student";// testing only
	protected Connection conn 	= null;
	
//Constructor code
	/**
	 * Class constructor that sets the minimal required information to connect to the database: username and password.
	 * @param userId		The username for connecting to the database
	 * @param userPasswd 	The password for connecting to the database
	 */
	public Db_Base(String userId, String userPasswd) {
		this.userId = userId;
		this.userPasswd = userPasswd;
	}
	public Db_Base(Token t){
		this.userId = t.getId();
		this.userPasswd = t.getPassword();
	}
	/**
	 * Class constructor that sets the all required information to connect to the database.
	 * @param uri 		 	The location of the database
	 * @param driver	 	The location of the driver for the database
	 * @param userId	 	The username for connecting to the database
	 * @param userPasswd 	The password for connecting to the database
	 */
	public Db_Base(String uri, String driver, String userId, String userPasswd) {
		this.uri = uri;
		this.driver = driver;
		this.userId = userId;
		this.userPasswd = userPasswd;
	}
	
	//General methods for interacting with the database
	// like CRUD and connect/close
	// will be used by subclasses like Account and User
// *******************************************  
	//connect
	public boolean connect(){

		try{
			Class.forName(driver);
		}
		catch (ClassNotFoundException clEx){
			System.out.println(clEx.getMessage());
		}

		try{
			conn = DriverManager.getConnection(uri, userId, userPasswd);
			return true;
		}
		catch (SQLException se){
			System.out.println(se.getMessage());
		}
		return false;
	}

	public boolean close(){
		try{ 
			if(conn != null){
				conn.close();
			}
			// System.out.println("closed");
			return true;
		}
		catch (SQLException se){
			System.out.println(se.getMessage());
		}
		return false;

	}//close
// *******************************************  
	//Create should be handled in subclasses
		
// *******************************************  
	//read	

	/* (non-Javadoc)
	 * @see dataLayer.Db_Abstraction#selectData(java.lang.String)
	 */
	public ResultSet selectData(String query){
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}

// *******************************************  
	// Update // and delete
	/* (non-Javadoc)
	 * @see Db_Abstraction#setData(java.lang.String)
	 */
	public int setData(String sql){

		try{
			Statement st = conn.createStatement();

			return st.executeUpdate(sql); // an int representing the number of rows updated
			
		}
		catch(SQLException sqlEX) {
			System.out.println("statement unsuccessful");
			System.out.println(sqlEX.getMessage());
		}
		//  close();
		return -1;
	} // end set data


	
	
	
	
// *******************************************  	
	// transaction code	
	
	/* (non-Javadoc)
	 * @see Db_Abstraction#startTrans()
	 */
	public boolean startTrans(){
		try {
			// connect();
			conn.setAutoCommit(false);
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		} return false;

	}

	/* (non-Javadoc)
	 * @see Db_Abstraction#endTrans()
	 */
	public boolean endTrans(){

		try {
			conn.commit();
			close();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;  

	}

	/* (non-Javadoc)
	 * @see Db_Abstraction#rollbackTrans()
	 */
	public boolean rollbackTrans(){

		try {
			conn.rollback();
			close();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

	}
	
	
	
	
	
	//	Getter and Setter Code
	/**
	 * @return the dbString
	 */
	public String getDbString() {
		return dbString;
	}
	/**
	 * @param dbString the dbString to set
	 */
	public void setDbString(String dbString) {
		this.dbString = dbString;
	}
	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}
	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userPasswd
	 */
	public String getUserPasswd() {
		return userPasswd;
	}
	/**
	 * @param userPasswd the userPasswd to set
	 */
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}
	/**
	 * @param conn the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
