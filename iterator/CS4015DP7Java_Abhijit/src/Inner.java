
// Implements Node. (It is a composite)
public class Inner implements Node {
	Integer val;
	Node left, right;

	public String getVal() {
		return Integer.toString(val);
	}

	//non-leaf constructor with only operator mentioned.
	public Inner(int v) {
		val = v;
		left = right = null;
	}

	//get left child
	@Override
	public Node getLeft() {
		return left;
	}

	public Node setLeft(Node l) {
		return left=l;
	}

	//get right child
	@Override
	public Node getRight() {
		return right;
	}

	public Node setRight(Node r) {
		return right=r;
	}

	//set left child
	@Override
	public void addLeft(Node l) {
		left = l;
	}

	//get right child
	@Override
	public void addRight(Node r) {
		right = r;
	}
}


