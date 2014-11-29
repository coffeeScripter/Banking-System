/**
 * 
 */
package businessLayer;

/**
 * @author Noah
 *
 */
/**
 * 
 */

/**
 * @author Noah
 *	this acts as a connection for the Data Objects
 *	it holds the information 
 */
public class Token {
	private String id, password, name, access;
	private boolean isValid;

	/**
	 * 
	 */
	public Token(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}


}
