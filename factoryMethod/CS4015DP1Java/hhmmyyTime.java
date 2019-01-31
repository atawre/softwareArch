import java.text.SimpleDateFormat;
import java.util.Date;

public class hhmmyyTime implements genericTime {

	public hhmmyyTime() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCurrentTime() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}

}
