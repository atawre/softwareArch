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
    private IteratorFactory iFactory = null;
	private infixEvaluator infixEval = null;
    private Scanner in = null;
	
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

    public void buildTree(String expr) {
		in = new Scanner(expr);
    	root = readTree();
    	//iFactory = new IteratorFactory(this);
    }

    private Node readTree() {
        Node n = null;
        // get next non-whitespace char
        char ch = in.findInLine("(\\S)").charAt(0);
        if ((ch >= '0') && (ch <='9')) {
        	// leaf node
        	Leaf l = new Leaf(Character.getNumericValue(ch));
        	n = l;
        } else if (ch == '(') {
        	Operator o = new Operator(' ');
            // an expression
            o.addLeft(readTree());
            o.setVal(in.findInLine("(\\S)").charAt(0));
            o.addRight(readTree());
            ch = in.findInLine("(\\S)").charAt(0);
            if (ch != ')') {
                System.out.print("EXPECTED ) - } ASSUMED...");
            }
            n = o;
        } else {
            System.out.print("EXPECTED ( - CAN'T PARSE");
            System.exit(1);
        }
        return n;
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

