import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This is a generic double-linked list that implements the Iterable interface
 * @author Michael Bushman
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
	//Class Variables
	protected Node head;
	protected Node tail;
	protected int size;
	
	/**
	 * Constructor that sets the head, tail and size to null, null and 0
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Returns the number of nodes in the list
	 * @return the size of the linked list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds an element to end of the list, updates the size of the list
	 * @param data
	 */
	public void addToEnd(T data) {
		//Variable
		Node newElement = new Node(data);
		//Checks if the head is null (empty list)
		if (head == null) {
			//Assigns the head and tail to the new element since the list is empty
			head = tail = newElement;
		}
		else {
			//Updates the newly added element's previous to the tail
			newElement.prev = tail;
			//Updates the newly added element's next to null
			newElement.next = null;
			//Updates the tail's next to be the new added element
			tail.next = newElement;
			//Sets the tail to the new added element
			tail = newElement;
		}
		//Increases the list size by 1
		size++;
	}
	
	/**
	 * Adds an element to the front of list, updates the size of the list
	 * @param data
	 */
	public void addToFront(T data) {
		//Variable
		Node newElement = new Node(data);
		//Checks if the head is null (empty list)
		if (head == null) {
			//Assigns the head and tail to the newly added element since the list is empty
			head = tail = newElement;
		}
		else {
			//Updates the newly added element's next to be the head
			newElement.next = head;
			//Updates the newly added element's previous to null
			newElement.prev = null;
			//Updates the head's previous to be the new added element
			head.prev = newElement;
			//Sets the head to be the new added element
			head = newElement;
		}
		//Increases the list size
		size++;
	}
	
	/**
	 * Returns first element from the list, does not remove it
	 * @return data element or null
	 */
	public T getFirst() {
		//Checks if the list size is 0. If so, return null
		if (size == 0)
			return null;
		else 
			//Returns the head of the list
			return head.data;
		
	}
	
	/**
	 * Returns last element from the list, does not remove it
	 * @return data element or null
	 */
	public T getLast() {
		//Checks if the list size is 0. If so, return null
		if (size == 0)
			return null;
		else 
			//Returns the tail of the list
			return tail.data;
	}
	
	/**
	 * Returns an object of the DoubleLinkedListIterator
	 */
	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * Removes the first instance of the targetData from the list
	 * @param targetData
	 * @param comparator
	 * @return a node containing the targetData or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		//Variable
		Node startingElement = head;
		//Runs while list is not empty
		while (startingElement != null) {
			//Checks if the two objects are equal to each other 
			if (comparator.compare(targetData, startingElement.data) == 0) {
				//Checks if the startingElement is equal to the head of the list
				if (startingElement == head) {
					//Updates the head to the next position
					head = head.next;
				}
				//Checks if the startingElement equals the tail
				else if (startingElement == tail) {
					//Updates the tail to the previous position
					tail = tail.prev;
				}
				else {
					//Assigns the startingElement's previous next position (itself) to be the startingElement's next position
					startingElement.prev.next = startingElement.next;
				}
				//Decreases the list size by 1, removing the element
				size--;
			}
			//Advances the startingElement cursor forward
			startingElement = startingElement.next;
		}
		//Returns the reference of the removed element  
		return this;
	}
	
	/**
	 * Removes and returns the first element from the list
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		//Variable
		T firstElement = head.data;
		//Checks if the list size is empty. If so, return null
		if (size == 0)
			return null;
		//Checks if the list size is 1. If so, head and tail are now null
		if (size == 1) {
			head = tail = null;
		}
		else {
			//Updates the head's previous to be null
			head.prev = null;
			//Updates the head to point to the head's next
			head = head.next;
		}
		//Decreases list size by 1 and returns the first element
		size--;
		return firstElement;
	}
	
	/**
	 * Removes and returns the last element from the list
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		//Variable
		T lastElement = tail.data;
		//Checks if the list size is empty. If so, return null
		if (size == 0)
			return null;
		//Checks if the list size is 1. If so, set head and tail are null
		if (size == 1) {
			head = tail = null;
		}
		else {
			//Updates the tail's next to be null
			tail.next = null;
			//Updates the tail to point to the tail's previous
			tail = tail.prev;
		}
		//Decreases the list size by 1 and returns the last element
		size--;
		return lastElement;
	}
	
	/**
	 * Returns an arraylist of all the items in the list
	 * @return an arraylist of items in the list
	 */
	public ArrayList<T> toArrayList() {
		//Variables
		ArrayList<T> arrayList = new ArrayList<>();
		Node startingElement = head;
		//Runs while the startingElement is not null
		while (startingElement != null) {
			//Adds each of the elements to the arrayList
			arrayList.add(startingElement.data);
			//Advances the startingElement cursor forward
			startingElement = startingElement.next;
		}
		//Returns the arraylist of the list
		return arrayList;
	}
	
	public class Node {
		//Inner Class Variables
		protected T data;
		protected Node prev;
		protected Node next;
		/**
		 * Constructor
		 * @param dataNode
		 */
		public Node(T dataNode) {
			data = dataNode;
			prev = null;
			next = null;
		}
	}
	
	public class DoubleLinkedListIterator implements ListIterator<T>{
		//Inner Class Variables
		protected Node nextElement;
		protected Node previousElement;
		
		/**
		 * Constructor to that sets the pointer to the head
		 */
		public DoubleLinkedListIterator() {
			nextElement = head;
			previousElement = null;
		}
		
		/**
		 * Returns true if this list iterator has more elements when 
		 * going the list in the forward direction
		 */
		public boolean hasNext() {
			return nextElement != null;
		}
		
		/**
		 * Returns the next element in the list, advances the cursor position
		 */
		public T next() throws NoSuchElementException {
			//Variable
			T next;
			//Checks if the list has more elements in the forward direction
			if (hasNext()) {
				//Sets the reference object to the next element
				next = nextElement.data;
				//Updates the previous element to be the next element
				previousElement = nextElement;
				//Moves the cursor position forward
				nextElement = nextElement.next;
				//Returns the next element in the list
				return next;
			}
			else 
				throw new NoSuchElementException();
		}

		@Override
		/**
		 * Returns true if this list iterator has more elements when 
		 * going the list in the reverse direction
		 */
		public boolean hasPrevious() {
			return previousElement != null;
		}

		@Override
		/**
		 * Returns the previous element in the list, moves the cursor position backwards
		 * @returns previousElement
		 */
		public T previous() throws NoSuchElementException {
			//Variable
			T previous;
			//Checks if the list has more elements in the reverse direction
			if (hasPrevious()) {
				//Sets the reference object to the previous element
				previous = previousElement.data;
				//Updates the next element to the previous element
				nextElement = previousElement;
				//Moves the cursor position backwards 
				previousElement = previousElement.prev;
				//Returns the previous element in the list
				return previous;
			}
			else
				throw new NoSuchElementException();
		}
		
		@Override
		/**
		 * Throws UnsupportedOperationException
		 */
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		@Override
		/**
		 * Throws UnsupportedOperationException
		 */
		public void add(T arg0) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}	

		@Override
		/**
		 * Throws UnsupportedOperationException
		 */
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		/**
		 * Throws UnsupportedOperationException
		 */
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		@Override
		/**
		 * Throws UnsupportedOperationException
		 */
		public void set(T arg0) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
	}
}
