package dataLayer;

import java.sql.*;

/**
 * 	This class creates the variables and constructors for any database abstraction layer. This should be paired with the Db_Abstraction interface.
 * 	@author Noah Peterham
 * 	@author Brian Duffy
 * 	@author Jon Koch
 *	@version 1.1.1.1, 11-25-14
 */
public class Db_base {
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
	public Db_base(String userId, String userPasswd) {
		this.userId = userId;
		this.userPasswd = userPasswd;
	}
	
	/**
	 * Class constructor that sets the all required information to connect to the database.
	 * @param uri 		 	The location of the database
	 * @param driver	 	The location of the driver for the database
	 * @param userId	 	The username for connecting to the database
	 * @param userPasswd 	The password for connecting to the database
	 */
	public Db_base(String uri, String driver, String userId, String userPasswd) {
		this.uri = uri;
		this.driver = driver;
		this.userId = userId;
		this.userPasswd = userPasswd;
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
