/**
 * Thrown if a password has no digits
 * @author Micahel Bushman
 */
public class NoDigitException extends Exception {

	public NoDigitException() {
		this ("The password must contain at least one digit");
	}
	
	public NoDigitException(String message) {
		super(message);
	}
}
