
public class UserDefinedTimeObjectFormat2 extends UserDefinedTimeObject {
	String formatedTime;

	public UserDefinedTimeObjectFormat2(Long time) {
		userStart = time;
		long elapsedUserTime = System.currentTimeMillis() - userStart;
		formatedTime = Long.toString(elapsedUserTime);
	}

	@Override
	public String getTime() {
		long elapsedUserTime = System.currentTimeMillis() - userStart;
		formatedTime = Long.toString(elapsedUserTime);
		return formatedTime;
	}
}
