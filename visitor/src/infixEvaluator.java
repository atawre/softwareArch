
public class infixEvaluator implements Evaluator {
	private Double result;	//holds the result of current visit.
	
	public infixEvaluator() {	//constructor
		result = 0.0;
	}

	Double getResult() {
		return result;
	}
	
	//returns the value of leaf as a double.
	@Override
	public Double visitLeaf(Leaf l) {
		return Double.parseDouble(l.getVal());
	}
	
	//adds left and right subtree recursively and returns (double) value.
	@Override
	public Double visitPlus(Operator o) {
		Double l =  o.getLeft().accept(this); 
		Double r =  o.getRight().accept(this);
		result =  l + r;
		return result;
	}
	
	//subtracts left and right subtree recursively and returns (double) value.
	@Override
	public Double visitMinus(Operator o) {
		result = o.getLeft().accept(this) - o.getRight().accept(this);
		return result;
	}
	
	//multiplies left and right subtree recursively and returns (double) value.
	@Override
	public Double visitMultiply(Operator o) {
		result = o.getLeft().accept(this) * o.getRight().accept(this);
		return result;
	}
	
	//divides left and right subtree recursively and returns (double) value.
	@Override
	public Double visitDivide(Operator o) {
		result = o.getLeft().accept(this) / o.getRight().accept(this);
		return result;
	}
}
