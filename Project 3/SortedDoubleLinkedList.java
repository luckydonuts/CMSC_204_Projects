import java.util.Comparator;
import java.util.ListIterator;
/**
 * A generic sorted double list using a provided Comparator, extends BasicDoubleLinkedList class
 * @author Michael Bushman
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	//Class variable
	private Comparator<T> cpt;
	/**
	 * Creates an empty list with the specified comparator.
	 * @param compareableObject
	 */
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		cpt = compareableObject;
	}
	/**
	 * Inserts the specified element at the correct position in the sorted list
	 * @param data
	 * @return reference at each given situation
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		//Variables
		Node newElement = new Node(data);
		Node currentElement = head;
		//Checks if the head is null (empty list)
		if (head == null) {
			//Assigns the head and the tail of the list to the new element and increases the list size by 1
			head = tail = newElement;
			size++;
			//Returns the reference
			return this;
		}
		//Checks to see if the element should be added before the head
		if (cpt.compare(head.data, data) > 0) {
			//Sets the head's previous to the new head, the new element
			head.prev = newElement;
			//Sets the new element's next to the current head
			newElement.next = head;
			//Sets the new element's previous to null
			newElement.prev = null;
			//Sets the head as the new element and increases the list size by 1
			head = newElement;
			size++;
			//Returns the reference
			return this;
		}
		//Checks to see if the element should be added after the tail or between head and tail
		else {
			//Compares while the current element is less than the new element
			while (cpt.compare(currentElement.data, data) < 0) {
				//Checks if the current element is null to then add after the tail
				if (currentElement.next == null) {
					//Sets the new element's previous to the current element in the list
					newElement.prev = currentElement;
					//Sets the new element's next to null
					newElement.next = null;
					//Sets the current element's next to the new element 
					currentElement.next = newElement;
					//Sets the tail as the new element and increase the list size by 1
					tail = newElement;
					size++;
					//Returns the reference
					return this;
				}
				else
					//Advances the currentElement cursor forward
					currentElement = currentElement.next;
			}
			//Adds between the head and tail of the list
			//Updates the element's previous's next (itself) to be the new element
			currentElement.prev.next = newElement;
			//Sets the current element's previous to the new element
			currentElement.prev = newElement;
			//Sets the new element's previous to the current element's previous
			newElement.prev = currentElement.prev;
			//Sets the new element's next to the current element
			newElement.next = currentElement;
			//Increase the list size by 1
			size++;
			//Returns the reference
			return this;
		}
	}
	/**
	 * Throws UnsupportedOperationException("Invalid operation for sorted list")
	 */
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * Throws UnsupportedOperationException("Invalid operation for sorted list")
	 */
	public void addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * Calls the super class iterator method
	 * @return an iterator positioned at the head of the list
	 */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	/**
	 * Calls the super class remove method
	 * @return a node containing the data or null
	 */
	public BasicDoubleLinkedList<T> remove(T data, Comparator<T> comparator){
		return super.remove(data, comparator);
	}
}
