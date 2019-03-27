import java.util.Stack;

public class inOrder implements Iterator{
	Stack<Node> stack;
	public inOrder(Node root) {
		stack = new Stack<Node>();
		while (root != null) {
			stack.push(root);
			root = root.getLeft();
		}
	}

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

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

}
