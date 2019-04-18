package exprCalc;

//An interface for the Node i.e. leaf, operator and decorator too.
public interface Node {

	public void display();

	public String getVal();
	
	Node getLeft();

	Node getRight();

	void addLeft(Node l);

	void addRight(Node r);
}
