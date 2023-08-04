/**
 * Thrown if a password is valid and is between 6 and 9
 * @author Micahel Bushman
 */
public class WeakPasswordException extends Exception {
	
	public WeakPasswordException() {
		this ("The password is OK but weak - it contains fewer than 10 characters");
	}
	
	public WeakPasswordException(String message) {
		super(message);
	}
}
