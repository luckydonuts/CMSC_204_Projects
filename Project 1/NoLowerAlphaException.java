/**
 * Thrown if a password no lowercase letter
 * @author Micahel Bushman
 */
public class NoLowerAlphaException extends Exception {
	
	public NoLowerAlphaException() {
		this ("The password must contain at least one lowercase alphabetic character");
	}
	
	public NoLowerAlphaException(String message) {
		super(message);
	}
}
