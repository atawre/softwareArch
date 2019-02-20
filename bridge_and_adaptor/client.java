import java.util.Scanner;

public class client {

	public client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		virtualFileSystem vfs = new arrayFS(new simpleArray());
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
				vfs.create(name);
				break;
			case 'd':
			case 'D':
				System.out.println("Enter file name : ");
				name = s.next();
				vfs.delete(name);				
				break;
			case 'r':
			case 'R':
				System.out.println("Enter file name : ");
				name = s.next();
				System.out.println(vfs.read(name));
				break;
			case 'w':
			case 'W':
				System.out.println("Enter file name : ");
				name = s.next();
				vfs.write(name);
				break;
			case 'q':
			case 'Q':
				return;
			}
		}
	}
}
