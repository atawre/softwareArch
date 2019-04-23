package exprCalc;
import java.util.concurrent.TimeUnit;

public class ElapsedTimeMilliSeconds extends ElapsedTime{
	String formatedTime;
	
	public ElapsedTimeMilliSeconds(Long time) {
		programStart = time;
	}

	@Override
	public String getTime() {
		long elapsedTime = System.currentTimeMillis() - programStart;
		formatedTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(elapsedTime),
	    		TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedTime)),
			TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime)));	
		return formatedTime;
	}
}

