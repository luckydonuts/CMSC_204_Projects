/**
 * 
 * @author Michael Bushman
 * 
 * The external Tree Node for Linked Trees
 * @param <T>
 */
public class TreeNode<T> {
	//variables
	protected T data;
	protected TreeNode<T>left;
	protected TreeNode<T>right;
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		left = null;
		right = null;
	}
	/** 
	 * Used for making deep copies
	 * @param node
	 */
	public TreeNode(TreeNode<T>node) {
		data = node.data;
		left = node.left;
		right = node.right;
	}
	/**
	 * Returns the data within this TreeNode
	 * @return data
	 */
	public T getData() {
		return data;
	}
}
