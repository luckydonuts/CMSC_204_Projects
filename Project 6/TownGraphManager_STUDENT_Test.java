import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Michael Bushman
 *
 */
public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_One");
		  graph.addRoad(town[1], town[3], 4, "Road_Two");
		  graph.addRoad(town[1], town[5], 6, "Road_Three");
		  graph.addRoad(town[3], town[7], 1, "Road_Four");
		  graph.addRoad(town[3], town[8], 2, "Road_Five");
		  graph.addRoad(town[4], town[8], 3, "Road_Six");
		  graph.addRoad(town[6], town[9], 3, "Road_Seven");
		  graph.addRoad(town[9], town[10], 4, "Road_Eight");
		  graph.addRoad(town[8], town[10], 2, "Road_Nine");
		  graph.addRoad(town[5], town[10], 5, "Road_Ten");
		  graph.addRoad(town[10], town[11], 3, "Road_Eleven");
		  graph.addRoad(town[2], town[11], 6, "Road_Twelve");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_Eight", roads.get(0));
		assertEquals("Road_Eleven", roads.get(1));
		assertEquals("Road_Five", roads.get(2));
		assertEquals("Road_Four", roads.get(3));
		
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_Ten", graph.getRoad(town[5], town[10]));
		assertEquals("Road_One", graph.getRoad(town[1], town[2]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_32"));
		graph.addTown("Town_13");
		assertEquals(true, graph.containsTown("Town_13"));
	}
	
	

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_Eleven", roads.get(1));
		assertEquals("Road_Five", roads.get(2));
		assertEquals("Road_Four", roads.get(3));
	}

	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_11", roads.get(2));
		assertEquals("Town_3", roads.get(4));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[11]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_One to Town_2 2 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road_Twelve to Town_11 6 mi",path.get(1).trim());
	}
	
	
}
