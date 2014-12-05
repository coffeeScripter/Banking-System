/**
 * 
 */
package businessLayer;

import java.sql.SQLException;
<<<<<<< HEAD
import java.sql.*;
=======

>>>>>>> ea04797f529047c6704fd3c1bc68e34b9cc44a0a
/**
 * @author Noah
 *
 */
public class Account {
	private Token myToken;
	/**
	 * 
	 */
	public Account(String username, String password) {
		// TODO Auto-generated constructor stub
		myToken = new Token(username, password);
<<<<<<< HEAD
//		myToken.isValid(); // add an if to check if this is true or false
	}
	public void test(){
		System.out.println("In test method");
		try {
         ResultSet rs = myToken.getTokenConn().selectData("SELECT * FROM Customer");
         System.out.println("there is a resultSet");
			while(rs.next()){
=======
		System.out.println(myToken.isValid());
//		myToken.isValid(); // add an if to check if this is true or false
	}
	public void test(){
		
		try {
			while(myToken.getTokenConn().selectData("SELECT * FROM Customer").next()){
>>>>>>> ea04797f529047c6704fd3c1bc68e34b9cc44a0a
				System.out.println("my name is:  ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public double withdraw(double amount){
		double newAmount = 0;
		return newAmount;
	}
	
	public double deposit(double amount){
		double newAmount = 0;
		return newAmount;
	}
	
	public Account getAccount(){
		return null;
		
	}

}
