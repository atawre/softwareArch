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
						root = operator;
					if(pendingOperators.size() > 0) {
						prevOperator = pendingOperators.pop();
						if(prevOperator.getLeft()==null) {
							prevOperator.addLeft(operator);
							pendingOperators.push(prevOperator);	//right child still pending.
						}else if(prevOperator.getRight()==null) {
							prevOperator.addRight(operator);
						}
					}
					pendingOperators.push(operator);
					break;
				case 'n':
				case 'N' :
					num = scan.nextInt();
					number = new Leaf(num);
					
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


// Iterative method to do level order traversal line by line 
//    static void printLevelOrder(Node root) 
//    { 
//        // Base Case 
//        if(root == null) 
//            return;
//        // Create an empty queue for level order tarversal 
//        Queue<Node> q =new LinkedList<Node>(); 
//        
//        // Enqueue Root and initialize height 
//        q.add(root);
//
//        while(true)
//        {     
//            // nodeCount (queue size) indicates number of nodes 
//            // at current level. 
//            int nodeCount = q.size(); 
//            if(nodeCount == 0) 
//                break;
//            // Dequeue all nodes of current level and Enqueue all
//            // nodes of next level
//            while(nodeCount > 0)
//            {
//                Node node = q.peek(); 
//                node.display();
//                q.remove();
//                if(node.left != null) 
//                    q.add(node.left);
//                if(node.right != null) 
//                    q.add(node.right); 
//                nodeCount--; 
//            }
//            System.out.println(); //new line for this level
//        }
//    }

}


