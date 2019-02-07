import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class client {

	public static void main(String[] args) {
		long programStart = System.currentTimeMillis();
		long userStart = programStart;

		ElapsedTimeObject eTimeF1 = new ElapsedTimeObjectFormat1(programStart);
		UserDefinedTimeObject uTimeF1 = new UserDefinedTimeObjectFormat1(userStart);
		ElapsedTimeObject eTimeF2 = new ElapsedTimeObjectFormat2(programStart);
		UserDefinedTimeObject uTimeF2 = new UserDefinedTimeObjectFormat2(userStart);
		
		ElapsedTimeObject eTime = eTimeF1.clone();
		UserDefinedTimeObject uTime = uTimeF1.clone();

		char c;

		while(true) {
			try {
				c = (char) System.in.read();
				switch(c) {
				case 't':
					System.out.println("Elapsed time		" + eTime.getTime());
					System.out.println("User elapsed time	" + uTime.getTime());
					System.out.println();
					break;
				case 'r':
					userStart = System.currentTimeMillis();
					uTime.setUserStart(userStart);
					uTimeF1.setUserStart(userStart);
					uTimeF2.setUserStart(userStart);
					System.out.println("User elapsed time is reset");
					System.out.println();
				    break;
				case '1':
					System.out.println("Elapsed time format is 		: HH:MM:SS");
					eTime = eTimeF1.clone();
					break;
				case '2':
					System.out.println("User elapsed time format is	: HH:MM:SS");
					uTime = uTimeF1.clone();
					break;
				case '3':
					System.out.println("Elapsed time format is		: Milli Seconds");
					eTime = eTimeF2.clone();
					break;
				case '4':
					System.out.println("User elapsed time format is	: Milli Seconds");
					uTime = uTimeF2.clone();
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
