package exprCalc;
public class TimeStampLogger extends Logger {
	   ElapsedTime eTime;
	   public TimeStampLogger(ElapsedTime eTime){
		   this.eTime = eTime;
	   }

	   //use prototype pattern for logging the elapsed times with messages.
	   @Override
	   protected void write(String message) {		
	      System.out.println(eTime.clone().getTime() + " " + message);
	   }
}
