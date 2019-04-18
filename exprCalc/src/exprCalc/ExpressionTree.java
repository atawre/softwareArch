package exprCalc;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @class ExpressionTree
 *
 * @brief Interface for the Composite pattern that is used to contain
 *        all the operator and operand nodes in the expression tree.
 */
public class ExpressionTree {
    /** Base implementor. */
    protected Node root = null;
    protected IteratorFactory iFactory = null;
	protected infixEvaluator infixEval = null;
    protected Scanner in = null;
	
    /**
     * Ctor that takes a @a Node * that contains all the nodes in the
     * expression tree.
     */
    public ExpressionTree(Node root) {
        this.root = root;
        infixEval = new infixEvaluator();
    }

    public ExpressionTree() {
        this.root = null;
        infixEval = new infixEvaluator();
    }
    
    /** Returns whether a the tree is null. */
    public boolean isNull() {
        return root == null;
    }

    /** Returns root. */
    public Node getRoot() {
        return root;
    }

    /** Returns the root item. */
    public int item() throws Exception {
        //return root.item();
        return 0;
    }

    /** Returns the tree's left node. */
    public ExpressionTree left() {
        return new ExpressionTree(root.getLeft());
    }

    /** Returns the tree's right node. */
    public ExpressionTree right() {
        return new ExpressionTree(root.getRight());
    }

    /** This is a template method
     * 	Individual tree specific implementation is defined in concrete Expression trees.
     * */
    public void buildTree(String expr) {
		in = new Scanner(expr);
    	root = readTree();
    }

    public Node readTree() {
		return null;
	}
    
    /** Accepts a @a visitor. */
    public double accept() {
		root.accept(infixEval);
		return infixEval.getResult();
    }

    /** 
     * Returns an @a Iterator that supports the requested
     * traveralOrder.
     */
    public Iterator makeIterator(String traversalOrderRequest) {
    	return iFactory.makeIterator(traversalOrderRequest);
    }
}

