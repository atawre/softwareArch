
public class ElapsedTimeFactoryV2 extends ElapsedTimeFactory{
	Long elapsedTime;
	Long elapsedUserTime;

	public ElapsedTimeFactoryV2() {
		userStart = programStart;
	}

	@Override
	public ElapsedTimeObject getElapsedTimeObject() {
		elapsedTime = System.currentTimeMillis() - programStart;
		ElapsedTimeObject time = new ElapsedTimeObjectFormat2(elapsedTime);
		return time;
	}

	@Override
	public UserDefinedTimeObject getUserDefinedTimeObject() {
		elapsedUserTime = System.currentTimeMillis() - userStart;
		UserDefinedTimeObject time = new UserDefinedTimeObjectFormat2(elapsedUserTime);
		return time;
	}

//	@Override
//	public String getCurTime() {
//		return Long.toString(System.currentTimeMillis());
//	}

	@Override
	public void resetUserTime() {
		// TODO Auto-generated method stub
		userStart = System.currentTimeMillis();
	}
}

