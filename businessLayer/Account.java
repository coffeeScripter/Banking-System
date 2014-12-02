/**
 * 
 */
package businessLayer;

import java.sql.SQLException;

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
		System.out.println(myToken.isValid());
//		myToken.isValid(); // add an if to check if this is true or false
	}
	public void test(){
		
		try {
			while(myToken.getTokenConn().selectData("SELECT * FROM Customer").next()){
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
