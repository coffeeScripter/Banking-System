package dataLayer;

import java.sql.*;

import businessLayer.Token;

/**
 * 	@author Noah Peterham
 * 	@author Brian Duffy
 * 	@author Jon Koch
 */

public class Employee extends Db_base{

	int id;  // unique identifier from people
	String empId;	// unique identifier for the employee
	String password;	// employee password
	String role;    // emloyee role


	public Employee(Token t) {
		super(t);
		this.id = 0;
		this.empId = null;
		this.password = null;
		this.role = null;
	}
	public Employee(String EmpID, Token t) {
		super(t);
		this.empId = EmpID;
	}
	public Employee(String EmpID, int pID, String pwd, String Role, Token t) {
		super(t);
		this.id = pID;
		this.empId = EmpID;
		this.password = pwd;
		this.role = Role;
	}

	// getters and setters
	/**
	 * @return the employee id
	 */
	public String getEmpId() {
		return empId;
	}
	/**
	 * @return the person id
	 */
	public int getID(){
		return id;
	}
	/**
	 * @return the password
	 */
	public String getPwd() {
		return password;
	}
	/**
	 * @return the employee role
	 */
	public String getRole(){
		return role;
	}
	/**
	 * @param set the employee id
	 */
	public void setEmpId(String EmpID) {
		this.empId = EmpID;
	}
	/**
	 * @param set the person id
	 */
	public void setID(int pID) {
		this.id = pID;
	}
	/**
	 * @param set the password
	 */
	public void setPwd(String pwd) {
		this.password = pwd;
	}
	/**
	 * @param set the employee role
	 */
	public void setRole(String Role) {
		this.role = Role;
	}
	/**
	 * gets the id, role and password from the employee id
	 *
	 */
	public boolean fetchEmp(){
		try{

			PreparedStatement pstmt = getConn().prepareStatement("SELECT "
					+ "id, role, emp_password FROM Employee "
					+ "WHERE empId= ?" );
			//set values for the prepared statement
			pstmt.setString(1, getEmpId());

			//execute the preparedStatement query
			ResultSet rs = pstmt.executeQuery();

			//sets the objects values
			setID(rs.getInt("id"));
			setRole(rs.getString("role"));
			setPwd(rs.getString("password"));

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

		// returns true if no issues are found.
		return true;
	} // end fetchEmp
	/**
	 * updates employee password
	 *
	 */
	public boolean postEmpPwd(){

		try{
			PreparedStatement pstmt = getConn().prepareStatement("UPDATE employee SET Emp_password =?"
					+ " where Emp_id = ?");

			pstmt.setString(1, getPwd());
			pstmt.setString(2, getEmpId());

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
	} // end postCustPwd
	/**
	 * gets the next available employee id
	 *
	 */
	public String nextEid(){
		String curMax = null;
		int eNum = 0;
		String newEid = null;

		try{
			//getting the current largest employee id
			PreparedStatement pstmt = getConn().prepareStatement("SELECT "
					+ "MAX(emp_id) FROM Employee");

			//execute the preparedStatement query
			ResultSet rs = pstmt.executeQuery();

			//sets the objects values
			curMax = rs.getString("employee_id");

		}catch(Exception e){
			e.printStackTrace();
			return newEid;
		}
		// Increment employee id by 1
		eNum = Integer.parseInt(curMax.substring(3));
		eNum++;
		newEid = "C" + eNum;

		// returns new employee id.
		return newEid;
	} //end nextCid
	/**
	 * creates new employee record
	 *
	 */
	public boolean postNewEmp(){

		try{
			PreparedStatement pstmt = getConn().prepareStatement("INSERT INTO employee "
					+ "('emp_id', 'id', 'emp_password', 'role') VALUES (?, ?, ?, ? )");

			pstmt.setString(1, getEmpId());
			pstmt.setInt(2, getID());
			pstmt.setString(3, getPwd());
			pstmt.setString(4, getRole());

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
	} // end postNewEmp
}



