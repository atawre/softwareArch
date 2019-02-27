import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class client {

	static HashMap<Character, Integer> precendence = new HashMap<>();
	
	public client() {
	}

	public static void printExpression(Node root) {
	}
	
	public static void main(String[] args) {
		//pending operators are saved in LIFO order.
		//Any operator that is yet to receive it's children, is pending.
		Stack <Node> pendingOperators = new Stack<Node> ();
		
		Node root = null;
		
		Character cmd, op;
		Integer num;
		Node prevOperator = null;
		Node operator = null;
		Node number = null;
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			cmd = scan.next().charAt(0);
			switch(cmd) {
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
					operator = new Operator(op);
					if(root==null)
						root = operator;		//set the root for the tree
					
					if(pendingOperators.size() > 0) {
						prevOperator = pendingOperators.pop();	//get previous operator
						if(prevOperator.getLeft()==null) {
							prevOperator.addLeft(operator);
							pendingOperators.push(prevOperator);	//right child still pending.
						}else if(prevOperator.getRight()==null) {
							prevOperator.addRight(operator);
						}
					}
					pendingOperators.push(operator);	//current operator becomes pending here.
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
						}
					}
					break;
				}
			}
		}
}


