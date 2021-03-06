package exprCalc;

public class UnInitializedState extends State{

	@Override
	public void build(TreeOps context, String expr) {
		ExpressionTree tree = context.getTree();
		tree.buildTree(expr);
		context.setState(new InitializedState());
	}

	@Override
	public double evaluate(TreeOps treeOps) {
		System.out.println("Invalid operation.");
		return 0.0;
	}

	@Override
	public String display(TreeOps treeOps, String format) {
		return("Invalid operation.");
	}

	@Override
	public void clear(TreeOps context) {
		// TODO Auto-generated method stub
		
	}
}
