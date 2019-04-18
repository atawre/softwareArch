package exprCalc;
/*
 * ExprTree.java
 *
 * Computer Science S-111, Harvard University
 */ 

import java.util.*;

/**
 * ExprTree - a class for representing a binary tree that represents
 * an arithmetic expression involving the operators +, -, *, or /.
 * The terms must be single lower-case letters and the expression must
 * be fully parenthesized, e.g.:
 *
 *      (((a + b) * c) + (d - (e / f)))
 */
public class ExprTree {
    private Node root;
    private Scanner in;
    
    public ExprTree() {
        root = null;
        in = new Scanner(System.in);
    }
    
    /**
     * inorderPrint - uses infix notation to print the expression tree.
     * It calls inorderPrintTree to perform a recursive inorder traversal.
     */
    public void inorderPrint() {
        if (root != null) {
        	inOrder in = new inOrder(root);
        	while(in.hasNext()) {
        		System.out.println(in.next().getVal());
        	}
        }
    }
        
    /**
     * readExpression - parses an arithmetic expression entered at the
     * keyboard and builds an expression tree for the expression.  It
     * calls readTree to recursively process the expression.
     */
    public void read() {
        root = readTree();
    }
    
    /*
     * readTree - recursively parses an arithmetic expression obtained
     * from the user and builds a binary tree for the expression.  The
     * root of the tree is returned.
     */
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

    /*
     * Program to read an arithmetic expression, convert it to a tree, and
     * print the tree in infix, prefix, and postfix notation.
     */
    public static void main(String[] args) {
        // Read in the expression and build the tree.
        System.out.println("\nType a fully parenthesized expression " +
                           "using a..z,+,-,*,/");
        
        ExprTree tree = new ExprTree();
        tree.read();
        
        // Output it using all three types of notation.
        System.out.println("\n* INFIX NOTATION:");
        tree.inorderPrint();
    }
}

