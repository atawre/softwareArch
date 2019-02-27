
public class Leaf implements Node {
	Integer val;
	public Leaf(Integer v) {
		val = v;
	}

	public void display() {
		System.out.print(val);
	}

	@Override
	public Node getLeft() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Node getRight() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addLeft(Node l) {
		throw new UnsupportedOperationException();	
	}

	@Override
	public void addRight(Node r) {
		throw new UnsupportedOperationException();
	}
}
