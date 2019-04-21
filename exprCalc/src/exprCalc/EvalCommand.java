package exprCalc;

/**
 * Evaluates the expression tree.
 * This plays the role of the "ConcreteCommand" in the Command pattern.
 */
public class EvalCommand extends UserCommand {

    public EvalCommand(TreeOps context) {
        super.treeOps = context;
    }

    /** Evaluate the expression tree. 
     * @return */
    public UserCommand execute() throws Exception {
        treeOps.evaluate();
		return null;
    }
}
