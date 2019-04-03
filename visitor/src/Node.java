
//An interface for the Node i.e. leaf, operator too.
public interface Node {
	public String getVal();
	Node getLeft();
	Node getRight();
	void addLeft(Node l);
	void addRight(Node r);
	//accepts the visitor to implement specialized operation
	public Double accept(Evaluator e);
}
