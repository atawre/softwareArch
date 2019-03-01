Client pseudo code for what is asked 

while True 
	Get user input
	if operator
		if root of the tree is not set
			root <- current operator
			if still any pending operators to be processed
				add new operator as one of the child for earlier operator
				order being left to right
				if earlier operator get both children it is removed from stack
				
			if there are expression on stack
				Add top expression as child for this operator
				If old root was this expression then
					root <- current operator
	else if number
		number decorated using quote
		add it to the earlier operator 
		order being left to right
		if earlier operator get both children it is removed from stack
		the fully formed operator now becomes and operand and goes to expression stack
		
		
		
Client pseudo code for Level wise printing.

	q = queue for tree nodes.
	add root to 'q'
	while True
		qsize = number of elements in queue
		if	qsize == 0
			break the loop
		while qsize > 0
			pop and print queue elements
			push it's children to queue for next cycle
		
		Print new line  for a level
		


Note : I have not included the level wise printing in the model, since this is implemented after submitting the diagram.
		However, it fits into existing design and isn't any different from the existing quoted nodes hierarchy.
		
