import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 
 */

/**
 * 	This interface sets the minimum requirements for any database abstraction layer. This should be paired with the Db_base class.
 * 	@author Noah Peterham
 * 	@author Brian Duffy
 * 	@author Jon Koch
 *	@version 1.1.1.1, 11-25-14
 */
public interface Db_Abstraction {
	
	/**
	 * Connects to the specified database. 
	 * @return	true if the connection was successful, false otherwise
	 */
	public boolean connect();
	
	/**
	 * Closes the current connection.
	 * @return
	 */
	public boolean close();
	
	/**
	 * Runs a select query and returns the ResualtSet.
	 * @param query The String representation of the select query to run
	 * @return The ResultSet for the query String's execution
	 */
	
	public ResultSet selectData(String query);
	/**
	 * Calls the selectData method and then parses the ResultSet
	 * @param query		The String representation of the select query to run
	 * @return success 	true if the query was run, false if it failed.
	 */
	public ArrayList<ArrayList<String>> getData(String query);
	
	/**
	 * WHY HAVE THIS?
	 * 
	 * Calls the selectData method and then parses the ResultSet
	 * @param query		The String representation of the select query to run
	 * @param titles	A boolean to differentiate this from the other getData method
	 * @return 
	 */
	public ArrayList<ArrayList<String>> getData(String query, boolean titles);
	
	/**
	 * Runs a update query and returns the number of rows altered
	 * @param query	The String representation of the select query to run
	 * @return
	 */
	public int setData(String query);
	
	/**
	 * Starts a transaction and handles the exceptions.
	 * @return if the transaction has been started
	 */
	public boolean startTrans();
	
	/**
	 * Ends a transactio and handles the exceptions
	 * @return if the transaction has been ended
	 */
	public boolean endTrans();
	
	/**
	 * Rolls back a transaction and handles the exceptions.
	 * @return if the transaction was rolledback
	 */
	public boolean rollbackTrans();
}
