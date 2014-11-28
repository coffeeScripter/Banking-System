import java.sql.*;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Noah
 *
 */
public class Database extends Db_base implements Db_Abstraction {
	
//Constructor code
	/**
	 * Class constructor that sets the minimal required information to connect to the database: username and password.
	 * @param userId		The username for connecting to the database
	 * @param userPasswd 	The password for connecting to the database
	 */
	public Database(String userId, String userPasswd) {
		super(userId, userPasswd);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Class constructor that sets the all required information to connect to the database.
	 * @param uri 		 	The location of the database
	 * @param driver	 	The location of the driver for the database
	 * @param userId	 	The username for connecting to the database
	 * @param userPasswd 	The password for connecting to the database
	 */
	public Database(String uri, String driver, String userId, String userPasswd) {
		super(uri, driver, userId, userPasswd);
	}

	/**
	 * 
	 */
// *******************************************  
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

	// *******************************************    
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

	public ResultSet selectData(String query){
		
		String sql = query;
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
	public ArrayList<ArrayList<String>> getData (String sql){

		ArrayList<ArrayList<String>> list1 = new ArrayList<ArrayList<String>>();
		ArrayList<String> list2 = new ArrayList<String>();
		int colnum; // the number of returned columns
		
		ResultSet rs = selectData(sql);
		try {
			ResultSetMetaData mrs = rs.getMetaData();
			colnum = mrs.getColumnCount();
		
			// iterates through the resultset turning each sql table row into an ArrayList<String>
			// this ArrayList<String> is then added to another ArrayList which is then returned.
			while(rs.next()){
				list2 = new ArrayList<String>();
				for (int i=1; i<= colnum; i++){
					list2.add(rs.getString(i));
				}
				list1.add(list2);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close();
		return list1;

	}//end get data

	// *******************************************    
	public ArrayList<ArrayList<String>> getData (String sql, boolean colName){

		ArrayList<ArrayList<String>> list1 = new ArrayList<ArrayList<String>>();
		ArrayList<String> list2 = new ArrayList<String>();
		ResultSet rs = selectData(sql);
		ResultSetMetaData mrs;
		
		try {
			mrs = rs.getMetaData();
			
			int colnum = mrs.getColumnCount();
	
	//		is this needed?
			if (colName){
				list2 = new ArrayList<String>();
	//			adds an array for the column title to the start of the returned array,list2
				for (int i=1; i<= colnum; i++){
					list2.add(mrs.getColumnName(i));
				}            
				list1.add(list2);
			}
			// iterates through the resultset turning each sql table row into an ArrayList<String>
			// this ArrayList<String> is then added to another ArrayList which is then returned.
			while(rs.next()){
				list2 = new ArrayList<String>();
				for (int i=1; i<= colnum; i++){
					list2.add(rs.getString(i));
				}
				list1.add(list2);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list1;

	}//end get data


	// *******************************************  

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


	// *******************************************     
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


	// *******************************************  
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

}
