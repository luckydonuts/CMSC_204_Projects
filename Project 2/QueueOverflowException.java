/**
 * @author Michael Bushman
 */
public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		this("This queue is full, can't enqueue.");
	}
	
	public QueueOverflowException(String message) {
		super(message);
	}
}