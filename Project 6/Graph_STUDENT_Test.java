import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Michael Bushman
 *
 */
public class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		  town = new Town[4];
		  
		  for (int i = 0; i < 4; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 6, "Road_3");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[1], town[2],6, "Road_3"), graph.getEdge(town[1], town[2]));
	}

}
