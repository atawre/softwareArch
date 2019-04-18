package exprCalc;

public class quotedNode extends nodeDecorator{

	public quotedNode(Node newNode) {
		super(newNode);
	}

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
