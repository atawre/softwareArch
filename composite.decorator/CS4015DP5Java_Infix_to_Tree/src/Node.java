
public class Node {
	char op;
	Node left, right;
	public Node() {
		left = right = null;
	}
	
	public Node(char c) {
		op = c;
		left = right = null;
	}
	
	public Node(char c, Node l, Node r) {
		op = c;
		left = l;
		right = r;
	}
	
	public void display() {
		System.out.print(Character.toString(op) + " ");
	}
}
