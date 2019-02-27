
public abstract class nodeDecorator implements Node {

		protected Node tempNode;	//composition
		
		public nodeDecorator(Node newNode) {
			tempNode = newNode;
		}
		
		//display method of containing object is invoked.
		@Override
		public void display() {
			tempNode.display();		
		}

		//getLeft method of containing object is invoked.
		@Override
		public Node getLeft() {
			return tempNode.getLeft();
		}

		//getRight method of containing object is invoked.
		@Override
		public Node getRight() {
			return tempNode.getRight();	}

		//addLeft method of containing object is invoked.
		@Override
		public void addLeft(Node l) {
			tempNode.addLeft(l);
		}

		//addRight method of containing object is invoked.
		@Override
		public void addRight(Node r) {
			tempNode.addRight(r);
		}

}
