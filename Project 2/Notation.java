/**
 * Class that converts infix expressions into postfix, postfix to infix
 * and evaluates the postfix expression
 * @author Michael Bushman
 */
public class Notation {
	//Class variables
	private static MyStack<String> myStack;
	private static MyQueue<String> myQueue;
	
	/**
	 * Converts postfix expression to an infix expression
	 * @param postfix
	 * @return converted postfix to infix string
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix)throws InvalidNotationFormatException {
		//Variables
		MyStack<String>convertedStack = new MyStack<String>(50);
		char currentCharacter;
		String secondTop;
		String firstTop;
		String topTwoInStack;
		//Try
		try {
			//Loop that runs through the each character of postfix
			for (int i = 0; i < postfix.length(); i++) {
				//Variable
				currentCharacter = postfix.charAt(i);
				//Checks if current character is a space
				if (currentCharacter == ' ')
					continue;
				//Checks if current character is operand
				if (Character.isDigit(currentCharacter))
					//Pushes current character on to stack
					convertedStack.push(String.valueOf(currentCharacter));
				//Checks if current character is an operator
				if (currentCharacter == '*' || currentCharacter == '/' || currentCharacter == '%' || currentCharacter== '+' || currentCharacter == '-') {
					//Checks if there is less than two values in stack
					if (convertedStack.size() < 2)
						throw new InvalidNotationFormatException();
					else {
						//Pops the top 2 values and creates a string encapsulating them within parenthesis
						firstTop = convertedStack.pop();
						secondTop = convertedStack.pop();
						topTwoInStack = "(" + secondTop + currentCharacter + firstTop +")";
						//Pushes the resulting string back to the stack
						convertedStack.push(topTwoInStack);
					}
				}
			}
			//Once read, checks if the stack has more than one value
			if (convertedStack.size() > 1)
				throw new InvalidNotationFormatException();
		}
		//Catch
		catch(StackUnderflowException error) {
			error.printStackTrace();
		}
		
		catch(StackOverflowException error) {
			error.printStackTrace();
		}
		//Returns the converted postfix to infix stack in string form 
		return convertedStack.toString();
	}
	
	/**
	 * Converts a infix expression to a postfix expression
	 * @param infix
	 * @returns converted infix to postfix string
	 * @throws InvalidNotationFormatException
	 */
	@SuppressWarnings("null")
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		//Variables
		MyStack<String>convertedStack = new MyStack<String>(50);
		MyQueue<String>convertedQueue = new MyQueue<String>(50);
		char currentCharacter;
		//Try
		try {
			//Loop that runs through each character of infix
			for (int i = 0; i < infix.length(); i++) { 
				//Variable
				currentCharacter = infix.charAt(i);
				//Checks if current character is a space
				if (currentCharacter == ' ')
					continue;
				//Checks if current character is a digit. Copies it to the queue
				if (Character.isDigit(currentCharacter))
					convertedQueue.enqueue(String.valueOf(currentCharacter));
				//Checks if current character is a left parenthesis. Pushes it onto the stack
				if (currentCharacter == '(')
					convertedStack.push(String.valueOf(currentCharacter));
				//Checks if current character is a multiplication, division or modulo sign (the higher precedences) 
				if (currentCharacter == '*' || currentCharacter == '/' || convertedStack.top().equals("%")) {
					//Checks if stack is not empty
					if (!convertedStack.isEmpty()) {
						//Checks if current character has equal or higher precedence
						while (convertedStack.top().equals("*") || convertedStack.top().equals("/") || convertedStack.top().equals("%") || convertedStack.top().equals("+") || convertedStack.top().equals("-")) {
							//Pops operators to the queue
							convertedQueue.enqueue(convertedStack.pop());
						}
					}
					//Pushes the current character of infix to the stack
					convertedStack.push(String.valueOf(currentCharacter));
				}
				
				//Checks if current character is a plus or minus sign (the lower precedences)
				if (currentCharacter == '+' || currentCharacter == '-') {
					//Checks if stack is not empty
					if (!convertedStack.isEmpty()) {
						//Checks if current character has equal or higher precedence
						while (convertedStack.top().equals("+") || convertedStack.top().equals("-")) {
							//Pops operators to the queue
							convertedQueue.enqueue(convertedStack.pop());
						}
					}
					//Pushes the current character of to the stack
					convertedStack.push(String.valueOf(currentCharacter));
				}
				
				//Checks if current character is a right parenthesis 
				if (currentCharacter ==')') {
					//Checks if stack is not empty and top of the stack isn't a left parenthesis 
					while (!convertedStack.isEmpty() && !convertedStack.top().equals("(")) {
						//Pops operators to the queue
						convertedQueue.enqueue(convertedStack.pop());
					}
					//Checks if the stack is empty and top of the stack isn't a left parenthesis
					if (convertedStack.isEmpty() || !convertedStack.top().equals("(")) {
						throw new InvalidNotationFormatException();
					}
					//Checks if stack is not empty and the top of the stack is a left parenthesis
					if (!convertedStack.isEmpty() && convertedStack.top().equals("(")) {
						//Pops and discards the left parenthesis from the stack
						convertedStack.pop();
					}
				}
			}
			//Once read, checks if the stack is not empty and top of the stack is not a left parenthesis
			while (!convertedStack.isEmpty() && !convertedStack.top().equals("(")) {
				//Pops remaining operators into queue
				convertedQueue.enqueue(convertedStack.pop());
			}
		}
		//Catch
		catch(StackUnderflowException error) {
			error.printStackTrace();
		}
		
