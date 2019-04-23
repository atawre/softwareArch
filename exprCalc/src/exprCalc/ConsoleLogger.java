package exprCalc;
public class ConsoleLogger extends Logger {

	   public ConsoleLogger(){
	   }

	   @Override
	   protected void write(String message) {		
	      System.out.print(message);
	   }
}
