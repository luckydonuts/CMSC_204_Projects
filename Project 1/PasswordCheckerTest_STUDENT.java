
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Michael Bushman
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;

	@Before
	public void setUp() throws Exception {
		String[] p = {"22115CC#", "maxy3AAA#", "5SAl$", "robin22", "march30", "aBcDe", 
				"OrangexxxYYzz#", "aa33BBb", "projectOne", "CCBBBb@123"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("123ab"));
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("12abAA#"));
			assertTrue("Did not throw lengthException",true);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",false);
		}
		 
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("334455"));
			 
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("12abAA#"));
			 
			assertTrue("Did not throw NoUpperAlphaException",true);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("123AAB2"));
 
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("12abAA#"));
 
			assertTrue("Did not throw NoLowerAlphaException",true);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			boolean weakPassword = PasswordCheckerUtility.isWeakPassword("334@aAA");
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
		
		try{
			boolean weakPassword = PasswordCheckerUtility.isWeakPassword("12abAAabab#");
			assertTrue("Did not throw WeakPassword Exception",true);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("1@@aAAA"));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
		
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("12abAA#"));
		 	assertTrue("Did not throw an InvalidSequenceException",true);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("AAaaBB#"));
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("12abAA#"));
			assertTrue("Did not throw NoDigitException",true);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",false);
		}
		 
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordSuccessful() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException
	{
		try{
			assertEquals(true, PasswordCheckerUtility.isValidPassword("434Amnopqq?"));
		    assertEquals(true, PasswordCheckerUtility.isValidPassword("$uwMaM4l"));
		    assertEquals(true, PasswordCheckerUtility.isValidPassword("N0oNa$D"));
		    assertEquals(true, PasswordCheckerUtility.isValidPassword("(CowGirls3#)"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		
		try{
			assertEquals(false, PasswordCheckerUtility.isValidPassword("Amnopqq?"));
		    assertEquals(false, PasswordCheckerUtility.isValidPassword("uwMaM4l"));
		    assertEquals(false, PasswordCheckerUtility.isValidPassword("NoNa$D"));
		    assertEquals(false, PasswordCheckerUtility.isValidPassword("(CowGirls3)"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "22115CC#");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(1));  
		assertEquals(scan.next(), "maxy3AAA#");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("sequence"));
		 
		scan = new Scanner(results.get(2));  
		assertEquals(scan.next(), "5SAl$");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
		scan = new Scanner(results.get(3));  
		assertEquals(scan.next(), "robin22");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(4));  
		assertEquals(scan.next(), "march30");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") );
		
		scan = new Scanner(results.get(5));  
		assertEquals(scan.next(), "aBcDe");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long") );
		
		scan = new Scanner(results.get(6));  
		assertEquals(scan.next(), "OrangexxxYYzz#");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit") );
		
		scan = new Scanner(results.get(7));  
		assertEquals(scan.next(), "aa33BBb");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special") );
		
		scan = new Scanner(results.get(8)); 
		assertEquals(scan.next(), "projectOne");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit") );
		
		scan = new Scanner(results.get(9));  
		assertEquals(scan.next(), "CCBBBb@123");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence") );
	}
	
}
