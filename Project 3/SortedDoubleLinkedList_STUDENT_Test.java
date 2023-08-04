import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Michael Bushman 
 */


public class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Car> sortedLinkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Car a=new Car("Dodge", "Challenger", 2020);
	public Car b=new Car("Chevy", "Camaro", 2015);
	public Car c=new Car("Honda", "Civic", 2003);
	public Car d=new Car("Subaru", "Outback", 2000);
	public Car e=new Car("Dodge", "Viper", 2016);
	public Car f=new Car("Jeep", "Trackhawk", 2019);
	//alphabetic order: b a e c f d
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorCar = new CarComparator();
		sortedLinkedCar = new SortedDoubleLinkedList<Car>(comparatorCar);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorCar = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedCar = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Bye");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Bye");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(d);
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Bye");
		sortedLinkedString.add("Round");
		sortedLinkedString.add("Hi");
		sortedLinkedString.add("Black");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Black", iterator.next());
		assertEquals("Bye", iterator.next());
		assertEquals("Hi", iterator.next());
		assertEquals("Round", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Round", iterator.previous());
		assertEquals("Hi", iterator.previous());
		assertEquals("Hi", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulCarPrevious() {
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(d);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(d, iterator.previous());
		assertEquals(c, iterator.previous());
		assertEquals(e, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(6));
		sortedLinkedDouble.add(new Double(1));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(1), iterator.next());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(6), iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(10));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		//assertEquals(new Double(10), iterator.previous());
		assertEquals(new Double(8), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(d);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(d);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		assertEquals(b, sortedLinkedCar.getFirst());
		assertEquals(c, sortedLinkedCar.getLast());
		sortedLinkedCar.add(d);
		sortedLinkedCar.add(e);
		assertEquals(b, sortedLinkedCar.getFirst());
		assertEquals(d, sortedLinkedCar.getLast());
		//deletes Elephant from linked list
		assertEquals(d,sortedLinkedCar.retrieveLastElement());
		assertEquals(c, sortedLinkedCar.getLast());
	}

	@Test
	public void testRemoveFirstCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		assertEquals(b, sortedLinkedCar.getFirst());
		assertEquals(c, sortedLinkedCar.getLast());
		sortedLinkedCar.add(a);
		assertEquals(b, sortedLinkedCar.getFirst());
		// remove the first
		sortedLinkedCar.remove(a, comparatorCar);
		assertEquals(b, sortedLinkedCar.getFirst());
	}
	
	@Test
	public void testRemoveEndCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(f);
		assertEquals(b, sortedLinkedCar.getFirst());
		assertEquals(f, sortedLinkedCar.getLast());
		sortedLinkedCar.add(d);
		assertEquals(d, sortedLinkedCar.getLast());
		//remove from the end of the list
		sortedLinkedCar.remove(d, comparatorCar);
		assertEquals(f, sortedLinkedCar.getLast());
	}

	@Test
	public void testRemoveMiddleCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(a);
		assertEquals(b, sortedLinkedCar.getFirst());
		assertEquals(a, sortedLinkedCar.getLast());
		sortedLinkedCar.add(f);
		assertEquals(b, sortedLinkedCar.getFirst());
		assertEquals(f, sortedLinkedCar.getLast());
		assertEquals(3,sortedLinkedCar.getSize());
		//remove from middle of list
		sortedLinkedCar.remove(a, comparatorCar);
		assertEquals(b, sortedLinkedCar.getFirst());
		assertEquals(f, sortedLinkedCar.getLast());
		assertEquals(2,sortedLinkedCar.getSize());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.getMake().compareTo(arg1.getMake());
		}		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}

