package exprCalc;

import java.util.Iterator;
import java.util.HashMap;

/**
 * @class IteratorFactory
 * 
 * @brief Implementation of the Factory Method pattern that
 *        dynamically allocates the appropriate @a Iterator strategy
 *        requested by a caller.  This variant of the pattern doesn't
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
     * Create a new @a Iterator implementation based on the caller's
     * designated @a traversalOrderRequest.
     */
    public Iterator<?> makeIterator(String traversal) {
        if (traversal.equals(""))
            /**
             * Default to in-order if user doesn't explicitly request
             * a traversal order.
             */
            traversal = "in-order";
		return traversalMap.get(traversal);
    }
}

