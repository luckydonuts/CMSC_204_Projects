import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Michael Bushman
 *
 */
class Road_STUDENT_Test {
	Town townOne, townTwo;
	Road roadOne, roadTwo, roadThree, roadFour, roadFive;

	@BeforeEach
	void setUp() throws Exception {
		roadOne = new Road(new Town("Rockville"), new Town("Olney"), "Road_One");
		roadTwo = new Road(new Town("North Potomac"), new Town("Olney"), "Road_Two");
		roadThree = new Road(new Town("Gaithersburg"), new Town("Rockville"), "Road_Three");
		roadFour = new Road(new Town("Gaithersburg"), new Town("North Potomac"), "Road_Four");
		roadFive = new Road(new Town("Olney"), new Town("Rockville"),2, "Road_Five");

	}

	@AfterEach
	void tearDown() throws Exception {
		townOne = null;
		townTwo = null;
		roadOne = null;
		roadTwo = null;
		roadThree = null;
		roadFour = null;
		roadFive = null;
	}
	@Test
	void testContains() {
		assertEquals(true, roadOne.contains(new Town("Olney")));
		assertEquals(true, roadTwo.contains(new Town("North Potomac")));
		assertEquals(true, roadThree.contains(new Town("Rockville")));
		assertEquals(true, roadFour.contains(new Town("Gaithersburg")));
	}

	@Test
	void testToString() {
		assertEquals("Road_Four", roadFour.toString());

	}

	@Test
	void testGetName() {
		assertEquals("Road_One", roadOne.getName());
		assertEquals("Road_Two", roadTwo.getName());
		assertEquals("Road_Three", roadThree.getName());
		assertEquals("Road_Four", roadFour.getName());
	}

	@Test
	void testGetDestination() {
		assertEquals("Olney", roadOne.getDestination().getName());
		assertEquals("Olney", roadTwo.getDestination().getName());
		assertEquals("Rockville", roadThree.getDestination().getName());
		assertEquals("North Potomac", roadFour.getDestination().getName());
	}

	@Test
	void testGetSource() {
		assertEquals("Rockville", roadOne.getSource().getName());
		assertEquals("North Potomac", roadTwo.getSource().getName());
		assertEquals("Gaithersburg", roadThree.getSource().getName());
		assertEquals("Gaithersburg", roadFour.getSource().getName());
	}

	@Test
	void testCompareTo() {
		assertNotEquals(0, roadOne.compareTo(roadTwo));
	}

	@Test
	void testGetWeight() {
		assertEquals(2, roadFive.getWeight());
	}

	@Test
	void testEqualsObject() {
		assertEquals(false, roadOne.equals(roadFour));
	}

}
