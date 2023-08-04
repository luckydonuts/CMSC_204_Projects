/**
 * Thrown if a password has no uppercase letters
 * @author Micahel Bushman
 */
public class NoUpperAlphaException extends Exception {
	
	public NoUpperAlphaException() {
		this ("The password must contain at least one uppercase alphabetic character");
	}
	
	public NoUpperAlphaException(String message) {
		super(message);
	}
}
