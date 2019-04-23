package exprCalc;

import java.util.HashMap;
import java.util.Vector;

/**
 *  Factory Method pattern.
 *  This variant of the pattern doesn't use inheritance, 
 *  so it plays the role of the ConcreteCreator
 *  in the Factory Method pattern.
 */
public class UserCommandFactory {
    /** 
     * Holds the expression tree that is the target of the commands.
     */
    private TreeOps treeOps;

    /**
     * Map used to validate input requests for @a UserCommand
     * implementations and dispatch the execute() method of the
     * requested user command.
     */
    private HashMap<String, UserCommand> commandMap =
        new HashMap<String, UserCommand>();

    /** Ctor */
    UserCommandFactory(TreeOps treeOps) {   	
    	/** Initialize the TreeOps member. */
    	this.treeOps = treeOps;
        commandMap.put("clear", new ClearCommand(treeOps));
        commandMap.put("quit", new QuitCommand(treeOps));
        commandMap.put("eval", new EvalCommand(treeOps));
        commandMap.put("build", new BuildCommand(treeOps));
        commandMap.put("display", new DisplayCommand(treeOps, ""));
        commandMap.put("inorder", new DisplayCommand(treeOps, "inorder"));
        commandMap.put("preorder", new DisplayCommand(treeOps, "preorder"));
        commandMap.put("postorder", new DisplayCommand(treeOps, "postorder"));
    }

    public UserCommand makeUserCommand(String commandRequest) throws Exception {

        /** Try to find the pre-allocated factory command. */
        return commandMap.get(commandRequest);

    }
}
