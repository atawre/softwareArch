
// Implements Node. (It is a composite)
public class Operator implements Node {
	Character op;
	Node left, right;

	public String getVal() {
		return Character.toString(op);
	}

	//non-leaf constructor with only operator mentioned.
	public Operator(char c) {
		op = c;
		left = right = null;
	}

	//get left child
	@Override
	public Node getLeft() {
		return left;
	}

	public Node setLeft(Node l) {
		return left=l;
	}

	//get right child
	@Override
	public Node getRight() {
		return right;
	}

	public Node setRight(Node r) {
		return right=r;
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
}


