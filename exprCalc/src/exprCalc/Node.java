package exprCalc;

//An interface for the Node i.e. leaf, operator and decorator too.
public interface Node {
	public String getVal();
	
	Node getLeft();

	Node getRight();

	void addLeft(Node l);

	void addRight(Node r);
	
	void display(int level);	//level is an extrinsic state of a node (concerned with flyWeight)
	
	String getGlyf();
	
	//accepts the visitor to implement specialized operation
	public Double accept(Evaluator e);
	
}
