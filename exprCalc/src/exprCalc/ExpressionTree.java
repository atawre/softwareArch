package exprCalc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @class ExpressionTree
 *
 * @brief Interface for the Composite pattern that is used to contain
 *        all the operator and operand nodes in the expression tree.
 */
public class ExpressionTree {
    protected quotedNode root = null;
    protected IteratorFactory iFactory = null;
	protected infixEvaluator infixEval = null;
    protected Scanner in = null;
	protected Logger logger;
	
    /**
     * Ctor that takes a @a Node * that contains all the nodes in the
     * expression tree.
     */
    public ExpressionTree(quotedNode root) {
        this.root = root;
        infixEval = new infixEvaluator();
    }

    public ExpressionTree(Node root) {
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
    	root = new quotedNode(readTree());
    }
    
    public Node readTree() {
		return null;
	}
    
    //return height of the tree.
	public int getHeight() {
		return height(root);
	}
	
	private int height(Node head) {
	    if (head == null) {
	        return 0;
	    } else {
	        return 1 + Math.max(height(head.getLeft()), height(head.getRight()));
	    }
	}
    

	//public abstract void levelPrint();
	
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

	public void levelPrint() {
		// TODO Auto-generated method stub
	}
}

