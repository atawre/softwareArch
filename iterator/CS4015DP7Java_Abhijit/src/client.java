import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class client {
	static int levels;		//number of tree levels
	static int leaves;		//total leaves in the tree
	static int elements;	//total elements in the tree

	public static void main(String[] args) {
		Node root = null;
		Iterator itr = null;
		
		System.out.println("G <n>	Generates a random binary tree with n levels");
		System.out.println("L	Level wise printing");
		System.out.println("I	Creates an inorder iterator if it does not exist, and print the next item");
		System.out.println("P	Creates a preorder iterator if it does not exist, and print the next item");
		System.out.println("O	Creates a postorder iterator if it does not exist, and print the next item");
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
				case 'i':
				case 'I':
					System.out.println("------------------------------");
					System.out.println("InOrder");
					System.out.println("------------------------------");
					itr = Node.createIterator("inorder", root);
					while(itr.hasNext()) {
						Node n = itr.next();
						System.out.print(n.getVal());
						System.out.print(" ");
					}
					break;
				case 'p':
				case 'P' :
					System.out.println("------------------------------");
					System.out.println("PreOrder");
					System.out.println("------------------------------");
					itr = Node.createIterator("preorder", root);
					while(itr.hasNext()) {
						Node n = itr.next();
						System.out.print(n.getVal());
						System.out.print(" ");
					}
					break;
				case 'o':
				case 'O' :
					System.out.println("------------------------------");
					System.out.println("PostOrder");
					System.out.println("------------------------------");
					itr = Node.createIterator("postorder", root);
					while(itr.hasNext()) {
						Node n = itr.next();
						System.out.print(n.getVal());
						System.out.print(" ");
					}
					break;
				case 'l':
				case 'L':
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
        		Inner temp = new Inner(arr[i]);
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
                if(node instanceof Inner) {
                	Inner op = (Inner) node;
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
