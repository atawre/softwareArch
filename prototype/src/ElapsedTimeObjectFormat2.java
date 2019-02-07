
public class ElapsedTimeObjectFormat2 extends  ElapsedTimeObject {
	String formatedTime;
	public ElapsedTimeObjectFormat2(Long time) {
		programStart = time;
	}

	@Override
	public String getTime() {
		long elapsedTime = System.currentTimeMillis() - programStart;
		formatedTime = Long.toString(elapsedTime);
		return formatedTime;
	}

	@Override
	public String toString() {
		return "ElapsedTimeObjectFormat2 milliSeconds";
	}

}
