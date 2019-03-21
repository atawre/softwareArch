//
//the factory implements cache of maze components.
//

import java.util.HashMap;
public class mazeFactory {
	private static HashMap <String, mazeComponent> hMaze = 
					new HashMap<String, mazeComponent>();

    // Method to get a cell or wall(horizontal|vertical) 
	public static mazeComponent getMazeComponent(String type) 
    {
		mazeComponent c = null;
  
        /* If an object for [cell/wall/etc] has already been 
           created simply return its reference */
        if (hMaze.containsKey(type)) {
        	c = hMaze.get(type);
        }else {
	        /* create an object of cell/[horizontal|vertical] wall */
	        switch(type)
	        {
		        case "cell":
		            System.out.println("Cell Created"); 
		            c = new mazeCell();
		            break;
		        case "hwall": 
		            System.out.println("Horizontal wall Created"); 
		            c = new mazeHwall();
		            break;
		        case "vwall":
		            System.out.println("Vertical wall Created"); 
		            c = new mazeVwall();
		            break;
		        case "hfill":
		            System.out.println("Horizonal wall filler Created"); 
		            c = new mazeHfill();
		            break;
		        case "hext":
		            System.out.println("Horizonal wall exterior Created"); 
		            c = new mazeHwallExt();
		            break;    
		        default :
		            System.out.println("Unreachable code!"); 
	          }
        	// Once created insert it into the HashMap 
        	hMaze.put(type, c); 
        }
        return c;
    }	
}
