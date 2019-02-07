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
		ElapsedTimeFactory factory   = null;
		ElapsedTimeFactory factoryV1 = new ElapsedTimeFactoryV1();;
		ElapsedTimeFactory factoryV2 = new ElapsedTimeFactoryV2();;
		factory = factoryV1;
		
		ElapsedTimeObject eTime = null;
		UserDefinedTimeObject uTime = null;
		char c;

		while(true) {
			try {
				c = (char) System.in.read();
				switch(c) {
				case 't':
//					System.out.println("Current time "+ factory.getCurTime());
					eTime = factory.getElapsedTimeObject();
					uTime = factory.getUserDefinedTimeObject();
					System.out.println("Elapsed program time " + eTime.getTime());
					System.out.println("Elapsed user time    " + uTime.getTime());
					System.out.println();
					break;
				case 'r':
					System.out.println("User elapsed time is reset");
					System.out.println();
					factory.resetUserTime();
				    break;
				case '1':
					factory = factoryV1;
					System.out.println("Format changed to HH:MM:SS");
					System.out.println();
					break;
				case '2':
					factory = factoryV2;
					System.out.println("Format changed to milli seconds");
					System.out.println();
					break;
				case 'q':
					System.out.println("Quiting");
					return;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
