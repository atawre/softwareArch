package exprCalc;

/**
 * @class UserCommand
 *
 * @brief Plays the role of the "Command" in the Command pattern to
 *        define an API for "ConcreteCommand" implementations that
 *        perform an operation on the expression tree when it's
 *        executed.
 */
public abstract class UserCommand {
    /** 
     * treeOps acts as a receiver
     */
    protected TreeOps treeOps;
	
    /** Runs the command. 
     * @return */
    abstract String execute() throws Exception;

}
