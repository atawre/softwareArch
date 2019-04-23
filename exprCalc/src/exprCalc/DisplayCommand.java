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
    public String execute() throws Exception {
        return treeOps.display(format);
    }
}
