import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Michael Bushman
 * 
 * This is the CourseDBManager class based on the CourseDBManagerInterface.
 */
public class CourseDBManager implements CourseDBManagerInterface {
	//Variable
	CourseDBStructure CDS = new CourseDBStructure(100);

	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		//Adds the new CourseDBElement to the CourseDBStructure
		CDS.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}
	/**
	 * Finds CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	public CourseDBElement get(int crn) {
		try {
			//Returns the CourseDBElement based on the given crn key
			return CDS.get(crn);
		}
		catch(IOException error) {
			//Prints error message if no matching crn
			error.getMessage();
		}
		//Returns null if no matched crn
		return null;
	}
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 * Please see my other readFile method attempt at the bottom of this class. The other attempt runs Junit successfully but crashes the program
	 */
	public void readFile(File input) throws FileNotFoundException {
		try {
			//Variables
			Scanner scan = new Scanner(input);
			StringBuilder builder = new StringBuilder();
			//Runs while there is a next line in the file
			while (scan.hasNextLine()) {
				//Appends the line to the stringbuilder and tabs the cursor
				builder.append(scan.nextLine() + "\n");
			}
			//Once done, closes the file
			scan.close();
		}
		//Catches FileNotFoundException and prints StackTrace
		catch (FileNotFoundException error) {
			error.getMessage();
		}
	}
	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	public ArrayList<String> showAll() {
		//Returns the arraylist using the showAll method in CourseDBStructure class
		return CDS.showAll();
	}
	
	//This is the previous method I was attempting. The Junit test passes BUT crashes the program
	/** 
	  public void readFile(File input) throws FileNotFoundException {
	  
	  Scanner scan = new Scanner(input);
		while (scan.hasNextLine()) {
			String currentLine = scan.nextLine();
			String[] courseInfo = currentLine.split(" ");
			String id = courseInfo[0];
			int crn = Integer.parseInt(courseInfo[1]);
			int credits = Integer.parseInt(courseInfo[2]);
			String roomNum = courseInfo[3];
			String instructor = courseInfo[4];
			//I need to figure out how to parse each of the parts of the teacher's name and add the middle and lastname
			if (courseInfo.length > 5){
			for (int i = 5; i < courseInfo.length; i++)
			instructor += " " + courseInfo[i];
			}
			CDS.add(id, crn, credits, roomNum, instructor);
		}
	}
	 */
}
