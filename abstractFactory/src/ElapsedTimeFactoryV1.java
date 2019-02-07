import java.util.concurrent.TimeUnit;

public class ElapsedTimeFactoryV1 extends ElapsedTimeFactory {
	Long elapsedTime;
	Long elapsedUserTime;
	public ElapsedTimeFactoryV1() {
		// TODO Auto-generated constructor stub
		userStart = programStart;
	}
	
	@Override
	public ElapsedTimeObject getElapsedTimeObject() {
		// TODO Auto-generated method stub
		elapsedTime = System.currentTimeMillis() - programStart;
		
		ElapsedTimeObject time = new ElapsedTimeObjectFormat1(elapsedTime);
        return time;
	}

	@Override
	public UserDefinedTimeObject getUserDefinedTimeObject() {
		// TODO Auto-generated method stub
		elapsedUserTime = System.currentTimeMillis() - userStart;
		UserDefinedTimeObject time = new UserDefinedTimeObjectFormat1(elapsedUserTime);
        return time;
	}

//	@Override
//	public String getCurTime() {
//		Long curTime = System.currentTimeMillis();
//	    return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(curTime),
//	            TimeUnit.MILLISECONDS.toMinutes(curTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(curTime)),
//	            TimeUnit.MILLISECONDS.toSeconds(curTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(curTime)));
//	}

	@Override
	public void resetUserTime() {
		// TODO Auto-generated method stub
		userStart = System.currentTimeMillis();
	}
}
