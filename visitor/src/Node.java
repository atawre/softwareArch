import java.util.ArrayList;
import java.util.List;

//An interface for the Node i.e. leaf, operator too.
public interface Node {
	public String getVal();
	Node getLeft();
	Node getRight();
	void addLeft(Node l);
	void addRight(Node r);
	//accepts the visitor to implement specialized operation
	public Double accept(Evaluator e);
	public static int getHeight(Node head) {

	    if (head == null) {
	        return 0;
	    } else {
	        return 1 + Math.max(getHeight(head.getLeft()), getHeight(head.getRight()));
	    }
	}
	
	private static void printIndentForLevel(int level){
	    for (int i = (int) (Math.pow(2,level-1)); i >0; i--) {
	        System.out.print(" ");
	    }
	}

	private static void printSpacingBetweenNodes(int level){
	    //spacing between nodes
	    for (int i = (int) ((Math.pow(2,level-1))*2)-1; i >0; i--) {
	        System.out.print(" ");
	    }
	}

	/**
	 * pass head node in list and height of the tree 
	 * @param levelNodes
	 * @param level
	 */
	public static void printTree(List<Node> levelNodes, int level) {

	    List<Node> nodes = new ArrayList<Node>();

	    //indentation for first node in given level
	    printIndentForLevel(level);

	    for (Node treeNode : levelNodes) {

	        //print node data
	        System.out.print(treeNode == null?" ":treeNode.getVal());

	        //spacing between nodes
	        printSpacingBetweenNodes(level);

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
}
