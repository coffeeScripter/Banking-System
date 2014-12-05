/**
 * 
 */
package businessLayer;

import java.sql.SQLException;
import java.sql.*;
/**
 * @author Noah
 *
 */
public class AccountManage {
	private Token myToken;
	/**
	 * 
	 */
	public AccountManage(String username, String password) {
		// TODO Auto-generated constructor stub
		myToken = new Token(username, password);
//		myToken.isValid(); // add an if to check if this is true or false
	}
<<<<<<< HEAD
	public void test(){
		System.out.println("In test method");
		try {
         ResultSet rs = myToken.getTokenConn().selectData("SELECT * FROM Customer");
         System.out.println("there is a resultSet");
			while(rs.next()){
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
=======
	
	public boolean deposit(int aNum, double amt){
		// Verify is customers account or employee
		// get balance
		// do math
		// Account.postBal()
		// record transaction
		return true;
	}
	public boolean withdrawal(int aNum, double amt){
		// Verify is customers account or employee
		// get balance
		// do math
		// Account.postBal()
		// record transaction
		return true;
>>>>>>> ea04797f529047c6704fd3c1bc68e34b9cc44a0a
	}
	
	public Account getAccount(){
		return null;
		
	}

}
