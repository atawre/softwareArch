import java.util.concurrent.TimeUnit;

public class UserDefinedTimeObjectFormat1 extends UserDefinedTimeObject {
	String formatedTime;

	public UserDefinedTimeObjectFormat1(Long time) {
		userStart = time;
	}

	@Override
	public String getTime() {
		long elapsedUserTime = System.currentTimeMillis() - userStart;
	    formatedTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(elapsedUserTime),
	            TimeUnit.MILLISECONDS.toMinutes(elapsedUserTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedUserTime)),
	            TimeUnit.MILLISECONDS.toSeconds(elapsedUserTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedUserTime)));
		return formatedTime;
	}
}
