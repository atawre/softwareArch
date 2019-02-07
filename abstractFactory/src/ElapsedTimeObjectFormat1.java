import java.util.concurrent.TimeUnit;

public class ElapsedTimeObjectFormat1 implements ElapsedTimeObject{
//	Long elapsedTime;
	String formatedTime;
	
	public ElapsedTimeObjectFormat1(Long elapsedTime) {
		// TODO Auto-generated constructor stub
	    formatedTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(elapsedTime),
	            TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedTime)),
	            TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime)));
	}
	
	public String toString() {
		return "ElapsedTimeObjectFormat1 Hours:Minutes:Seconds";
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return formatedTime;
	}
	
}
