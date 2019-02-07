
public class ElapsedTimeObjectFormat2 implements ElapsedTimeObject {
	Long elapsedTime;
	String formatedTime;
	public ElapsedTimeObjectFormat2(Long time) {
		// TODO Auto-generated constructor stub
		elapsedTime = time;
		formatedTime = Long.toString(elapsedTime);
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return formatedTime;
	}

	@Override
	public String toString() {
		return "ElapsedTimeObjectFormat2 milliSeconds";
	}

}
