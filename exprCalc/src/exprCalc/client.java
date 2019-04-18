package exprCalc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class client {

//	static HashMap<Character, Integer> precendence = new HashMap<>();
	
//	public client() {
//	}

//	public static void printExpression(Node root) {
//	}
	
	public static void main(String[] args) {
        String str = "a + b - c * d / e < f > g >= h <= i == j";
        String[] ops = str.split("\\s*[a-zA-Z]+\\s*");
        String[] notops = str.split("\\s*[^a-zA-Z]+\\s*");
        String[] res = new String[ops.length+notops.length-1];
        for(int i=0; i<ops.length; i++)
        	System.out.println(ops[i]);

        System.out.println();
        for(int i=0; i<notops.length; i++)
        	System.out.println(notops[i]);

        
        for(int i=0; i<res.length; i++)
        	res[i] = i%2==0 ? notops[i/2] : ops[i/2+1];
	}
}
		//pending operators are saved in LIFO order.
		//Any operator that is yet to receive it's children, is pending.
/*
		Stack <Node> pendingOperators = new Stack<Node> ();
		
		//complete node might get unlinked from tree, use following stack to keep track.
		Stack <Node> expressions = new Stack<Node> ();	
		
		Node root = null;
		
		Character cmd, op;
		Integer num;
		Node prevOperator = null;
		Node operator = null;
		Node number = null;
		
		System.out.println("o <operator>");
		System.out.println("n <number>");
		System.out.println("p <= print");
		System.out.println("l <= level wise printing");
		System.out.println("q <= exit");
		System.out.println("Operator ) & ( are not handled");
		System.out.println("Demonstrates quoted decorator for leaf and un-quoted display for operators.");
		System.out.println("Submitted model doesn't show level wise printing, since it is added later.");
		System.out.println("");
		
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			cmd = scan.next().charAt(0);
			switch(cmd) {
				case 'l':
				case 'L':
					printLevelOrder(root);
					break;
				case 'q':
				case 'Q':
					return;
				case 'p':
				case 'P' :
						root.display();
					break;
				case 'o':
				case 'O' :
					op = scan.next().charAt(0);
                    //--------------------------------------
                    //Un-DECORATED Operator
                    //--------------------------------------				
					operator = new Operator(op);
					if(root==null)
						root = operator;							//set root for the tree
					if(pendingOperators.size() > 0) {
						prevOperator = pendingOperators.pop();
						if(prevOperator.getLeft()==null) {
							prevOperator.addLeft(operator);
							pendingOperators.push(prevOperator);	//right child still pending.
						}else if(prevOperator.getRight()==null) {
							prevOperator.addRight(operator);
						}
					}

					if(expressions.size() > 0) {
						Node expr = expressions.pop();
						if(operator.getLeft()==null) {
							operator.addLeft(expr);
						}
						if(expr==root) {
							root = operator;						//update the root
						}
					}
					
					pendingOperators.push(operator);
					break;
				case 'n':
				case 'N' :
					num = scan.nextInt();
					
                    //--------------------------------------
                    //DECORATED Leaf
                    //--------------------------------------
					number = new quotedNode(new Leaf(num));

					if(pendingOperators.size() > 0) {
						prevOperator = pendingOperators.pop();
						if(prevOperator.getLeft()==null) {
							prevOperator.addLeft(number);
							pendingOperators.push(prevOperator);	//right child still pending.
						}else if(prevOperator.getRight()==null) {
							prevOperator.addRight(number);
							expressions.push(prevOperator);			//fully formed operator now become an operand.
						}
					}
					break;
				}
			}
		}

	
	
	

	//Iterative method to do level order traversal line by line 
    static void printLevelOrder(Node root) 
    {
    	
    	System.out.println();
    	System.out.println("Level wise printing.");
        // Base Case 
        if(root == null) 
            return;
        // Create an empty queue for level order tarversal 
        Queue<Node> q =new LinkedList<Node>(); 
        
        // Enqueue Root and initialize height 
        q.add(root);

        while(true)
        {     
            // nodeCount (queue size) indicates number of nodes 
            // at current level. 
            int nodeCount = q.size(); 
            if(nodeCount == 0) 
                break;
            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while(nodeCount > 0)
            {
                Node node = q.peek(); 
                System.out.print(node.getVal() + " ");
                q.remove();
                if(node instanceof Operator) {
                	Operator op = (Operator) node;
                	if(op.getLeft() != null) 
                		q.add(op.getLeft());
                	if(op.getRight() != null) 
                		q.add(op.getRight()); 
                }
                nodeCount--; 
            }
            System.out.println(); //new line for this level
        }
    	System.out.println();
    }

}

*/
