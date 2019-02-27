
//An interface for the Node i.e. leaf, operator and decorator too.
public interface Node {

	public void display();

	Node getLeft();

	Node getRight();

	void addLeft(Node l);

	void addRight(Node r);
}
