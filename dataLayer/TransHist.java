/**
 * 
 */
package dataLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import businessLayer.Token;
/**
 * @author Noah
 *
 */
public class TransHist {
	private ArrayList<Transaction> hist;
	private Transaction trans;
	private Token t;
	public TransHist(Token t){
		this.t = t;
	}
	
	private int populate(int acct_id){
		try{
			// errant use of a PreparedStatement
			
			PreparedStatement pstmt = new Db_base(t).getConn().prepareStatement("SELECT "
					+ "id, amount FROM Account "
					+ "WHERE acct_id LIKE ?" );
			//set values for the prepared statement
			pstmt.setInt(1, acct_id);
			
			//execute the preparedStatement query
			ResultSet rs = pstmt.executeQuery();
			
			//sets the objects values
			while(rs.next()){
				hist.add(new Transaction(rs.getInt("trans_id"),rs.getDouble("amount"), t));	
			}
			return hist.size();
			
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		
	}
	// add more methods like populate for other search terms as needed
}
