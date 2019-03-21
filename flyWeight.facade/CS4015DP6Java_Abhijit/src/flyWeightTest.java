//
// This acts as a client for the assignment.
import java.util.Scanner;
//
public class flyWeightTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("M <n>");
		System.out.println("G <n>");
		System.out.println("Q");
		System.out.println("");
		
		int dim = 6;
		while(true) {
			Scanner scan = new Scanner(System.in);
			char cmd = scan.next().charAt(0);
			switch(cmd) {
				case 'm':
				case 'M':
					dim = scan.nextInt();
					Maze maze = new Maze(dim, dim);
					System.out.println(maze.generate());
					break;
				case 'g':
				case 'G':
					dim = scan.nextInt();
					System.out.println("TBD");
					break;
				case 'q':
				case 'Q' :
					return;
			}

		}
	}

}
