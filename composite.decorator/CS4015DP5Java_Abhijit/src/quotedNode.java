
public class quotedNode extends nodeDecorator{

	public quotedNode(Node newNode) {
		super(newNode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		System.out.print("'");
		tempNode.display();
		System.out.print("'");
	}
}
