import java.util.ArrayList;
/**
 * Stack data structure
 * @author Michael Bushman
 */
public class MyStack<T> implements StackInterface<T>{
	//Variables
	private int elements;
	private int stackCapacity;
	private ArrayList<T>stackList;
	/**
	 * Constructor that takes in an int as the size of the queue
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		stackCapacity = size;
		elements = 0;
		stackList = new ArrayList<T>(stackCapacity);
	}
	
	/**
	 * Default constructor 
	 */
	public MyStack() {
		stackCapacity = 50;
		elements = 0;
		stackList = new ArrayList<T>(stackCapacity);
	}
	
	@Override
	/**
	 * Checks if the stack is empty
	 */
	public boolean isEmpty() {
		//Checks if the current stack count is empty
		if (elements == 0)
			return true;
		else
			return false;	
	}

	@Override
	/**
	 * Checks if the stack is full
	 */
	public boolean isFull() {
		//Checks if the current stack count is equal to the stack capacity
		if (elements == stackCapacity)
			return true;
		else
			return false;
	}

	@Override
	/**
	 * Deletes and returns the element at the top of the stack
	 */
	public T pop() throws StackUnderflowException {
		//Variable
		T popElement;
		//Checks if the stack is empty
		if (isEmpty())
			throw new StackUnderflowException();
		else {
			//Assigns the element at the top of the stack to popElement
			popElement = stackList.get(elements-1); 
			//Deletes the element from the stack
			stackList.remove(elements-1);
			//Decreases the element count
			elements--; 
		}
		//Returns the popped element
		return popElement;
	}
	
	@Override
	/**
	 * Returns the element at the top of the stack
	 */
	public T top() throws StackUnderflowException {
		T topElement;
		//Checks if the stack is empty
		if (isEmpty())
			throw new StackUnderflowException();
		else {
			//Assigns the element at the top of the stack to topElement
			topElement = stackList.get(elements-1);
		}
		//Returns the top element
		return topElement;
	}

	@Override
	/**
	 * Returns the number of elements in the stack
	 */
	public int size() {
		return elements;
	}

	@Override
	/**
	 * Adds an element to the top of the stack
	 * @param e
	 */
	public boolean push(T e) throws StackOverflowException {
		//Checks if the stack is full
		if (isFull())
			throw new StackOverflowException();
		else {
			//Adds the elements to the stack 
			stackList.add(e);
			//Increases the number of elements
			elements++;
		}
		return true;
	}
	/**
	 * Returns a string of the elements in the stack
	 */
	public String toString() {
		//Variable
		String toString = "";
		//Loop that runs through the stack 
		for (int i = 0; i < stackList.size(); i++) {
			//Adds each element in the stack to the string
			toString += stackList.get(i);
		}
		return toString;
	}

	@Override
	/**
	 * Returns a string of the elements in the stack with the delimiter in between 
	 * @param delimiter
	 */
	public String toString(String delimiter) {
		//Variable
		String string = "";
		//Loop that runs through the stack
		for (int i = 0; i < stackList.size(); i++) {
			//Checks if the stack size is not the last one in the stack
			if (i != stackList.size()-1)
				//Adds the element plus the delimiter to the string
				string += stackList.get(i) + delimiter;
			else 
				//Adds the last element to the string
				string += stackList.get(i);
		}
		return string;
	}

	@Override
	/**
	 * Fills a stack with elements based on a given ArrayList
	 * @param list
	 */
	public void fill(ArrayList<T> list) {
		//Creates a copy ArrayList to avoid security breech
		ArrayList<T>copyQueue = new ArrayList<T>(list);
		//Adds all the elements in the ArrayList list to the stack
		stackList.addAll(copyQueue);
		//Updates the number of elements based on the given ArrayList size
		elements = stackList.size();
	}
}
