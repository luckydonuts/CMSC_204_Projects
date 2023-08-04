import static org.junit.Assert.fail;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Michael Bushman
 * 
 * Junit tests for MorseCodeTree class
 *
 */
class MorseCodeTreeTestStudent {

	MorseCodeTree tree = new MorseCodeTree();
	
	@Test
	void testGetRoot() {
		try {
			tree.getRoot();
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	void testSetRoot() {
		TreeNode<String>treeRoot = new TreeNode<String>("");

		try {
			tree.setRoot(treeRoot);
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	void testInsert() {
		String code = "...";
		String letter = "s";
		
		try {
			tree.insert(code, letter);
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	void testAddNode() {
		
		TreeNode <String> root = tree.getRoot();
		String code = "...";
		String letter = "s";
		
		try {
			tree.addNode(root, code, letter);
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	void testFetch() {
		String code = "...";
		try {
			tree.fetch(code);
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	void testFetchNode() {
		TreeNode <String> root = tree.getRoot();
		String code = "...";
		try {
			tree.fetchNode(root, code);
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	void testBuildTree() {
		try {
			tree.buildTree();
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	void testToArrayList() {
		try {
			tree.toArrayList();
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	void testLNRoutputTraversal() {
		try {
			TreeNode<String>root = null;
			ArrayList<String>list = null;
			tree.LNRoutputTraversal(root, list);
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

}
