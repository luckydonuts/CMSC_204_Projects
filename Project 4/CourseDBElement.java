/**
 * 
 * @author Michael Bushman
 * 
 */
public class CourseDBElement implements Comparable {
	//Variables
	private String IDNumber;
	private int crnNumber;
	private int classCredits;
	private String roomNumber;
	private String instructorName;
	
	//Basic Constructor
	public CourseDBElement() {
		IDNumber = "";
		crnNumber = 0;
		classCredits = 0;
		roomNumber = "";
		instructorName = "";
	}
	
	//Constructor that takes in an String id, int crn, int credits, String roomNum and String instructor
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		IDNumber = id;
		crnNumber = crn;
		classCredits = credits;
		roomNumber = roomNum;
		instructorName = instructor;
	}
	
	//Creates a hashcode based on the given crn number
	public int hashCode() {
		String hashCode = Integer.toString(crnNumber);
		return hashCode.hashCode();
	} 
	
	//toString method that strings together all information about the course
	public String toString() {
		String course="Course:"+IDNumber+" CRN:"+crnNumber+" Credits:"+classCredits+" Instructor:"+instructorName+ " Room:"+roomNumber;
		return course;
	}
	//compareTo method for the comparable interface
	public int compareTo(CourseDBElement element) {
		return Integer.compare(getCRN(), element.getCRN());
	}
	
	//Getters and setters
	public String getID() {
		return IDNumber;
	}
	
	public int getCRN() {
		return crnNumber;
	}
	
	public String getRoomNum() {
		return roomNumber;
	}
	
	public String setID() {
		return IDNumber;
	}
	
	public void setCRN(int crn) {
		crnNumber = crn;
	}
	
	public void setRoomNum(String room) {
		roomNumber = room;
	}
}
