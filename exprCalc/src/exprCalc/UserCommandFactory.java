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
    UserCommandFactory(final TreeOps treeOps) {   	
    	/** Initialize the TreeOps member. */
        this.treeOps = treeOps;
   		
    	/** 
         * An "eval" string maps to a command object that creates
         * an @a EvalCommand implementation.
         */
        commandMap.put("eval", new EvalCommand(treeOps));
    }

    /** 
     * Create a new @a UserCommand object based on the caller's
     * designated @a inputString.
     * @throws Exception 
     */
    public UserCommand makeUserCommand(String inputString) throws Exception {
        String parameters = "";
        String commandRequest = inputString;

        int spacepos = inputString.indexOf(' ');
        if (spacepos >= 0) {
            parameters = inputString.substring(spacepos + 1);
            commandRequest = inputString.substring(0, 
                                                   spacepos);
        }
        /** Try to find the pre-allocated factory command. */
        UserCommand command = 
            commandMap.get(commandRequest);

        if(command != null)
            /** If we find it then execute it. */
            return command.execute();
        else
            /** 
             * Otherwise, the user gave an unknown request, so we'll
             * quit.
             */
            return new QuitCommand(treeOps);
    }
}
