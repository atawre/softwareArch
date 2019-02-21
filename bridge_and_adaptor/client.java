import java.util.Scanner;

public class client {

	public client() {

	}

	public static void main(String[] args) {
		//This is an example with storage array implemented as list.
		//You can change it to include the implementation using simple Array too with following change
		//virtualFileSystem vfs = new arrayFS(new simpleArray());

		virtualFileSystem vfs = new arrayFS(new listArray());
		command cmd = new fsCommand(vfs);
		while(true) {
			System.out.println("\n" +
				"C <name> : create a file called <name>\n" + 
				"D <name> : delete a file called <name>\n" + 
				"R <name> : read a file called <name> (print the content of the file)\n" + 
				"W <name> : write a file called <name> (add one random ASCII character to the file)\n" +
				"Q : Quit\n"
				);

			Scanner s = new Scanner(System.in); 
			char 	c = s.next().charAt(0);
			String name = null;

			switch(c) {
			case 'c' :
			case 'C' :
				System.out.println("Enter file name : ");
				name = s.next();
				cmd.createFile(name);
				break;
			case 'd':
			case 'D':
				System.out.println("Enter file name : ");
				name = s.next();
				cmd.deleteFile(name);
				break;
			case 'r':
			case 'R':
				System.out.println("Enter file name : ");
				name = s.next();
				System.out.println(cmd.readFile(name));
				break;
			case 'w':
			case 'W':
				System.out.println("Enter file name : ");
				name = s.next();
				cmd.writeFile(name);
				break;
			case 'q':
			case 'Q':
				return;
			}
		}
	}
}
