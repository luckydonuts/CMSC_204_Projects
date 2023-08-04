import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Michael Bushman
 *
 * Class that prints the full tree, converts Morse code to English based off a given code and converts
 * Morse code to English based off a given file.
 */
public class MorseCodeConverter {
	//class variable
	private static MorseCodeTree morseTree = new MorseCodeTree();
	//basic constructor
	public MorseCodeConverter() {
		
	}
	/**
	 * Returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree It should return the data in this order:
     * "h s v i f u e l r a p w j b d x n c k y t z g q m o"
     * Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal, the root would come between the right most child of the left tree (j) and the left most child of the right tree (b). 
     * This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 * @return string of full tree
	 */
	public static String printTree() {
		//variables
		ArrayList<String> treeList = morseTree.toArrayList();
		String fullTree = "";
		//loop that runs through the arraylist
		for (int i = 0; i < treeList.size(); i++) 
			//grabs each arraylist element and adds it to the string
			fullTree += treeList.get(i);
		//removes any leading or trailing space characters
		//needed for passing Junit test
		fullTree = fullTree.trim(); 
		//returns a string of full tree 
		return fullTree;
	}
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * Example: code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 * string returned = "Hello World"
	 * @param code
	 * @return string of converted Morse code to English
	 */
	public static String convertToEnglish(String code) {
		//variables
		String [] morseletter = null;
		String morseToEnglish = "";
		//splits each code word into to an array
		String [] morseWord = code.split("/");
		//runs through the length of the codeWord array
		for (int i = 0; i < morseWord.length; i++) {
			//assigns each letter of the current word to the letter array 
			morseletter = morseWord[i].split(" ");
			//runs through each codeLetter 
			for (int j = 0; j < morseletter.length; j++) {
				//calls fetch method to retrieve the converted letter based on the current code
				morseToEnglish += morseTree.fetch(morseletter[j]);
			}
			//adds a space in between each letter
			morseToEnglish += " ";
		}
		//removes any leading or trailing space characters
		morseToEnglish = morseToEnglish.trim();
		//returns the translated Morse code to english
		return morseToEnglish;

	}
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * Example: a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 * string returned = "Hello World"
	 * @param codeFile
	 * @return string of converted Morse code to English
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		//variables
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(codeFile);
		String morseToEnglish = "";
		//catches any empty files just in case for testing
		if (!reader.hasNext())
			return "";
		//checks if there is a next line in the given file
		while (reader.hasNext())
			//calls the convertToEnglish method to read through each file line and adds the translated code to the string
			morseToEnglish += convertToEnglish(reader.nextLine());
		//returns the translated Morse code to english from a file
		return morseToEnglish;
	}
}
