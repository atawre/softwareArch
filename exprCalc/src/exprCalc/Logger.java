package exprCalc;

public abstract class Logger {
	   //next element in chain or responsibility
	   protected Logger nextLogger;

	   public void setNextLogger(Logger nextLogger){
	      this.nextLogger = nextLogger;
	   }

	   public Logger getNextLogger(){
		   return nextLogger;
	   }

	   public void logMessage(int level, String message){
	      write(message);
	      if(nextLogger !=null)
	         nextLogger.logMessage(level, message);
	   }

	   abstract protected void write(String message);
}
