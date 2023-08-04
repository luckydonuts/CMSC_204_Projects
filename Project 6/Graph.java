import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * The root interface in the graph hierarchy. A mathematical graph-theory graph
 * object G(V,E) contains a set V of vertices and a set
 * E of edges. Each edge e=(v1,v2) in E connects vertex v1 to vertex v2.
 *
 * Through generics, a graph can be typed to specific classes for vertices
 * V and edges E<T>. Such a graph can contain
 * vertices of type V and all sub-types and Edges of type
 * E and all sub-types.
 * @author Michael Bushman
 */
public class Graph implements GraphInterface <Town,Road>{
	//class variables
	Set<Town>towns = new HashSet<Town>();
	Set<Road>roads = new HashSet<Road>();
	Map <String, Town> previous = new HashMap<>();
	ArrayList<Town> unvisitedTowns = new ArrayList<>(); 
	HashMap<String, Integer> miles = new HashMap<>(); 
	 /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		//checks if the given source vertex or destination vertex is null
		if (sourceVertex == null || destinationVertex == null)
			//if so, return null
			return null;
		else {
			//runs through the roads set
			for (Road currentRoad : roads) {
				//checks if the current road's destination or source is equal to the given source vertex or destination and vice versa
				if (currentRoad.townDestination.equals(sourceVertex) || currentRoad.townDestination.equals(destinationVertex))
				if (currentRoad.townSource.equals(sourceVertex) || currentRoad.townSource.equals(destinationVertex))
					//returns the matching road
					return currentRoad;
			}
		}
		//returns null if not found
		return null;
	}
	/**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		//variable
		Road addedRoad = new Road(sourceVertex, destinationVertex, weight, description);
		//checks if the given towns are not in the towns set, throws IllegalArgumentException
		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
			throw new IllegalArgumentException();
		
		//checks if the given towns are null, throws NullPointerException
		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();
		
		//adds the given road to the road set
		roads.add(addedRoad);
		
		//checks if the new road has been added 
		if (!containsEdge(sourceVertex, destinationVertex))
			//if not added, return null
			return null;
		else
			//if added, return the new road
			return addedRoad;
	}
	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		// TODO Auto-generated method stub
		//variable
		boolean addedTown = false;
		//checks if the given town is null, throws NullPointerException
		if (v == null)
			throw new NullPointerException();
		//checks if the given town is in the town set
		else if (containsVertex(v)) 
			//returns false since not added
			return addedTown;
		else {
			//adds the given town to the set
			towns.add(v);
			//returns true since it was added
			addedTown = true;
			}
		return addedTown;
	}
	/**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		//variable
		boolean containsRoad = false;
		//checks if the given source or destination vertex is null
		if (sourceVertex == null || destinationVertex == null)
			//returns false
			return false;
		//runs through the road set
		for (Road currentRoad : roads) {
			//checks if the current road's source is equal to the vertex or if the current road's destination is equal to the given vertex
			if (currentRoad.townSource.equals(sourceVertex) || currentRoad.townSource.equals(destinationVertex) || currentRoad.townDestination.equals(sourceVertex) || currentRoad.townDestination.equals(destinationVertex))
				//returns true if the found
				containsRoad = true;
				break;
		}
		return containsRoad;
	}
	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		// TODO Auto-generated method stub
		//variable
		boolean containsTown = false;
		//runs through the town set
		for (Town currentTown: towns) {
			//checks if the current town is equal to the given town
			if (currentTown.equals(v)) {
				//returns true if equal towns
				containsTown = true;
				break;
			}
		}
		//returns false if vertex is not found
		return containsTown;
	}
	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return roads;
	}
	/**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		//variable
		Set<Road>touchingEdges = new HashSet<>();
		//checks if the given town is in the town set
		if (!containsVertex(vertex))
			//if not in the set, throw IllegalArgumentException
			throw new IllegalArgumentException();
		//if the given town is null, throw NullPointerException
		if (vertex == null)
			throw new NullPointerException();
		//runs through the road set
		for (Road currentRoad : roads) {
			//checks if the current road's source is equal to the vertex or if the current road's destination is equal to the given vertex
			if (currentRoad.getSource().equals(vertex) || currentRoad.getDestination().equals(vertex))
				//if so, adds the road to the set
				touchingEdges.add(currentRoad);
		}
		return touchingEdges;
		
	}
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		//variable
		Road removedRoad = new Road(sourceVertex,destinationVertex, weight, description);
		//checks if the source vertex or destination vertex is in the town set
		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
			//if not, returns null
			return null;
		else {
			//runs through the road set
			for (Road currentRoad : roads) {
				//checks if the current road is equal to the given road
				if (currentRoad.equals(removedRoad)) {
					//removes the given road from the roads set
					roads.remove(removedRoad);
					break;
				}
			}
		}
		return removedRoad;
	}
	/**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		//variable
		boolean removedTown = false;
		//checks to see if the vertex is in the town set
		if (!containsVertex(v))
			//if not in the set, return false
			removedTown = false;
		else {
			//for loop that runs through the towns set
			for (Town currentTown : towns) {
				//checks if the current town is equal to the given town
				if (currentTown.equals(v)) {
					//for loop that runs through the edges of that current town
					for (Road currentRoad : edgesOf(currentTown)) {
						//removes the roads associated with the given road
						roads.remove(currentRoad);
					//removes the town associated with the given town
					towns.remove(currentTown);
					//returns true that the vertex was removed
					removedTown = true;
					break;
					}
				}
			}
		}
		return removedTown;
	}
	/**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return towns;
	}
	/**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */   
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		//calls dijkstraShortestPath method to fill the Map previous of each Town
		dijkstraShortestPath(sourceVertex);
		//variables
		ArrayList<String> shortestPath = new ArrayList<String>();
		Town nextTown = destinationVertex;
		Town previousTown;
		Road road;
		//runs while the destination town doesn't equal the source vertex
		while (!nextTown.equals(sourceVertex)) {
			//assigns the previous town of the given destinationTown
			previousTown = previous.get(nextTown.townName);
			//checks if the town doesn't have any roads
			if (previousTown == null)
				//returns the arraylist
				return shortestPath;
			//gets the roads using given two towns
			road = getEdge(previousTown, nextTown);
			//adds previous town and next town's information along with via, to and the miles as instructed
			shortestPath.add(0, previousTown.townName + " via " + road.getName() + " to " + nextTown.townName + " " + road.townDegrees + " mi");
			//assigns the nextTown to the previous town to continue the while loop
			nextTown = previousTown;
		}
		//returns the arrayList
		return shortestPath;
	}
	
	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		//variables
		Town adjacentTown = null;
		Town shortestTown = null;
		int smallestWeight = 0;
		int adjacentMiles = 0;
		int MAX = Integer.MAX_VALUE;
		
		//runs through the towns set
		for (Town currentTown : towns) {
			//sets previous vertices from current town to null
			previous.put(currentTown.townName, null);
			//sets the current town and to all other vertices weight to the max (infinity)
			miles.put(currentTown.townName, MAX);
			//adds the all towns to the unvisited arraylist
			unvisitedTowns.add(currentTown);
		}
		//sets the weight of sourcevertex to 0
		miles.put(sourceVertex.townName, 0);
		//runs while the unvistied arraylist is not empty
		while (unvisitedTowns.size() != 0) {
			//sets the shortest vertex index to 0
			smallestWeight = 0; 
			//runs through the unvisited town arraylist
			for (int i = 0; i < unvisitedTowns.size(); i++) {
				//grabs each town of the unvisited towns arraylist
				Town unvisitedSource = unvisitedTowns.get(i);
				//checks each town's weight is less than the first town's weight
				if (miles.get(unvisitedSource.townName) < miles.get(unvisitedTowns.get(smallestWeight).townName))
					//stores index of smallest distance
					smallestWeight = i;
			}
			//removes the smallest vertex by the smallest index
			shortestTown = unvisitedTowns.remove(smallestWeight);
			//runs through the edges of the town
			for (Road currentRoad : edgesOf(shortestTown)) {				
				//sets the adjacent town vertex by town destination
				adjacentTown = currentRoad.townDestination;
				//checks if the adjacent town is equal to closest town to account for swapped source/destination
				if (adjacentTown.equals(shortestTown))
					//sets the adjacent town vertex by town source
					adjacentTown = currentRoad.townSource;
				//sets the adjacent miles to the current vertex plus the current road's weight
				adjacentMiles = miles.get(shortestTown.townName) + currentRoad.townDegrees;
				//checks if the known weight is greater than weight of recently calculated weight
				if (miles.get(adjacentTown.townName) > adjacentMiles) {
					//links adjacent town with previous town
					previous.put(adjacentTown.townName, shortestTown);
					//inserts the new weight to the adjacent town
					miles.put(adjacentTown.townName, adjacentMiles);
				}
			}
		}
	}
}
