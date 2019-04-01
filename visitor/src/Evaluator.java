
public interface Evaluator {
	public Double visitLeaf(Leaf l);
	public Double visitPlus(Operator o);
	public Double visitMinus(Operator o);
	public Double visitMultiply(Operator o);
	public Double visitDivide(Operator o);
}
