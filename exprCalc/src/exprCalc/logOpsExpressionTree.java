package exprCalc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
		//setup chain of loggers 
		logger = new TimeStampLogger(new ElapsedTimeMilliSeconds(System.currentTimeMillis()));
		logger.setNextLogger(new ConsoleLogger());
    }

    public logOpsExpressionTree() {
    	super();
		//setup chain of loggers 
		logger = new TimeStampLogger(new ElapsedTimeMilliSeconds(System.currentTimeMillis()));
		logger.setNextLogger(new ConsoleLogger());
	}

	public logOpsExpressionTree(long programStart) {
    	super();
		//setup chain of loggers 
		logger = new TimeStampLogger(new ElapsedTimeMilliSeconds(programStart));
		logger.setNextLogger(new ConsoleLogger());
	}

	/** Returns whether a the tree is null. */
    public boolean isNull() {
        logger.write("starting isNull() call");
        boolean temp = super.isNull();
        logger.write("finished isNull() call");
        return temp;
    }

    /** Returns root. */
    public Node getRoot() {
        logger.write("starting getRoot() call");
        Node temp = root;
        logger.write("finished getRoot() call");
        return temp;
    }

    /** Returns the root item. */
    public int item() throws Exception {
        logger.write("starting left() call");
        int temp = super.item();
        logger.write("finished left() call");
        return temp;
    }

    /** Returns the tree's left node. */
    public ExpressionTree left() {
        logger.write("starting left() call");
        ExpressionTree temp = super.left();
        logger.write("finishSystem.out.printed right() call");
        return temp;
    }

    /** Returns the tree's right node. */
    public ExpressionTree right() {
        logger.write("starting right() call");
        ExpressionTree temp = super.right();
        logger.write("finished right() call");
        return temp;
    }

    /** Accepts a @a visitor. */
    public double accept() {
        logger.write("starting accept() call");
		root.accept(infixEval);
        logger.write("finished accept() call");
		return infixEval.getResult();
    }
    
    /*
     * This method logs operation calls.
     */
    public Node readTree() {
    	logger.write("Calling readTree");
        Node n = null;
        // get next non-whitespace char
        char ch = in.findInLine("(\\S)").charAt(0);
        if ((ch >= '0') && (ch <='9')) {
        	// leaf node
        	logger.write("Creating leaf");
        	Leaf l = new Leaf(Character.getNumericValue(ch));
        	n = l;
        } else if (ch == '(') {
        	Operator o = new Operator(' ');
            // an expression
        	logger.write("Calling addLeft");
            o.addLeft(readTree());
        	logger.write("Calling setVal");
            o.setVal(in.findInLine("(\\S)").charAt(0));
        	logger.write("Calling adddRight");
            o.addRight(readTree());
            ch = in.findInLine("(\\S)").charAt(0);
            if (ch != ')') {
                logger.write("EXPECTED ) - } ASSUMED...");
            }
            n = o;
        } else {
        	logger.write("EXPECTED ( - CAN'T PARSE");
            System.exit(1);
        }
        return n;
    }

    
	private void printIndentForLevel(int level){
	    for (int i = (int) (Math.pow(2,level-1)); i >0; i--) {
	        logger.getNextLogger().write(" ");
	    }
	}

	private void printSpacingBetweenNodes(int level){
	    //spacing between nodes
	    for (int i = (int) ((Math.pow(2,level-1))*2)-1; i >0; i--) {
	        logger.getNextLogger().write(" ");
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
	        if(treeNode == null) {
	            logger.getNextLogger().write(" ");
	        	printSpacingBetweenNodes(level);
	        }else {
	        	treeNode.display(level);
	        }
	        //if its not a leaf node
	        if(level>1){
	            nodes.add(treeNode == null? null:treeNode.getLeft());
	            nodes.add(treeNode == null? null:treeNode.getRight());
	        }
	    }
        logger.getNextLogger().write("\n");
	    if(level>1){
	        printTree(nodes, level-1);
	    }
	}

	@Override
	public void levelPrint() {
		List<Node> list = new ArrayList<Node>();
		list.add(root);
		logger.getNextLogger().write("--------------------------------------------\n");
		printTree(list, getHeight());
		logger.getNextLogger().write("--------------------------------------------\n");
	}
    
    /** 
     * Returns the designated iterator after requesting it from
     * factory method. 
     */
    public Iterator makeIterator(String traversalOrder) {
        logger.write("starting iterator() call");
        Iterator temp = iFactory.makeIterator(traversalOrder);
        logger.write("finished iterator() call");
        return temp;
    }

}
