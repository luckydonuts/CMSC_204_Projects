/**
 * @author Michael Bushman
 */
public class StackOverflowException extends Exception{

	public StackOverflowException() {
		this("This stack is full, can't push.");
	}
	
	public StackOverflowException(String error) {
		super(error);
	}
}
