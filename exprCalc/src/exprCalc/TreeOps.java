package exprCalc;

/**
 *  Acts as the "Context" in a State pattern.
 *  Most of its methods delegate to the corresponding methods in sublcasses of
 *   the @a State base class, which then perform the requested  operations.
 */
public class TreeOps {
    /**
     * Keep track of the current state of user operations.
     */
    private State state;
	private ModelDb mydb;
    private ExpressionTree tree;

    /** Ctor */
    public TreeOps() {
        state = new UnInitializedState();
        tree = new logOpsExpressionTree();		//default tree for treeOps.
        mydb = ModelDb.getInstance();
    }

    /**
     * state getter
     **/
    State getState() {
        return state;
    }

    /**
     * State setter
     */
    void setState(State s) {
        this.state = s;
    }

    /** 
     * Return the current @a ExpressionTree that's owned by this
     * object.
     */
    ExpressionTree getTree() {
        return tree;
    }

    /** Set the current @a ExpressionTree to @a newtree.*/
    void setTree(ExpressionTree newTree) {
        tree = newTree;
    }

	public void build() {
		state.build(this, mydb.getExpr());
	}

    /**
     * Evaluate the "yield" of the most recently created expression
     * tree using the designated @a format.
     */
    public Double evaluate() {
        return state.evaluate(this);
    }

	public String display(String format) {
		return state.display(this, format);
	}

	public void noop() {
		// TODO Auto-generated method stub
	}
}

