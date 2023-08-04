/**
 * Represents an town as a node of a graph. The Town class holds the name of the town and a 
 * list of adjacent towns, and other fields as desired, and the traditional methods 
 * (constructors, getters/setters, toString, etc.). It will implement the Comparable 
 * interface These are the minimum methods that are needed. Please feel free to add as
 * many methods as you need.
 * @author Michael Bushman
 *
 */
public class Town implements Comparable<Town> {
	//class variable
	String townName = "";
	//basic constructor
	public Town(String name) {
		townName = name;
	}
	//copy constructor
	public Town(Town templateTown) {
		townName = templateTown.townName;
	}
	//getter
	public String getName() {
		return townName;
	}
	/**
	 * 0 if names are equal, a positive or negative number if the names are not equal
	 */
	public int compareTo(Town o) {
		//returns -1 given objects town name is larger, returns 0 if equal and returns 1 if town name is greater than given objects
		return townName.compareTo(o.townName);
	}
	/**
	 * toString method
	 */
	public String toString() {
		return townName;
	}
	/**
	 * the hashcode for the name of the town
	 */
	public int hashCode() {
		return townName.hashCode();
	}
	/**
	 * true if the town names are equal, false if not
	 */
	public boolean equals(Object obj) {
		//variables
		boolean equalTowns = false;
		Town town = (Town)obj;
		//checks if the town name is equal to the given object's town name
		if (townName.equals(town.townName))
			//returns true if equal town names
			equalTowns = true;
		else
			//returns false if not equal town names
			equalTowns = false;
		
		return equalTowns;
	}
}
