/**
 * @author Michael Bushman
 */
public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		this("This queue is empty, can't dequeue.");
	}
	
	public QueueUnderflowException(String message) {
		super(message);
	}
}
