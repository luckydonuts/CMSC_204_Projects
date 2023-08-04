import java.util.ArrayList;
/**
 * 
 * @author Michael Bushman
 *
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english
 * It relies on a root (reference to root of the tree)
 * The root is set to null when the tree is empty.
 * The class uses an external generic TreeNode class which consists of a reference to the data and a reference to the left and right child. 
 * The TreeNode is parameterized as a String, TreeNode This class uses a private member root (reference to a TreeNode)
 * The constructor will call the buildTree.
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	//class variable
	private TreeNode<String>treeRoot;
	// default constructor that calls buildTree method
	public MorseCodeTree() {
		treeRoot = null;
		buildTree();
	}
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		// TODO Auto-generated method stub
		return treeRoot;
	}
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		treeRoot = new TreeNode<String>(newNode);
	}
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	@Override
	public void insert(String code, String letter) {
		// TODO Auto-generated method stub
		//checks if root is null
		if (treeRoot == null)
			//assigns the given element as the root
			treeRoot = new TreeNode<String>(letter);
		else
			//calls addNode method with the root, code and letter 
			addNode(treeRoot, code, letter);
	}
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String>root, String code, String letter) {
		// TODO Auto-generated method stub
		//checks if code is empty
		if (code.length() == 0)
			//end method
			return;
		//checks if the code's length is equal to one
		if (code.length() == 1) {
			//checks if the code is a dot
			if (code.charAt(0) == '.') 
				//if so, set the root's left child as the given letter
				root.left = new TreeNode<String>(letter);
			//occurs if the code is a dash
			else if (code.charAt(0) == '-') 
				//sets the root's right child as the given letter
				root.right = new TreeNode<String>(letter);
		}
		//checks if the code length is greater than one
		if 	(code.length() > 1) {
			//checks current character in the code is a dot
			if (code.charAt(0) == '.') {
				//removes the first character from the code
				code = code.substring(1);
				//recursively calls the addNode method to traverse left with the new code
				addNode(root.left, code, letter);
			}
				
			//checks current character in the code is a dash
			else if (code.charAt(0) == '-'){
				//removes the first character from the code
				code = code.substring(1);
				//recursively calls the addNode method to traverse right with the new code
				addNode(root.right, code, letter);
			}
		}
	}
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		//calls the recursive fetchNode method based on interface
		return fetchNode(treeRoot, code);
	}
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		String codeLetter = "";
		//checks if the code is empty
		if (code.length() == 0) 
			//returns empty string
			return codeLetter;
		//checks if the code length is one
		if (code.length() == 1) {
			//checks if the character is a dot
			if (code.charAt(0) == '.') {
				//adds the left child's data
				codeLetter += root.left.data;
				//returns letter based on the code
				return codeLetter;
			}
			//checks if the first character is a dash
			else if (code.charAt(0) == '-'){
				//adds the right child's data
				codeLetter += root.right.data;
				//returns letter based on the code
				return codeLetter;
			}
				
		}
		//checks if the code length is greater than one
		if (code.length() > 1) {
			//checks if the first character is a dot
			if (code.charAt(0) == '.') {
				//removes the first character from the code
				code = code.substring(1);
				//recursively calls fetchNode with the left child and new code
				codeLetter += fetchNode(root.left, code);
			}
			//checks if the first character is a dash
			else if (code.charAt(0) == '-'){
				//removes the first character from the code
				code = code.substring(1);
				//recursively calls fetchNode with the right child and new code
				codeLetter += fetchNode(root.right, code);
			}
		}
		//returns letter based on the code
		return codeLetter;
	}
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 * The root will have a value of "" (empty string) level one: insert(".", "e"); insert("-", "t"); 
	 * level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc. 
	 * Look at the tree and the table of codes to letters in the assignment description.
	 */
	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		//sets root of the tree to a empty string
		setRoot(new TreeNode<String>(""));
		//tree level 1
		insert(".", "e"); insert("-", "t");
		//tree level 2
		insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m");
		//tree level 3
		insert("...", "s"); insert("..-", "u"); insert(".-.", "r"); insert(".--", "w"); insert("-..", "d");  insert("-.-", "k"); insert("--.", "g"); insert("---", "o");
		//tree level 4
		insert("....","h"); insert("...-","v"); insert("..-.","f"); insert(".-..","l"); insert(".--.","p"); insert(".---","j"); insert("-...","b"); insert("-..-","x"); insert("-.-.","c");  insert("-.--","y"); insert("--..","z"); insert("--.-","q");
	}
	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		//variable
		ArrayList<String>inorderList = new ArrayList<String>();
		//calls LNRoutputTraversal method to fill the empty arraylist 
		LNRoutputTraversal(treeRoot, inorderList);
		//returns the filled arraylist of items in inorder traversal order
		return inorderList;
	}

	/**
	 * The recursive method to put the contents of the tree in an 
	 * ArrayList in LNR (Inorder).
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		//checks if root is null
		if (root == null)
			//ends method
			return;
		//calls LNRoutputTraversal method recursively to traverse left
		LNRoutputTraversal(root.left, list);
		//adds the current root's data to the arraylist along with a space
		list.add(root.data + " ");
		//calls LNRoutputTraversal method recursively to traverse right
		LNRoutputTraversal(root.right, list);
	}
}