		catch(StackOverflowException error) {
			error.printStackTrace();
		}
		catch (QueueOverflowException error) {
			error.printStackTrace();
		}
		//Returns the converted infix to postfix queue in string form 
		return convertedQueue.toString();
	}
	
	/**
	 * Evaluates a postfix expression and returns the calculation as a double
	 * @param postfixExpr
	 * @return evaluated postfix expression in double form
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		//Variables
		MyStack<String>convertedStack = new MyStack<String>(50);
		char currentCharacter;
		String firstNumber;
		String secondNumber;
		double answer = 0;
		//Try
		try {
			//Loop that runs through the each character of postfix expression
			for (int i = 0; i < postfixExpr.length(); i++) {
				//Variable
				currentCharacter = postfixExpr.charAt(i);
				//Checks if current character is a space
				if (currentCharacter == ' ')
					continue;
				//Checks if current character is operand
				if (Character.isDigit(currentCharacter) || currentCharacter == '(')
					//Pushes current character on to stack
					convertedStack.push(String.valueOf(currentCharacter));
				//Checks if current character is a operator
				if (currentCharacter == '*' || currentCharacter == '/' || currentCharacter == '%' || currentCharacter== '+' || currentCharacter == '-') {
					//Checks if stack has less than two values
					if (convertedStack.size() < 2)
						throw new InvalidNotationFormatException();
					
					else {
						//Pops the first value to be on the right side of the operator
						secondNumber = convertedStack.pop();
						//Pops the second value to the left side of the operator
						firstNumber = convertedStack.pop();
						//Pushes the left and right values along with the current operator to the arithmeticCalculation method
						answer = arithmeticCalculation(firstNumber, secondNumber, currentCharacter);
						//Pushes the arithmetic answer in string form to the stack
						convertedStack.push(Double.toString(answer));
					}
				}
			}
		}
		//Catch
		catch(StackUnderflowException error) {
			error.printStackTrace();
		}
		
		catch(StackOverflowException error) {
			error.printStackTrace();
		}
		//Checks if there is more than value in the stack, throw an error
		if (convertedStack.size() > 1)
			throw new InvalidNotationFormatException();
		else
			return answer;
	}
	
	/**
	 * Calculates arithmetic expression based on given two numbers and operator
	 * @param firstNumber
	 * @param secondNumber
	 * @param operator
	 * @return arithmetic calculation
	 * @throws InvalidNotationFormatException
	 */
	@SuppressWarnings("unused")
	private static double arithmeticCalculation(String firstNumber, String secondNumber, char operator) throws InvalidNotationFormatException {
		//Variables
		double answer = 0;
		//Testing variables for double digits
		char [] firstNum;
		char [] seocndNum;
		double first = Double.parseDouble(firstNumber);
		double second = Double.parseDouble(secondNumber);
		
		//Checks if operator is a multiplication sign
		if (operator == '*') {
			answer = first * second;
		}
		//Checks if operator is a division sign
		else if (operator == '/') {
			answer = first / second;
		}
		//Checks if operator is a modulo sign
		else if (operator == '%') {
			answer = first % second;
		}
		//Checks if operator is a plus sign
		else if (operator == '+') {
			answer = first + second;
		}
		//Checks if operator is a minus sign
		else if (operator == '-') {
			answer = first - second;
		}	
		//If operator isn't a */%+-, throws InvalidNotationFormatException
		else 
			throw new InvalidNotationFormatException();
		//Returns arithmetic calculation 
		return answer;
	}
}
