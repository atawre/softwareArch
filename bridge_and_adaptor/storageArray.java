import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class storageArray {

	StringBuffer array;
	int tail;
	static String contentSeparator = ";";
	static String fileSeparator = ",";
	
	
	/*
	 * constructor for creating new storage array.
	 */
	public storageArray() {
		array = new StringBuffer();
		tail = 0;
	}

	public static void main(String[] args) {		
		storageArray nvme = new storageArray();
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
				nvme.create(name);
				break;
			case 'd':
			case 'D':
				break;
			case 'r':
			case 'R':
				System.out.println("Enter file name : ");
				name = s.next();
				nvme.read(name);
				break;
			case 'w':
			case 'W':
				System.out.println("Enter file name : ");
				name = s.next();
				nvme.write(name);
				break;
			case 'q':
			case 'Q':
				return;
			}
		}
	}

	/*
	 * Creates a new file at the end of array.
	 * filename is appended to storage array.
	 * contentSeparator ; is placed after name
	 * fileSeparator , is placed before name (except for the first file)
	 */
	public void create(String name) {
		if(tail > 0)
			array.append(fileSeparator);
		array.append(name);
		array.append(contentSeparator);
	}

	/* 
	 * This function writes a random character to file.
	 * New characters are prepended. Updates the tail pointer.
	 */
	public void write(String name) {
		int findex = array.indexOf(name);
		int len = name.length();

		Random rnd = new Random();
		char r = (char) (rnd.nextInt(26) + 'a');
		array.insert(findex+len+1, r);
		tail = array.length();
	}
	
	/*
	 * reads content of the file mentioned in name variable.
	 */
	public void read(String name) {
		int findex = array.indexOf(name);
		int len = array.length();
		Pattern pattern = Pattern.compile(name + ";" + "((.*?),|(.*$))");
		Matcher matcher = pattern.matcher(array);
		if(matcher.find()) {
			System.out.println(matcher.group(1));
		}
	}
}

