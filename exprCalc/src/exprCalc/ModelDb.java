package exprCalc;

//singleton class maintaining the input expression 
//corresponding traversals and
//current value of expression

public class ModelDb {
	private String expr;
	private String inorder;
	private String preorder;
	private String postorder;
    private static final ModelDb INSTANCE = new ModelDb();

    private ModelDb() {}

    public static ModelDb getInstance() {
        return INSTANCE;
    }

	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

	public String getInorder() {
		return inorder;
	}

	public void setInorder(String inorder) {
		this.inorder = inorder;
	}

	public String getPreorder() {
		return preorder;
	}

	public void setPreorder(String preorder) {
		this.preorder = preorder;
	}

	public String getPostorder() {
		return postorder;
	}

	public void setPostorder(String postorder) {
		this.postorder = postorder;
	}
}
