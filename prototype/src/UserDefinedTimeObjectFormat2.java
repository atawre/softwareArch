
public class UserDefinedTimeObjectFormat2 implements UserDefinedTimeObject {
	String formatedTime;

	public UserDefinedTimeObjectFormat2(Long elapsedTime) {
		// TODO Auto-generated constructor stub
		formatedTime = Long.toString(elapsedTime);
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return formatedTime;
	}

}
