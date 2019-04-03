//Interface for visitor 
public interface Evaluator {
	public Double visitLeaf(Leaf l);			//Leaf visitor
	public Double visitPlus(Operator o);		//plus operator visitor
	public Double visitMinus(Operator o);		//minus operator visitor
	public Double visitMultiply(Operator o);	//multiply operator visitor
	public Double visitDivide(Operator o);		//divide operator visitor
}
