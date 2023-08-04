import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Michael Bushman
 * 
 * Junit tests for MorseCodeConverter class
 *
 */
class MorseCodeConverterTestStudent {

	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish("... .- .-.. .-.. -.-- / ... . .-.. .-.. ... / ... . .- ... .... . .-.. .-.. ... / -... -.-- / - .... . / ... . .- ... .... --- .-. . ");
		assertEquals("sally sells seashells by the seashore",converter1);
	}
	
	/**
	 * Testing for correct implementation of tree and traversal
	 */
	
	@Test
	public void testPrintTree() {	
		
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish(".-- .... --- / .-.. . - / - .... . / -.. --- --. ... / --- ..- - / .-- .... --- / .-- .... --- / .-- .... --- / .-- .... --- / .-- .... ---");
		assertEquals("who let the dogs out who who who who who", converter1);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		/*Make sure howDoILoveThee.txt is in the src directory for this 
		  test to pass
		*/
		File file = new File("src/lebron.txt"); 
		try {
			assertEquals("lebron is the goat", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

}
