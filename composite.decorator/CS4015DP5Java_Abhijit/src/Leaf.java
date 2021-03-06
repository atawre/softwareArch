
public class Leaf implements Node {
	Integer val;
	public Leaf(Integer v) {
		val = v;
	}

	public String getVal() {
		return Integer.toString(val);
	}
	
	//Only displays the number in the leaf. Basic printing.
	public void display() {
		System.out.print(val);
	}

	//Unsupported for leaf node
	@Override
	public Node getLeft() {
		throw new UnsupportedOperationException();
	}

	//Unsupported for leaf node
	@Override
	public Node getRight() {
		throw new UnsupportedOperationException();
	}

	//Unsupported for leaf node
	@Override
	public void addLeft(Node l) {
		throw new UnsupportedOperationException();	
	}

	//Unsupported for leaf node
	@Override
	public void addRight(Node r) {
		throw new UnsupportedOperationException();
	}
}
