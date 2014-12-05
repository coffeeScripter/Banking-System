/**
 * 
 */
package businessLayer;

import java.sql.*;

import dataLayer.Db_base;

/**
 * @author Noah
 *	this acts as a connection for the Data Objects
 *	it holds the information 
 */
public class Token {
	private String id, password;
	private boolean isValid;
	private Db_base tokenConn;
	/**
	 * 
	 */
	public Token(String id, String password) {
		this.id = id;
		this.password = password;
<<<<<<< HEAD
		tokenConn = new Db_base("root", "Snapple4Life%"); // need to change
		tokenConn.connect();
      isValid();
=======
		tokenConn = new Db_base("root", "student"); // need to change
		tokenConn.connect();
>>>>>>> ea04797f529047c6704fd3c1bc68e34b9cc44a0a
	}
	
	public boolean isValid(){
		try{
<<<<<<< HEAD
			PreparedStatement pstmt = tokenConn.getConn(). prepareStatement("SELECT count(*) AS count FROM Customer WHERE cust_id = ? AND cust_password = ?");// check if this is the right SQL 
			
	   	pstmt.setString(1, id);
   		pstmt.setString(2, password);

         ResultSet rs = pstmt.executeQuery();
         rs.next();
         
         if (rs.getInt("count") == 1){
				isValid = true;
			}else{
   			isValid = false;
         }
		}catch(SQLException sqle){

			System.out.println("Error at 47");
		   sqle.printStackTrace();

      }catch(Exception e){

			System.out.println("Error");
		}
      System.out.println(isValid + " YES PLEASE");
=======
			PreparedStatement pstmt = tokenConn.getConn(). prepareStatement("SELECT count() FROM User WHERE user_id = '?' AND password = '?'");// check if this is the right SQL 
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			ResultSet rs =  pstmt.executeQuery();
			if (rs.getInt(1) == 0){
				isValid = true;
			}
			isValid = false;
		}catch(SQLException sqle){
//			BankException be = new BankException(sqle);
			System.out.println("Error");
		}catch(Exception e){
//			BankException be = new BankException(e);
			System.out.println("Error");
		}
		isValid = false;
>>>>>>> ea04797f529047c6704fd3c1bc68e34b9cc44a0a
		return isValid;
	}

	/**
	 * @return the tokenConn
	 */
	public Db_base getTokenConn() {
		if(isValid){
			return tokenConn;
		}
		else{
			return null;
		}
	}
	
}
