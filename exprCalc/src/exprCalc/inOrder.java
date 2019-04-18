package exprCalc;
import java.util.Stack;


public class inOrder implements Iterator{
	Stack<Node> stack;
	
	// Keep pushing all the leftmost subtree to stack
	public inOrder(Node root) {
		stack = new Stack<Node>();
		while (root != null) {
			stack.push(root);
			root = root.getLeft();
		}
	}

	//pop from stack which is next in InOrder
	//push all leftmost subtree of the right child for this next inorder element.
	@Override
	public Node next() {
		Node node = stack.pop();
		Node result = node;
		if (node.getRight() != null) {
			node = node.getRight();
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
		}
		return result;
	}

	//check if there is next element in iterator
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}
}
