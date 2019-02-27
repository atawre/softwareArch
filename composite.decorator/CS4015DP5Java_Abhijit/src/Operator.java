
public class Operator implements Node {
	Character op;
	Node left, right;

	//inorder traversal is used to print the operator.
	public void display() {
		if(left!=null)
			left.display();

		System.out.print(op);
		
		if(right!=null)
			right.display();
	}

	//operator constructor with only operator mentioned.
	public Operator(Character c) {
		op = c;
		left = right = null;
	}

	//get left child
	@Override
	public Node getLeft() {
		return left;
	}

	//get right child
	@Override
	public Node getRight() {
		return right;
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


