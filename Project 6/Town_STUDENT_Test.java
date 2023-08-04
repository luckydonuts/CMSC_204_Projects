import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Michael Bushman
 *
 */
class Town_STUDENT_Test {

	Town one, two, three, four;
	
	@BeforeEach
	void setUp() throws Exception {
		one = new Town("Olney");
		two = new Town("North Potomac");
		three = new Town("Gaithersburg");
		four = new Town("Bethesda");
	}

	@AfterEach
	void tearDown() throws Exception {
		one = null;
		two = null;
		three = null;
		four = null;
	}

	@Test
	void testGetName() {
		assertEquals("Olney", one.getName());
		assertEquals("North Potomac", two.getName());
		assertEquals("Gaithersburg", three.getName());
		assertEquals("Bethesda", four.getName());
	}

	@Test
	void testCompareTo() {
		assertNotEquals(0, one.compareTo(two));
	}

	@Test
	void testToString() {
		assertEquals("Olney", one.toString() );
		assertEquals("North Potomac", two.toString() );
		assertEquals("Gaithersburg", three.toString() );
		assertEquals("Bethesda", four.toString() );
	}

	@Test
	void testEqualsObject() {
		assertNotEquals(true, one.equals(two));
		assertNotEquals(true, two.equals(three));
		assertNotEquals(true, three.equals(four));
		assertNotEquals(true, one.equals(four));
	}
	
	@Test
	void testHashCode() {

		assertEquals(76284549, one.hashCode() );
	}

}
