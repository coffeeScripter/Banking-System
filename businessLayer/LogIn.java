package businessLayer;


public class LogIn{
	String logInID = null;
	String logInPass = null;
	String type = null; // user type cust, admin, clerk
	Token t;
	
	public LogIn(String ID, String pwd){
		this.logInID = ID;
		this.logInPass = pwd;
		
	}
	/*
	 * verify login credentials
	 * set user type 
	 */
	public boolean usrVerify(){
		if((this.logInID).substring(0, 1) == "E"){
			// query database to verify employee exists and password is correct
			// set type = role
			// set Token?
			return true;
		}
		else if((this.logInID).substring(0, 1) == "C"){
			// query database to verify customer exists and password is correct
			// set type = "cust"
			// set Token?
			return true;
		}
		else{
			// reject login
			return false;
		}
	}
	
	
	
}
