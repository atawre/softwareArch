//
//	This class hides all the complexity associated with the maze creation.
//	Generate method represents the facade interface
//	This method deals with various grid elements i.e. cell, walls, fillers
//	I don't have a concept of a door. Lack of wall is a door.
//

public class Maze {
	private int row, column;
	//private mazeCell [][]cells;		//don't need this explicitly, as all cells should be present

	// Horizontal and vertical interior walls; each is true if the wall exists.
	protected boolean[][] hWalls;
	protected boolean[][] vWalls;
	
	public Maze(int r, int c) {
		row = r;
		column = c;
		createCells();
		createHwall();
		createVwall();
	}
	
	//all the cells are present, so this is null method
	public void createCells() {
	}
	
	//marks all the horizontal walls present
	public void createHwall() {
		hWalls = new boolean[row][column - 1];
	    for (int j = 0; j < column - 1; j++) {
	    	for (int i = 0; i < row; i++) {
	            hWalls[i][j] = true;
	            if(i==j)
		    	hWalls[i][j] = false;   //diagonal wall is removed.
	    	}
	    }
	}

	//marks all the vertical walls present
	public void createVwall() {
		vWalls = new boolean[row-1][column];
		for (int i = 0; i < row - 1; i++) {
			for (int j = 0; j < column; j++) {
				vWalls[i][j] = true;
				if(i>0 && i==j && j < column-1)
					vWalls[i][j] = false;       //interior diagonal wall is removed.
			}
		}
	}


  //
  // generate() returns a string representation of the maze.
  //
	public String generate() {
	    int i, j;
	    String s = "";

	    // Print the top exterior wall.
	    for (i = 0; i < row; i++) {
	      mazeHwallExt hExt = (mazeHwallExt) mazeFactory.getMazeComponent("hext");
	      s = s + hExt.draw(i, i);
	    }
	    s = s + "-\n|";

	    // Print the maze interior.
	    for (j = 0; j < column; j++) {
	      // Print a row of cells and vertical walls.
	      for (i = 0; i < row - 1; i++) {
		    mazeCell cell = (mazeCell) mazeFactory.getMazeComponent("cell");
	        if (vWalls[i][j]) {
	          mazeVwall vWall = (mazeVwall) mazeFactory.getMazeComponent("vwall");
	          s = s + cell.draw(i, j) + vWall.draw(i, j);
	        } else {
	          s = s + cell.draw(i, j) + cell.draw(i, j);
	        }
	      }

	      s = s + " |\n";
	      if (j < column - 1) {
	    	s = s + "+";
	        // Print a row of horizontal walls and wall corners.
	        for (i = 0; i < row; i++) {
			  mazeCell cell = (mazeCell) mazeFactory.getMazeComponent("cell");
	          mazeHfill hFill = (mazeHfill) mazeFactory.getMazeComponent("hfill");
	          if (hWalls[i][j]) {
		          mazeHwall hWall = (mazeHwall) mazeFactory.getMazeComponent("hwall");
		          s = s + hWall.draw(i, j) + hFill.draw(i, j);
	          } else {
	        	  s = s + cell.draw(i, j) + hFill.draw(i, j);
	          }
	        }
	        s = s + "\n|";
	      }
	    }

	    // Print the bottom exterior wall.  (Note that the first corner has
	    // already been printed.)
	    for (i = 0; i < row; i++) {
	      mazeHwallExt hExt = (mazeHwallExt) mazeFactory.getMazeComponent("hext");
	      s = s + hExt.draw(i, i);
		}
	    return s + "-\n";
	}
}
