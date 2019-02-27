import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class client {

	static HashMap<Character, Integer> precendence = new HashMap<>();
	
	public client() {
	}

	public static void main(String[] args) {
		Stack <Character> operatorStack = new Stack <Character> ();
		Stack <Node> exprStack = new Stack<Node> ();

		precendence.put('+', 0);
		precendence.put('-', 0);
		precendence.put('*', 1);
		precendence.put('/', 1);
		
		Scanner scan = new Scanner(System.in);
		String expr = scan.nextLine();
		for (int i = 0; i < expr.length(); i++){
		    char c = expr.charAt(i);

			switch(c) {
			case '+' :
			case '-' :
			case '*' :
			case '/' :
				Character top = operatorStack.peek();
				while( (Character.compare(top, '(') != 0) && (precendence.get(top) >= precendence.get(c)) ) {
					Character op = operatorStack.pop();
					Node r = exprStack.pop();
					Node l = exprStack.pop();
					exprStack.push(new Node(op, l, r));
					top = operatorStack.peek();
				}
				operatorStack.push(c);  //push operators to Character stack
				break;
			case '(' :
				operatorStack.push(c);  //treat  '(' as operator
				break;
			case ')' :
				//keep forming expressions till you hit a '('
				while( Character.compare(operatorStack.peek(), '(') != 0) {
					Character op = operatorStack.pop();
					Node r = exprStack.pop();
					Node l = exprStack.pop();
					exprStack.push(new Node(op, l, r));
				}
				operatorStack.pop();	//Pop the '(' off the operator stack.
				break;
			default :
				exprStack.push(new Node(c));
				break;
			}
		}
		//System.out.print(exprStack);
		printLevelOrder(exprStack.pop());
	}
	
    // Iterative method to do level order traversal line by line 
    static void printLevelOrder(Node root) 
    { 
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
                node.display();
                q.remove();
                if(node.left != null) 
                    q.add(node.left);
                if(node.right != null) 
                    q.add(node.right); 
                nodeCount--; 
            }
            System.out.println(); //new line for this level
        }
    }

}


