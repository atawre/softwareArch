package exprCalc;

public class DisplayCommand extends UserCommand {
    /** Format to use for the evaluation. */
    private String format;

    public DisplayCommand(TreeOps context, String format) {
        super.treeOps = context;
        this.format = format;
    }

    /** Evaluate the expression tree. 
     * @return */
    public UserCommand execute() throws Exception {
        treeOps.display(format);
		return null;
    }
}
