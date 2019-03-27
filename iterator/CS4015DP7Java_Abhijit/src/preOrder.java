import java.util.Stack;

public class preOrder implements Iterator{
	Stack<Node> stack;
	Node current;
	public preOrder(Node root) {
		stack = new Stack<Node>();
		current = root;
	}

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

	@Override
	public boolean hasNext() {
		return current!=null;
	}
}
