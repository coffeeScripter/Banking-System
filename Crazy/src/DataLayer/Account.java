/**
 * 
 */
package DataLayer;

/**
 * @author Noah
 *
 */
public class Account {

	/**
	 * 
	 */
	public Account() {
		// TODO Auto-generated constructor stub
	}

	
	/** *****************************************************
	 * fetch and post
	 */
	
	public boolean fetchAcc(){
		try{

			PreparedStatement pstmt = getConn().prepareStatement("SELECT "
					+ "balance, custId, interest_rate FROM Account "
					+ "WHERE acctId= ?" );
			//set values for the prepared statement
			pstmt.setInt(1, getAcctId());

			//execute the preparedStatement query
			ResultSet rs = pstmt.executeQuery();

			//sets the objects values
			setBalance(rs.getDouble("balance"));
			setCustId (rs.getString("custId"));
			setIntRate(rs.getInt("interest_rate"));


		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

		// returns true if no issues are found.
		return true;
	}// end fetchAcc

	/**
	 * updates the account balance in the database
	 * @param acctId the number of the account being updated
	 */
	public boolean postBal(){

		try{
			PreparedStatement pstmt = getConn().prepareStatement("UPDATE account SET balance =? where account_number = ?");

			pstmt.setDouble(1, getBalance());
			pstmt.setInt(2, getAcctId());

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
	} // end postBal

	/**
	 * updates the account interest rate in the database
	 * @param acctId the number of the account being updated
	 */
	public boolean postRate(){

		try{
			PreparedStatement pstmt = getConn().prepareStatement("UPDATE account SET interest_rate =? where sccount_number = ?");

			pstmt.setDouble(1, getIntRate());
			pstmt.setInt(2, getAcctId());

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
	} // end postRate

		
    // returns true if no issues are found.
		return true;
	}

	// updates this objects data
	private boolean post(){
		try{
			// errant use of a PreparedStatement
			PreparedStatement pstmt = getConn().prepareStatement("Update Account"
					+ "balance = ?,"
					+ "WHERE account_id LIKE ? "
					+ "AND cust_id LIKE ?" );
			//set values for the prepared statement
			pstmt.setFloat(1, getBalance());
			pstmt.setInt(2, getAcctId());
			pstmt.setInt(3, getCustId());
			
			//execute the preparedStatement update
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
