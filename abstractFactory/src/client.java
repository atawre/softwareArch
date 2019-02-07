import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
't': display current time
'r': reset elapsed time to 0 and display confirmation
'1': change to display format 1
'2': change to display format 2
'q': quit the program.
 */


public class client {

	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
		ElapsedTimeFactory eFactory = null;		
		ElapsedTimeObject eTime = null;
		UserDefinedTimeObject uTime = null;
		
		while(true) {
			char c;
			//Scanner in = new Scanner(System.in);
			try {
				c = (char) System.in.read();
				switch(c) {
				case 't':
					System.out.println("Current time");
				    break;
				case 'r':
					System.out.println("Reset elapsed time");
				    break;
				case '1':
					eFactory = new ElapsedTimeFactoryV1();
					eTime = eFactory.getElapsedTimeObject();
					System.out.println(eTime.getTime());
					break;
				case '2':
					eFactory = new ElapsedTimeFactoryV2();
					uTime = eFactory.getUserDefinedTimeObject();
					System.out.println(eTime.getTime());
					break;
				case 'q':
					System.out.println("Quiting");
					return;
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
