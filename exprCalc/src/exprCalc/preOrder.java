package exprCalc;
import java.util.Stack;

public class preOrder implements Iterator{
	Stack<Node> stack;
	Node current;
	/*
	 * Allocate stack
	 * current is first element in preorder i.e. root
	 */
	public preOrder(Node root) {
		stack = new Stack<Node>();
		current = root;
	}

	/*
	 * move to left subtree and push right child to stack
	 * stack keeps track of next sequence to be printed.
	 */
	@Override
	public Node next() {
		if(current.getRight()!=null)
			stack.push(current.getRight());

		Node tmp = current;
		if(current.getLeft()!=null) {
			current = current.getLeft();
		}else if(!stack.isEmpty()){
			current = stack.pop();
		}else {
			current = null;
		}
		return tmp;
	}

	//check if next element exists.
	@Override
	public boolean hasNext() {
		return current!=null;
	}
}
