/**
 * @author Michael Bushman
 */
public class InvalidNotationFormatException extends Exception {

	public InvalidNotationFormatException() {
		this("The notation format is incorrect");
	}
	
	public InvalidNotationFormatException(String error) {
		super(error);
	}
}
