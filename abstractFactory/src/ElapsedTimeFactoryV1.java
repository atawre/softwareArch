import java.util.concurrent.TimeUnit;

public class ElapsedTimeFactoryV1 implements ElapsedTimeFactory {

	Long elapsedTime;
	public ElapsedTimeFactoryV1() {
		// TODO Auto-generated constructor stub
		elapsedTime = System.currentTimeMillis() - programStart;
	}

	@Override
	public ElapsedTimeObject getElapsedTimeObject() {
		// TODO Auto-generated method stub
		ElapsedTimeObject time = new ElapsedTimeObjectFormat1(elapsedTime);
        return time;
	}

	@Override
	public UserDefinedTimeObject getUserDefinedTimeObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurTime() {
		// TODO Auto-generated method stub
		return null;
	}
}
