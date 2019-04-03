
Client invokes generate tree method to create a balanced expression tree.
Inner nodes are operators [+-*/] and leaf nodes are integer values.

For command  G <n>  e.g.  G 3 , tree with 3 levels is created.

array with 2^3 - 1 elements is created 1, 2, 3, 4, 5, 6, 7
Last 2^(levels-1) elements for leaf nodes. Rest of array elements are ignored. Those positions are filled with operators. 
Operators are selected from operators arrays. Position in elements array % 4 = position in operator array.

			   +
		*			/
	4		5	6		7

The element numbers are always sequential. I could have made it random as well.
E Evaluates tree using visitor pattern (infix order)
V Display tree in level order.

Composite consists of:
Node 		- interface
Operator	- Inner node of tree with left/right children
Leaf		- Leaf node of the tree (no children)

Visitor consists of :
Evaluator	- Visitor
infixEvaluator	- Concrete Visitor



InsertLevelOrder method generate binary expression tree.

printLevelOrder prints expression tree in level order.