package exprCalc;

public class quotedNode extends nodeDecorator{
	private String glyf;
	
	public quotedNode(Node newNode) {
		super(newNode);
		glyf = "'" + newNode.getVal() + "'";
	}

	@Override
	public String getVal() {
		return glyf;
	}

	@Override
	public String getGlyf() {
		return glyf;
	}
}
