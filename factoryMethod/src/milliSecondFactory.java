
public class milliSecondFactory implements timeFactory {

	public milliSecondFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		genericTime ms = new milliSecondTime();
		return ms.getCurrentTime();
	}
}
