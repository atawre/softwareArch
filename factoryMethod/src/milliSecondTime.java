import java.util.Date;

public class milliSecondTime implements genericTime {

	public milliSecondTime() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCurrentTime() {
        Date date = new Date();
        long timeInMilliSeconds = date.getTime();
        return Long.toString(timeInMilliSeconds);
	}
}
