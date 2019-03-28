
//An interface for the Node i.e. leaf, operator and decorator too.
public interface Node {
	public String getVal();
	
	Node getLeft();

	Node getRight();

	void addLeft(Node l);

	void addRight(Node r);
	
	//static method to return the desired iterator
	static Iterator createIterator(String type, Node root) {
			Iterator it = null;
	        switch(type)
	        {
	            case "inorder": 
	                it = new inOrder(root);
	                break;
	            case "preorder":
	                it = new preOrder(root);
	                break;
	            case "postorder":
	                it = new postOrder(root);
	                break;
	        }
			return it;
	}
}
