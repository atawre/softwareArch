package exprCalc;

public abstract class nodeDecorator implements Node {

		protected Node tempNode;	//composition
		
		public nodeDecorator(Node newNode) {
			tempNode = newNode;
		}		//display method of containing object is invoked.

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

		//this is same as leaf/operator method ofr un-quoted node.
		//quoting is not shown here to preserve lookNfeel.
		//however, root node can be seen quoted in traversals (in|pre|post-order)
		private void printSpacingBetweenNodes(int level){
		    //spacing between nodes
		    for (int i = (int) ((Math.pow(2,level-1))*2)-1; i >0; i--) {
		        System.out.print(" ");
		    }
		}
		
		@Override
		public void display(int level) {
			System.out.print(tempNode.getGlyf());
			printSpacingBetweenNodes(level);
		}
		
		@Override
		public Double accept(Evaluator e) {
			return tempNode.accept(e);
		}
}
