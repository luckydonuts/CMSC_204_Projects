import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael Bushman
 * 
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataManager = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataManager = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataManager = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataManager.add("CMSC203",30504,4,"SC450","Joey D");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataManager.add("CMSC203",30501,4,"SC450","Joey D");
		dataManager.add("CMSC203",30502,4,"SC450","Jill B. Who-Dunit");
		dataManager.add("CMSC204",30550,4,"SC450","BillyBob");
		ArrayList<String> list = dataManager.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC203 CRN:30501 Credits:4 Instructor:Joey D Room:SC450");
	 	assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30502 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:30550 Credits:4 Instructor:BillyBob Room:SC450");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30502 4 SC450 Joey D");
			inFile.print("CMSC204 30503 4 SC410 Bill B. Who-Dunit");
			
			inFile.close();
			dataManager.readFile(inputFile);
			assertEquals("CMSC203",dataManager.get(30502).getID());
			assertEquals("CMSC204",dataManager.get(30503).getID());
			assertEquals("SC410",dataManager.get(30503).getRoomNum());
		} 
		catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}