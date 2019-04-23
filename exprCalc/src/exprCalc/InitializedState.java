package exprCalc;

public class InitializedState extends State{

	@Override
	public void build(TreeOps context, String expr) {
		ExpressionTree tree = context.getTree();
		tree.buildTree(expr);
	}

	@Override
	public double evaluate(TreeOps context) {
		ExpressionTree tree = context.getTree();
		return tree.accept();
	}

	/*
	 * We can create many methods and states to avoid following switch case.
	 * Keeping it simple just to showcase the state pattern.
	 */
	@Override
	public String display(TreeOps context, String format) {
		ExpressionTree tree = context.getTree();
		String str = "";
		Iterator in = null;
        switch(format) 
        {
            case "inorder":
				in = new inOrder(tree.getRoot());
            	break;
            case "preorder":
				in = new preOrder(tree.getRoot());
            	break;
            case "postorder":
				in = new postOrder(tree.getRoot());
            	break;
            default:
        		tree.levelPrint();
        		return "Displayed on commandline.";
        }
		while(in.hasNext())
			str += " " + in.next().getVal();
		return str;
	}

	@Override
	public void clear(TreeOps context) {
		context.setState(new UnInitializedState());
	}
}
