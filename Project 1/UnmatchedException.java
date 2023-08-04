/**
 * Thrown if a password doesn't match
 * @author Micahel Bushman
 */
public class UnmatchedException extends Exception {
	
	public UnmatchedException() {
		this ("Passwords do not match");
	}
	
	public UnmatchedException(String message) {
		super(message);
	}
}
