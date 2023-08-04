/**
 * The class Road that can represent the edges of a Graph of Towns. 
 * The class must implement Comparable. The class stores references to the 
 * two vertices(Town endpoints), the distance between vertices, and a name, 
 * and the traditional methods (constructors, getters/setters, toString, etc.), 
 * and a compareTo, which compares two Road objects. Since this is a undirected graph, 
 * an edge from A to B is equal to an edge from B to A.
 * @author Michael Bushman
 *
 */
public class Road implements Comparable<Road> {
	//variables
	Town townSource = null;
	Town townDestination = null;
	int townDegrees = 0;
	String townName = "";
	//basic constructor
	public Road(Town source, Town destination, int degrees, String name) {
		townSource = source;
		townDestination = destination;
		townDegrees = degrees;
		townName = name;

	}
	//basic constructor that assigns 1 to the degrees
	public Road(Town source, Town destination, String name) {
		townSource = source;
		townDestination = destination;
		townDegrees = 1;
		townName = name;
	}
	/**
	 * Returns true only if the edge contains the given town
	 * @param town
	 */
	public boolean contains(Town town) {
		//variable
		boolean containsTown = false;
		//checks if the town source or town destination equals the given town
		if (townSource.equals(town) || townDestination.equals(town))
			//returns true if equal
			containsTown = true;
		else
			//returns false if not equal
			containsTown = false;
		
		return containsTown;
		
	}
	/**
	 * toString method
	 */
	public String toString() {
		return townName;
	}
	//getters
	public String getName() {
		return townName;
	}
	
	public Town getDestination() {
		return townDestination;
	}
	
	public Town getSource() {
		return townSource;
	}
	/**
	 * 0 if the road names are the same, 
	 * a positive or negative number if the road names are not the same
	 */
	public int compareTo(Road o) {
		//returns -1 given objects road name is larger, returns 0 if equal and returns 1 if road name is greater than given objects
		return townName.compareTo(o.townName);
	}
	
	public int getWeight() {
		return townDegrees;
	}
	/**
	 * Returns true if each of the ends of the road r is 
	 * the same as the ends of this road. Remember that a road that goes from point A to point B is the same as a road that goes from point B to point A.
	 */
	public boolean equals(Object r) {
		//variables
		boolean equalRoads = false;
		Road road = (Road) r;
		//checks if the town source or town destination is equal to the given object and vice versa
		if (townSource.equals(road.townSource) || townSource.equals(road.townDestination))
		if (townDestination.equals(road.townDestination) || townDestination.equals(road.townSource))
				//returns true if equal roads
				equalRoads = true;
			else 
				//returns false if not equal roads
				equalRoads = false;
		
		return equalRoads;

			
	}
}
