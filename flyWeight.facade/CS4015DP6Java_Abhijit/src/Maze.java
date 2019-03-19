
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
	    	}
	    }
	}

	//marks all the vertical walls present
	public void createVwall() {
		vWalls = new boolean[row-1][column];
		for (int i = 0; i < row - 1; i++) {
			for (int j = 0; j < column; j++) {
	            vWalls[i][j] = true;
	        }
		}
	}


  /**
   *  toString() returns a string representation of the maze.
   **/
	public String toString() {
	    int i, j;
	    String s = "";

	    // Print the top exterior wall.
	    for (i = 0; i < row; i++) {
	      s = s + "--";
	    }
	    s = s + "-\n|";

	    // Print the maze interior.
	    for (j = 0; j < column; j++) {
	      // Print a row of cells and vertical walls.
	      for (i = 0; i < row - 1; i++) {
	        if (vWalls[i][j]) {
	          s = s + " |";
	        } else {
	          s = s + "  ";
	        }
	      }
	      
	      s = s + " |\n+";
	      if (j < column - 1) {
	        // Print a row of horizontal walls and wall corners.
	        for (i = 0; i < row; i++) {
	          if (hWalls[i][j]) {
	            s = s + "-+";
	          } else {
	            s = s + " +";
	          }
	        }
	        s = s + "\n|";
	      }
	    }

	    // Print the bottom exterior wall.  (Note that the first corner has
	    // already been printed.)
	    for (i = 0; i < row; i++) {
	      s = s + "--";
	    }
	    return s + "\n";
	}
}


