import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class client {

	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
		
		while(true) {
			System.out.print("Enter choice"
				+ "\n 1: HH:MM:SS / 2: MS / 3: Quit >");
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			timeFactory elapsedTime = null;
			switch(num) {
			case 1:
				elapsedTime = new hmsFactory();
			    break;
			case 2:
				elapsedTime = new milliSecondFactory();				
			    break;
			case 3:
				return;
			}
		    System.out.println(elapsedTime.getTime());	
		}
	}
}
