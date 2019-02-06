
public class milliSecondFactory implements timeFactory {

	Long elapsedTime;
	public milliSecondFactory() {
		// TODO Auto-generated constructor stub
		elapsedTime = System.currentTimeMillis() - programEpoch;
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return Long.toString(elapsedTime);
		
//		genericTime ms = new milliSecondTime();
//		return ms.getCurrentTime();
	}
}
