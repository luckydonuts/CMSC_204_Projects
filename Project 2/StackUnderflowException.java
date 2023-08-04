/**
 * @author Michael Bushman
 */
public class StackUnderflowException extends Exception{

	public StackUnderflowException() {
		this("The stack is empty, can't top or pop.");
	}
	
	public StackUnderflowException(String error) {
		super(error);
	}
}
