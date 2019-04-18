package exprCalc;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @class logOpsExpressionTree
 * 
 * @brief Plays the role of the "Abstraction" in the Bridge pattern
 *        and delegates to the appropriate "Implementor" that performs
 *        the expression tree operations, after first logging the
 *        start and finish of each call.
 */

public class logOpsExpressionTree extends ExpressionTree {

    /**
     * Ctor that takes a @a Node * that contains all the nodes in the
     * expression tree.
     */
    public logOpsExpressionTree(Node root) {
        super(root);
    }

    public logOpsExpressionTree() {
    	super();
	}

	/** Returns whether a the tree is null. */
    public boolean isNull() {
        System.out.println("starting isNull() call");
        boolean temp = super.isNull();
        System.out.println("finished isNull() call");
        return temp;
    }

    /** Returns root. */
    public Node getRoot() {
        System.out.println("starting getRoot() call");
        Node temp = root;
        System.out.println("finished getRoot() call");
        return temp;
    }

    /** Returns the root item. */
    public int item() throws Exception {
        System.out.println("starting left() call");
        int temp = super.item();
        System.out.println("finished left() call");
        return temp;
    }

    /** Returns the tree's left node. */
    public ExpressionTree left() {
        System.out.println("starting left() call");
        ExpressionTree temp = super.left();
        System.out.println("finished right() call");
        return temp;
    }

    /** Returns the tree's right node. */
    public ExpressionTree right() {
        System.out.println("starting right() call");
        ExpressionTree temp = super.right();
        System.out.println("finished right() call");
        return temp;
    }

    /** Accepts a @a visitor. */
    public double accept() {
        System.out.println("starting accept() call");
		root.accept(infixEval);
        System.out.println("finished accept() call");
		return infixEval.getResult();
    }
    
    /*
     * This method logs operation calls.
     */
    public Node readTree() {
    	System.out.println("Calling readTree");
        Node n = null;
        // get next non-whitespace char
        char ch = in.findInLine("(\\S)").charAt(0);
        if ((ch >= '0') && (ch <='9')) {
        	// leaf node
        	System.out.println("Creating leaf");
        	Leaf l = new Leaf(Character.getNumericValue(ch));
        	n = l;
        } else if (ch == '(') {
        	Operator o = new Operator(' ');
            // an expression
        	System.out.println("Calling addLeft");        	
            o.addLeft(readTree());
        	System.out.println("Calling setVal");
            o.setVal(in.findInLine("(\\S)").charAt(0));
        	System.out.println("Calling adddRight");
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

    /** 
     * Returns the designated iterator after requesting it from
     * factory method. 
     */
    public Iterator makeIterator(String traversalOrder) {
        System.out.println("starting iterator() call");
        Iterator temp = iFactory.makeIterator(traversalOrder);
        System.out.println("finished iterator() call");
        return temp;
    }
}
