
public class quotedNode extends nodeDecorator{

	public quotedNode(Node newNode) {
		super(newNode);
		// TODO Auto-generated constructor stub
	}

	//Adds quotes around the display leaf/operator.
	@Override
	public void display() {
		System.out.print("'");
		tempNode.display();
		System.out.print("'");
	}
}
