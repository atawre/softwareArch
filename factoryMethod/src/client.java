import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("Enter choice"
				+ "\n 1: HH:MM:SS / 2: MS / 3: Quit >");
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			timeFactory time = null;
			switch(num) {
			case 1:
				time = new hhmmyyFactory();
			    break;
			case 2:
				time = new milliSecondFactory();				
			    break;
			case 3:
				return;
			}
		    System.out.println(time.getTime());	
		}
	}

}
