package exprCalc;

/**
 * 	This plays the role of the "ConcreteCommand" in the Command pattern.
 */
public class QuitCommand extends UserCommand {
    QuitCommand(TreeOps context) {
        super.treeOps = context;
    }

    /** Quit the input dispatching loop. 
     * @return */
    public UserCommand execute() {
		return null;
        //InputDispatcher.instance().endInputDispatching();
    }

}
