import java.util.ArrayList;
/**
 * Queue data structure
 * @author Michael Bushman
 */
public class MyQueue<T> implements QueueInterface<T>{
	//Variables
	private int frontElement;
	private int lastElement;
	private int elements;
	private int queueCapacity;
	private ArrayList<T>queueList;
	
	@SuppressWarnings("unchecked")
	/**
	 * Constructor that takes in an int for the size of the queue
	 * @param size
	 */
	public MyQueue(int size) {
		queueCapacity = size;
		queueList = new ArrayList<T>(queueCapacity);
		frontElement = 0;
		lastElement = 0;
	}
	/**
	 * Default constructor
	 */
	public MyQueue() {
		queueCapacity = 50;
		elements = 0;
		frontElement = 0;
		lastElement = 0;
	}
	
	@Override
	/**
	 * Checks if the queue is empty
	 */
	public boolean isEmpty() {
		//Checks if the current queue count is empty
		if (elements == 0)
				return true;
		else
			return false;
	}

	@Override
	/**
	 * Checks if the queue is full
	 */
	public boolean isFull() {
		//Checks if the current queue count is equal to the queue capacity
		if (elements == queueCapacity)
			return true;
		else
			return false;
	}

	@Override
	/**
	 * Deletes and returns the element at the front of the queue
	 */
	public T dequeue() throws QueueUnderflowException {
		//Variable
		T deqElement;
		//Checks if the queue is empty
		if (isEmpty())
			throw new QueueUnderflowException();
		else 
		{
			//Grabs the element at the front of the queue
			deqElement = queueList.get(frontElement);
			//Increases the front of the queue
			frontElement++;
			//Deletes the element from the queue
			elements--;
		}
		//Returns the element at the front of the queue
		return deqElement;
	}

	@Override
	/**
	 * Returns the number of elements in the queue
	 */
	public int size() {
		return elements;
	}

	@Override
	/**
	 * Adds an element to the end of a queue
	 * @param e
	 */
	public boolean enqueue(T e) throws QueueOverflowException {
		//Checks if the queue is full
		if (isFull())
			throw new QueueOverflowException();
		else {
			//Adds the given element to the end of the queue
			queueList.add(lastElement, e);
			//Increases the end of queue
			lastElement++;
			//Increases the number of elements in the queue
			elements++;
		}
		return true;
	}
	/**
	 * Returns a string of all elements in the queue
	 */
	public String toString() {
		//Variable
		String string = "";
		//Loop that runs through the queue
		for (int i = 0; i < queueList.size(); i++) {
			//Adds each elements in the queue to the string
			string += queueList.get(i);
		}
		return string;
	}

	@Override
	/**
	 * Returns a string of all elements in the queue with a delimiter in between them
	 * @param delimiter
	 */
	public String toString(String delimiter) {
		//Variable
		String string = "";
		//Loop that runs through the queue 
		for (int i = 0; i < queueList.size(); i++) {
			//Checks if the queue size is not the last one in the queue
			if (i != queueList.size()-1)
				//Adds each element plus the delimiter to the string
				string += queueList.get(i) + delimiter;
			else 
				//Adds the last element to the string
				string += queueList.get(i);
		}
		return string;
	}

	@Override
	/**
	 * Fills the queue based on a given ArrayList
	 * @param list
	 */
	public void fill(ArrayList<T> list) {
		//Creates a copy ArrayList to avoid security breech
		ArrayList<T>copyQueue = new ArrayList<T>(list);
		//Adds all of the elements from the given ArrayList to the queue
		queueList.addAll(copyQueue);
		//Updates the number of elements in the queue based on the ArrayList's size
		elements = queueList.size();
	}
}
