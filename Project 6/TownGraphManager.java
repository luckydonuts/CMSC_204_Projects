import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
/**
 * Implements TownGraphInterface
 * @author Michael Bushman
 *
 */
public class TownGraphManager implements TownGraphManagerInterface{

	private Graph graph = new Graph();
	@Override
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		// TODO Auto-generated method stub
		//variable
		boolean addedRoad = false;
		//town variables based on given strings
		Town townOne = new Town(town1);
		Town townTwo = new Town(town2);
		//road variable with the given information
		Road newRoad = graph.addEdge(townOne, townTwo, weight, roadName);
		//checks if the graph's edge is not equal to the new added road
		if (graph.getEdge(townOne, townTwo) != newRoad)
			//returns false if not added
			addedRoad = false;
		else
			//returns true if added
			addedRoad = true;
		
		return addedRoad;
	}
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		//variables of the two towns
		Town townOne = new Town(town1);
		Town townTwo = new Town(town2);
		//finds the road based on the given two towns
		Road road = graph.getEdge(townOne, townTwo);
		//returns the road's name
		return road.getName();
	}
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		// TODO Auto-generated method stub
		//variables
		boolean added = false;
		Town addedTown = new Town(v);
		//checks if the see if the given town has been added to the graph
		if (graph.addVertex(addedTown))
			//returns true if added
			added = true;
		else
			//returns false is not
			added = false;
		
		return added;
	}
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		// TODO Auto-generated method stub
		//variable
		Set<Town>graphTowns = graph.vertexSet();
		//for loop that runs through the graph vertexs
		for (Town currentTown : graphTowns) {
			//checks if the current town's name is equal to the given string
			if (currentTown.townName.equals(name))
				//returns that current town
				return currentTown;
		}
		//returns null if not found
		return null;
	}
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		//variables
		boolean containsTown = false;
		Town addedTown = new Town(v);
		//checks if the graph has the given vertex 
		if (graph.containsVertex(addedTown))
			//returns true if it has it in the graph
			containsTown = true;
		else
			//returns false if not in graph
			containsTown = false;
			
		return containsTown;
	}
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		//variables
		boolean containsConnection = false;
		Town townOne = new Town(town1);
		Town townTwo = new Town(town2);
		//checks if the graph has an road based off the given towns
		if (graph.containsEdge(townOne, townTwo))
			//returns true if there is a road between the two towns
			containsConnection = true;
		else
			//returns false if there is not a road between the two towns
			containsConnection = false;
		
		return containsConnection;
	}
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		// TODO Auto-generated method stub
		//variables
		ArrayList<String>listOfRoads = new ArrayList<>();
		//for loop that runs through the road set
		for (Road currentRoad : graph.edgeSet())
			//adds each road to the arraylist
			listOfRoads.add(currentRoad.getName());
		//uses sort method to sort the roads alphabetically
		Collections.sort(listOfRoads);
		//returns the sorted arraylist of all roads
		return listOfRoads;
	}
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		//variables
		boolean deletedRoad = false;
		Town townOne = new Town(town1);
		Town townTwo = new Town(town2);
		//created a new road to be deleted based off the given towns
		Road removedRoad = graph.getEdge(townOne, townTwo);
		//checks if the graph's road is equal to the given road's name
		if (removedRoad.getName().equals(road)) {
			//if so, remove the road from the graph
			graph.removeEdge(townOne, townTwo, removedRoad.getWeight(), road);
			return true;
		}
		return deletedRoad;
	}
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		//variables
		boolean deletedTown = false;
		Town townToDelete = new Town(v);
		//checks if the graph has remvoed the given town
		if (graph.removeVertex(townToDelete))
			//returns true if removed
			deletedTown = true;
		else
			//returns false if not removed
			deletedTown = false;
		
		return deletedTown;
	}
	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		//variables
		ArrayList<String>listOfTowns = new ArrayList<>();
		//for loop that runs through the town set
		for (Town currentTown : graph.vertexSet())
			//added each town's name to the arraylist
			listOfTowns.add(currentTown.townName);
		//uses collections sort method to sort alphabetically
		Collections.sort(listOfTowns);
		//returns the sorted arraylist of all towns
		return listOfTowns;
	}
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		//variables
		Town townOne = new Town(town1);
		Town townTwo = new Town(town2);
		//arraylist that grabs the shortestpath based off the two towns
		ArrayList<String> path = graph.shortestPath(townOne, townTwo);
		//returns that arraylist of information based off the two towns
		return path;
	}

	@Override
	public void populateTownGraph(File file) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		//variables
		Scanner reader = new Scanner(file);
		String currentRoad, weight, townSource, townDestination = "";
		String[] currentline, roadAndMiles = null;
		int intWeight = 0;
		//runs the the file has another line
		while(reader.hasNext()) {
			//divides the current line up into string array based off the ;
			currentline = reader.nextLine().split(";");
			//divides the first element in the current line by the , 
			roadAndMiles = currentline[0].split(",");
			//assigns the current road to be the first element in the roadAndMiles array
			currentRoad = roadAndMiles[0];
			//assigns the weight to be the second element in the roadAndMiles array
			weight = roadAndMiles[1];
			//parses the weight string into an int 
			intWeight = Integer.parseInt(weight);
			//assigns the town source to be the seocnd element in the current line array
			townSource = currentline[1];
			//assigns the town destination to be the third element in the current line array
			townDestination = currentline[2];
			//adds the two towns
			addTown(townSource); addTown(townDestination);
			//adds the new road based off the file information
			addRoad(townSource, townDestination, intWeight, currentRoad);
		}
	}
}
