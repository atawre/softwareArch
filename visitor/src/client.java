import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class client {
	static int levels;		//number of tree levels
	static int leaves;		//total leaves in the tree
	static int elements;	//total elements in the tree
	static char operators[] = {'+', '-', '*', '/'};
	
	public static void main(String[] args) {
		Node root = null;

		System.out.println("G <n>	Generates a random expression tree with n levels");
		System.out.println("E	Evaluates the expression and prints the value");
		System.out.println("V	Visualizes the tree (optional, for maximum marks on the assignment)");
		System.out.println("Q	Quits the program");
		System.out.println("");

		while(true) {
			Scanner scan = new Scanner(System.in);
			Character cmd = scan.next().charAt(0);
			switch(cmd) {
				case 'g':
				case 'G':
					levels = scan.nextInt();	//scan total levels
					elements = (int) Math.pow(2, levels) - 1;
					leaves = (int) Math.pow(2, levels-1);	//number of leaves
					int[] range = IntStream.rangeClosed(1, elements).toArray();		//array of elements in the tree
					System.out.println("Generate level " + Integer.toString(levels));
					root = insertLevelOrder(range, root, 0);
					break;
				case 'e':
				case 'E':
					System.out.println("------------------------------");
					System.out.println("Evaluate");
					System.out.println("-------- ---------------------");
					infixEvaluator e = new infixEvaluator();
					root.accept(e);
					System.out.println(e.getResult());
					break;
				case 'v':
				case 'V':
					System.out.println("------------------------------");
					System.out.println("Visualize the tree");
					System.out.println("------------------------------");
					printLevelOrder(root);
					break;
				case 'q':
				case 'Q':
					return;
				}
			}
		}

    // Function to insert nodes in level order
    public static Node insertLevelOrder(int[] arr, Node root, int i)
    {
    	boolean isLeaf = false;
    	if(i >= elements-leaves) {
    		isLeaf = true;
    	}

    	// Base case for recursion
        if (i < elements) {
        	if(!isLeaf) {
        		Operator temp = new Operator(operators[i%4]);
                // insert left child
                temp.setLeft(insertLevelOrder(arr, temp.getLeft(),
                                                 2 * i + 1));
                // insert right child
                temp.setRight(insertLevelOrder(arr, temp.getRight(),
                                                   2 * i + 2));
                root = temp;
        	}else {
        		Leaf temp = new Leaf(arr[i]);
                root = temp;
        	}
        }
        return root;
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
