import java.util.Stack;
/*
 * Uses two stacks s1 and s2
 * push root to s1
 * pop an element from s1 i.e. tmp
 * push tmp->left and tmp->right to s1
 * push tmp to s2
 * do this till s1 is empty
 * Now s2 has elements in post-order.
 */
public class postOrder implements Iterator{
	Stack<Node> s1, s2;
	public postOrder(Node root) {
		s1 = new Stack<Node>();
		s2 = new Stack<Node>();
		s1.push(root);
		while(!s1.isEmpty()) {
			Node tmp = s1.pop();
			if(tmp.getLeft()!=null)
				s1.push(tmp.getLeft());
			if(tmp.getRight()!=null)
				s1.push(tmp.getRight());
			s2.push(tmp);
		}
	}

	//return next element in iterator
	@Override
	public Node next() {
		return s2.pop();
	}

	//check if there is next element in iterator
	@Override
	public boolean hasNext() {
		return !s2.isEmpty();
	}
}

