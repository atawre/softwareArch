import java.util.concurrent.TimeUnit;

public class UserDefinedTimeObjectFormat1 implements UserDefinedTimeObject {
	String formatedTime;

	public UserDefinedTimeObjectFormat1(Long elapsedTime) {
		// TODO Auto-generated constructor stub
	    formatedTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(elapsedTime),
	            TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedTime)),
	            TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime)));
		
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return formatedTime;
	}
}
