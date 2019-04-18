package exprCalc;

public class Operator implements Node {
	Character op;
	Node left, right;
	String glyf;
	
	public String getVal() {
		return Character.toString(op);
	}

	public String getGlyf() {
		return glyf;
	}

	public void setVal(Character ch) {
		op = ch;
		glyf = Character.toString(ch);
	}

	//acts as router to select appropriate visitor method.
	@Override
	public Double accept(Evaluator e) {
		Double result = 0.0;
		switch(op) {
			case '+':
				result =  e.visitPlus(this);
				break;
			case '-':
				result =  e.visitMinus(this);
				break;
			case '*':
				result =  e.visitMultiply(this);
				break;
			case '/':
				result =  e.visitDivide(this);
				break;
		}
		return result;
	}
	
	//operator constructor with only operator mentioned.
	public Operator(Character c) {
		op = c;
		glyf = Character.toString(c);
		left = right = null;
	}

	//get left child
	@Override
	public Node getLeft() {
		return left;
	}

	//get right child
	@Override
	public Node getRight() {
		return right;
	}

	//set left child
	@Override
	public void addLeft(Node l) {
		left = l;
	}

	//get right child
	@Override
	public void addRight(Node r) {
		right = r;
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

	//Glyf is intrinsic state
	//level is extrinsic state
	//for the flyWeight pattern.
	@Override
	public void display(int level) {
		System.out.print(glyf);
		printSpacingBetweenNodes(level);
	}
}

