package exprCalc;

public class BuildCommand extends UserCommand {
    public BuildCommand(TreeOps context) {
        super.treeOps = context;
    }

    /** Evaluate the expression tree. 
     * @return */
    public UserCommand execute() throws Exception {
        treeOps.build();
		return null;
    }
}
