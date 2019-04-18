package exprCalc;

public class quotedNode extends nodeDecorator{

	public quotedNode(Node newNode) {
		super(newNode);
	}

	//Adds quotes around the display leaf/operator.
//	@Override
//	public void display() {
//		System.out.print("'");
//		tempNode.display();
//		System.out.print("'");
//	}

	@Override
	public String getVal() {
		return "'" + tempNode.getVal() + "'";
	}

	@Override
	public Double accept(Evaluator e) {
		// TODO Auto-generated method stub
		return null;
	}
}
