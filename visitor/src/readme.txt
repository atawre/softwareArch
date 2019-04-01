
Client invokes factory method to get the desired iterator.
Iterator is used to traverse the tree and print node content.

For command  G <n>  e.g.  G 3 , following steps happens

array with 2^3 - 1 elements is created 1, 2, 3, 4, 5, 6, 7
Following tree is formed in same order.

			   1
		2			3
	4		5	6		7

The element numbers are alwats sequential. I could have made it random as well.
Formed tree is balanced always.
I/P/O  commands give respective traversal.
L command gives level wise printing (easier to visualize that way.


Composite consists of 
	Node 	- interface
	Inner	- Inner node of tree with left/right children
	Lead	- Leaf node of the tree (no children)

	Iterator - interface
	[in|pre|post]Order	- concrete iterators
	createIterator	- iterator factory.

	Implmentation details mentioned with comments in the source file.

	Client class uses Node and Iterator factory.

