package exprCalc;

//
//useful for flyWeight pattern. (String interning).
// the strings refer to constant pool. 
// Using string as a glyf here just to show flyWeith pattern.
//

public class Leaf implements Node {
	Integer val;
	String glyf;
	public Leaf(Integer v) {
		val = v;
		glyf = Integer.toString(v);
	}

	public String getGlyf() {
		return glyf;
	}

	//It invokes Leaf specific visit call
	@Override
	public Double accept(Evaluator e) {
		return e.visitLeaf(this);
	}

	//returns the actual value int for leaves.
	public int getActualVal() {
		return val;
	}

	//returns string version of the value.
	public String getVal() {
		return glyf;
	}
	
	//Unsupported for leaf node
	@Override
	public Node getLeft() {
		return null;
	}

	//Unsupported for leaf node
	@Override
	public Node getRight() {
		return null;
	}

	//Unsupported for leaf node
	@Override
	public void addLeft(Node l) {
		throw new UnsupportedOperationException();	
	}

	//Unsupported for leaf node
	@Override
	public void addRight(Node r) {
		throw new UnsupportedOperationException();
	}

	//used for level wise tree printing.
	//calculates spacing between nodes based on current level of the node.
	//Used as position locator for flyWeight pattern.
	private void printSpacingBetweenNodes(int level){
	    //spacing between nodes
	    for (int i = (int) ((Math.pow(2,level-1))*2)-1; i >0; i--) {
	        System.out.print(" ");
	    }
	}

	//The extrinsic value i.e. level is used by the higher level print method.
	@Override
	public void display(int level) {
		System.out.print(glyf);
		printSpacingBetweenNodes(level);
	}
}
