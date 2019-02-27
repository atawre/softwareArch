
public abstract class nodeDecorator implements Node {

		protected Node tempNode;
		
		public nodeDecorator(Node newNode) {
			tempNode = newNode;
		}
		
		@Override
		public void display() {
			tempNode.display();		
		}

		@Override
		public Node getLeft() {
			return tempNode.getLeft();
		}

		@Override
		public Node getRight() {
			return tempNode.getRight();	}

		@Override
		public void addLeft(Node l) {
			tempNode.addLeft(l);
		}

		@Override
		public void addRight(Node r) {
			tempNode.addRight(r);
		}

}
