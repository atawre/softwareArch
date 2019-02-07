
public class ElapsedTimeObjectFormat2 extends  ElapsedTimeObject {
//	Long elapsedTime;
	String formatedTime;
	public ElapsedTimeObjectFormat2(Long elapsedTime) {
		// TODO Auto-generated constructor stub
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
