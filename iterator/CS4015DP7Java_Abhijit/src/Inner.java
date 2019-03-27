
public class Inner implements Node {
	Integer val;
	Node left, right;

	public String getVal() {
		return Integer.toString(val);
	}


	//operator constructor with only operator mentioned.
	public Inner(int v) {
		val = v;
		left = right = null;
	}

	//get left child
	@Override
	public Node getLeft() {
		return left;
	}

	public Node setLeft(Node l) {
		return left=l;
	}

	//get right child
	@Override
	public Node getRight() {
		return right;
	}

	public Node setRight(Node r) {
		return right=r;
	}

	//set left child
	@Override
	public void addLeft(Node l) {
		left = l;
	}

	//get right child
	@Override
	public void addRight(Node r) {
		right = r;
	}

	@Override
	public Iterator createIterator(String type) {
		Iterator it = null;
        switch(type)
        {
            case "inorder": 
                it = new inOrder(this);
                break;
            case "preorder":
                it = new preOrder(this);
                break;
            case "postorder":
                it = new postOrder(this);
                break;
        }
		return it;
	}
}


