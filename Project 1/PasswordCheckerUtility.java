import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements multiple methods for checking a password 
 * @author Michael Bushman
 */
public class PasswordCheckerUtility {
	/**
	 * Checks if two passwords are the same. No return.
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		//Variables
		boolean samePassword = false; 
		int lengthOne = password.length();
		int lengthTwo = passwordConfirm.length();
		int count = 0;
		//Checks if the two passwords are equal length
		if (lengthOne != lengthTwo)
			throw new UnmatchedException();
		//Loop that increases count if both characters of each password are the same
		for (int i = 0; i < lengthOne; i++) {
			if (password.charAt(i) == passwordConfirm.charAt(i)) 
				count++;
		}
		//Checks if password length equals count. Throws UnmatchedException if not.
		if (lengthOne == count)
			samePassword = true;
		else 
			throw new UnmatchedException();
	}
	/**
	 * Checks if two passwords are the same, returns the result
	 * @param password
	 * @param passwordConfirm
	 * @return true if the same, false if not
	 */
	public static boolean comparePasswordsWithReturn (String password, String passwordConfirm) {
		//Variables
		boolean samePassword = false; 
		int lengthOne = password.length();
		int lengthTwo = passwordConfirm.length();
		int count = 0;
		//Checks if the two passwords are equal length
		if (lengthOne != lengthTwo)
			samePassword = false; 
		//Loop that increases count if both characters of each password are the same
		for (int i = 0; i < lengthOne; i++) {
			if (password.charAt(i) == passwordConfirm.charAt(i)) 
				count++;
		}
		//Checks if password length equals count
		if (lengthOne == count)
			samePassword = true;
		else 
			samePassword = false;
		
		return samePassword;
	}
	/**
	 * Checks if the passowrd is 6 or more characters
	 * @param password
	 * @return returns true is valid length, throw LengthException if false
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException {
		//Variables
		boolean validLength = false;
		int length = password.length();
		//Checks if password is longer than 5 characters. Throws LengthException if not	
		if (length >= 6) {
			validLength = true;
			return validLength;
		}
		else 
			throw new LengthException();
	}
	/**
	 * Checks if the password has at least one uppercase letter
	 * @param password
	 * @return true if at least one uppercase, throws NoUpperAlphaException if false
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		//Variables
		boolean hasUppercase = false;
		char charPassword;
		int count = 0;
		int length = password.length();
		//Loop that increases count if there is a uppercase letter
		for (int i = 0; i < length; i++) {
			charPassword = password.charAt(i);
			if (Character.isUpperCase(charPassword))
				count++;
		}
		//If the password has 1 or more uppercase letters, return true. Throws NoUpperAlphaException is false
		if (count > 0) {
			hasUppercase = true;
			return hasUppercase;
		}
		else 
			throw new NoUpperAlphaException();
	}	
	/**
	 * Checks if the password has at least one lowercase letter
	 * @param password
	 * @return true if at least one uppercase, throws NoLowerAlphaException if false
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		//Variables
		boolean hasLowercase = false;
		char charPassword;
		int count = 0;
		int length = password.length();
		//Loop that increases count if a lowercase letter
		for (int i = 0; i < length; i++) {
			charPassword = password.charAt(i);
			if (Character.isLowerCase(charPassword))
				count++;
		}
		//If the password has 1 or more lowercase letters, return true. Throws NoUpperAlphaException if false
		if (count > 0) {
			hasLowercase = true;
			return hasLowercase;
		}
		else 
			throw new NoLowerAlphaException();
	}
	/**
	 * Checks if the password has a digit
	 * @param password
	 * @return true if it has a digit, throws NoDigitException if false
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		//Variables
		boolean hasDigit = false;
		char charPassword;
		int count = 0;
		int length = password.length();
		//Loops that increases count if there is a digit 
		for (int i = 0; i < length; i++) {
			charPassword = password.charAt(i);
			if (Character.isDigit(charPassword))
				count++;
		}
		//If the password has 1 of more digits, return true. Throws NoDigitException if false
		if (count > 0) {
			hasDigit = true;
			return hasDigit;
		}
		else 
			throw new NoDigitException();
	}
	/**
	 * Checks if the password has a special character
	 * @param password
	 * @return true if it does, throws NoSpecialCharacterException if it doesn't
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		//Variables
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
	    Matcher matcher = pattern.matcher(password);
	    //If the matcher can't find a special character, then NoSpecialCharacterException is thrown. Otherwise, return true
	    if (!matcher.find()) {
	      throw new NoSpecialCharacterException();
	    }
	    return true;
	}
	/**
	 * Checks if there is three or more of the same consecutive characters
	 * @param password
	 * @return true if there isn't, throws InvalidSequenceException if false
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		//Variables
		boolean noSameChar = true;
		int length = password.length();
		//Loop that checks if there is three of the same consecutive letters in a row. Throws InvalidSequenceException if there is		
		for (int i = 0; i < length-2; i++) {
			if (password.charAt(i) == password.charAt(i+1)) {
				if (password.charAt(i+1) == password.charAt(i+2)) {
					throw new InvalidSequenceException();
				}
			}
		}
		return noSameChar;
	}
	/**
	 * Checks if the password is valid based on the requirements
	 * @param password
	 * @return true is valid password, false if not
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		//Variables
		boolean validPassword = false;
		//Checks if all password requirements have been met
		if (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) &&  hasSpecialChar(password) && NoSameCharInSequence(password))
			validPassword = true;
		else
			validPassword = false;
		
		return validPassword;
	}
	/**
	 * Checks if the password is between 6 and 9 characters (inclusive)
	 * @param password
	 * @return true if between 6 and 9, false if not
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		//Variables
		boolean between6and9 = false;
		int length = password.length();
		//Checks if password length is between 6 and 9
		if (length > 5 && length < 10)
			between6and9 = true;
		else
			between6and9 = false;
		
		return between6and9;
	}
	/**
	 * Check if the password is valid and between 6 and 9 characters (inclusive)
	 * @param password
	 * @return false if not a weak password, throws WeakPasswordException if true
	 * @throws WeakPasswordException
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isWeakPassword (String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		//Variables
		boolean weakPassword = false;
		int length = password.length();
		//Checks if password length is less than 5 or greater than 10. Throws WeakPasswordException if true
		if (isValidPassword(password) && length > 5 && length < 10) 
			throw new WeakPasswordException();
		else
			weakPassword = false;
		
		return weakPassword;
	}
	/**
	 * Creates a new ArrayList of the invalid passwords from the given ArrayList of passwords
	 * @param passwords
	 * @return the invalid password ArrayList
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		//Variables
		ArrayList <String> invalidList = new ArrayList<>();
		String password = "";
		int length = passwords.size();
		//Loop that checks each password. If invalid, catches and adds password to the invalidList along with the exception message
		for (int i = 0; i < length; i++) {
			try {
				password = passwords.get(i);
				isValidPassword(password);
			}
			catch (Exception e) {
				invalidList.add(password + " -> " + e.getMessage());
			}
		}
		return invalidList;
	}
}
