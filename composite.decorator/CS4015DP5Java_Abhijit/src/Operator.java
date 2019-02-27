
public class Operator implements Node {
	Character op;
	Node left, right;

	public void display() {
		if(left!=null)
			left.display();

		System.out.print(op);
		
		if(right!=null)
			right.display();
	}

	public Operator(Character c) {
		op = c;
		left = right = null;
	}

	@Override
	public Node getLeft() {
		return left;
	}

	@Override
	public Node getRight() {
		return right;
	}

	@Override
	public void addLeft(Node l) {
		left = l;
	}

	@Override
	public void addRight(Node r) {
		right = r;
	}
}


