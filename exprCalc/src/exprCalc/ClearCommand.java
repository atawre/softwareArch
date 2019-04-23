package exprCalc;

/**
 * Evaluates the expression tree.
 * This plays the role of the "ConcreteCommand" in the Command pattern.
 */
public class ClearCommand extends UserCommand {

    public ClearCommand(TreeOps context) {
        super.treeOps = context;
    }

    /** Evaluate the expression tree. 
     * @return */
    public String execute() throws Exception {
    	treeOps.clear();
        return "";
    }
}
