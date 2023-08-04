/**
 * Thrown if a password has three or more of the same letters in a row
 * @author Micahel Bushman
 */
public class InvalidSequenceException extends Exception {
	
	public InvalidSequenceException() {
		this ("The password cannot contain more than two of the same character in sequence");
	}
	
	public InvalidSequenceException(String message) {
		super(message);
	}
}
