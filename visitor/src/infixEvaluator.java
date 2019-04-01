
public class infixEvaluator implements Evaluator {
	private Double result;
	public infixEvaluator() {
		result = 0.0;
	}

	Double getResult() {
		return result;
	}
	
	@Override
	public Double visitLeaf(Leaf l) {
		return Double.parseDouble(l.getVal());
	}
	
	@Override
	public Double visitPlus(Operator o) {
		Double l =  o.getLeft().accept(this); 
		Double r =  o.getRight().accept(this);
		result =  l + r;
		return result;
	}
	
	@Override
	public Double visitMinus(Operator o) {
		result = o.getLeft().accept(this) - o.getRight().accept(this);
		return result;
	}
	
	@Override
	public Double visitMultiply(Operator o) {
		result = o.getLeft().accept(this) * o.getRight().accept(this);
		return result;
	}
	
	@Override
	public Double visitDivide(Operator o) {
		result = o.getLeft().accept(this) / o.getRight().accept(this);
		return result;
	}
}
