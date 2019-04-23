package exprCalc;

import java.util.Iterator;
import java.util.HashMap;

/**
 * @class State
 * 		  Used to define the various states that affect how users operations are
 *        processed.
 **/

public abstract class State {
	
    public abstract void build(TreeOps context, String string);
    
	public abstract double evaluate(TreeOps treeOps);

	public abstract String display(TreeOps treeOps, String format) ;

	public void quit(TreeOps treeOps) {
		System.exit(0);
	}
	public abstract void clear(TreeOps context);
}
