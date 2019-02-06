import java.util.concurrent.TimeUnit;

public class hmsFactory implements timeFactory{

	Long elapsedTime;
	public hmsFactory() {
		// TODO Auto-generated constructor stub
		elapsedTime = System.currentTimeMillis() - programEpoch;
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		
	    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(elapsedTime),
	            TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedTime)),
	            TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime)));

        return hms;
//		genericTime hhmmyy = new hhmmyyTime();
//		return hhmmyy.getCurrentTime();
	}

}
