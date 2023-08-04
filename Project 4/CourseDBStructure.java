import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 
 * 
 * @author Michael Bushman
 *
 * This is the Course Database Structure class based on the Course Database Structure interface. 
 *
 */

public class CourseDBStructure implements CourseDBStructureInterface{
	//Variables
	protected LinkedList<CourseDBElement>[] table;
	protected double loadFactor = 1.5;
	
	//Default constructor with int parameter
	//I was confused with loadfactor so I set the table size to the given course size
	@SuppressWarnings("unchecked")
	public CourseDBStructure (int n) {
		table = new LinkedList[n];
	}
	
	//Default constructor with string and int parameter
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int n) {
		table = new LinkedList[n];
	}
	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/

	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		//Finds the hashcode based on the CourseDBElement and hashtable
		int hashCode = element.hashCode() % table.length;
		//Checks if the CourseDBElement is null
		if (table[hashCode] == null) {
			//Creates a new hashtable
			table[hashCode] = new LinkedList<CourseDBElement>();
			//Adds the element to the new hashtable
			table[hashCode].add(element);
		}
		else {
			//Checks if the elements is already in the hashtable
			if (table[hashCode].contains(element))
				//Exits quietly
				return;
			else 
				//if not in hashtable, then adds the element 
				table[hashCode].add(element);
		}
	}

	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	public CourseDBElement get(int crn) throws IOException {
		// TODO Auto-generated method stub
		//Converts the given crn to a string
		String courseCRN = Integer.toString(crn);
		//Creates hashcode based on the given crn and hashtable
		int hashCode = courseCRN.hashCode() % table.length;
		//Checks if the element is not found in the hashtable. If so, throw IOException
		if (table[hashCode] == null)
			throw new IOException();
		else
			//Returns the course with the matching crn
			return (CourseDBElement) table[hashCode].get(0);
	}


	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		//Variable
		ArrayList<String> allCourses = new ArrayList<String>();
		//Runs through the size of the hashtable
		for(int i = 0; i < table.length; i++) {
			//Runs while the table is not empty
			while (table[i] != null) {
				for(int j = 0; j < table[i].size(); j++) {
					//Grabs the current element in the hashtable 
					CourseDBElement element= (CourseDBElement) table[i].get(j);
					//Adds the element to the arrayList 
					allCourses.add("\n" + element.toString());
				}
				//Stops once there are no more courses
				break;
			}
		}
		//Returns the arraylist of all courses
		return allCourses;
	}

	/**
	* Returns the size of the CourseDataStructure (number of indexes in the array)
	*/
	public int getTableSize() {
		// TODO Auto-generated method stub
		return table.length;
	}

}
