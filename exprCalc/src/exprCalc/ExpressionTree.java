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
    /** Base implementor. */
    protected quotedNode root = null;
    protected IteratorFactory iFactory = null;
	protected infixEvaluator infixEval = null;
    protected Scanner in = null;
	
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
    
	private static void printIndentForLevel(int level){
	    for (int i = (int) (Math.pow(2,level-1)); i >0; i--) {
	        System.out.print(" ");
	    }
	}

	/**
	 * pass head node in list and height of the tree 
	 * @param levelNodes
	 * @param level
	 */
	private void printTree(List<Node> levelNodes, int level) {

	    List<Node> nodes = new ArrayList<Node>();

	    //indentation for first node in given level
	    printIndentForLevel(level);

	    for (Node treeNode : levelNodes) {

	        //print node data
	        //System.out.print(treeNode == null?" ":treeNode.getVal());
	        if(treeNode == null)
	        	System.out.print(" ");
	        else
	        	treeNode.display(level);
	        //spacing between nodes
	        //printSpacingBetweenNodes(level);

	        //if its not a leaf node
	        if(level>1){
	            nodes.add(treeNode == null? null:treeNode.getLeft());
	            nodes.add(treeNode == null? null:treeNode.getRight());
	        }
	    }
	    System.out.println();

	    if(level>1){        
	        printTree(nodes, level-1);
	    }
	}

	public void levelPrint() {
		List<Node> list = new ArrayList<Node>();
		list.add(root);
		System.out.println("--------------------------------------------");
		printTree(list, getHeight());
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

