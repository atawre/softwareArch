package exprCalc;

import java.util.Iterator;
import java.util.HashMap;

/**
 * @class IteratorFactory
 * 
 * @brief Implementation of the Factory Method pattern that
 *        dynamically allocates the Iterator. 
 *        This variant of the pattern doesn't
 *        use inheritance, so it plays the role of the ConcreteCreator
 *        in the Factory Method pattern.
 */
public class IteratorFactory {
    private HashMap<String, Iterator> traversalMap = 
        new HashMap<String, Iterator>();
	
    /** Ctor */
	public IteratorFactory(ExpressionTree tree) {
        traversalMap.put("in-order", (Iterator) new inOrder(tree.root));
        traversalMap.put("pre-order", (Iterator) new preOrder(tree.root));
        traversalMap.put("post-order",  (Iterator) new postOrder(tree.root));
    }

    /**
     * Create a new Iterator based on the 
     * designated traversal.
     */
    public Iterator makeIterator(String traversal) {
        if (traversal.equals(""))
            /**
             * Default to in-order if user doesn't explicitly request
             * a traversal order.
             */
            traversal = "in-order";
		return traversalMap.get(traversal);
    }
}

