
public class hhmmyyFactory implements timeFactory{

	public hhmmyyFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		genericTime hhmmyy = new hhmmyyTime();
		return hhmmyy.getCurrentTime();
	}

}
