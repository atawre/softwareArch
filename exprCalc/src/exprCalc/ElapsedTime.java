package exprCalc;

public abstract class ElapsedTime implements Cloneable {
	protected static Long programStart;
	public ElapsedTime clone() {
		ElapsedTime clone = null;
		try 
		{
            		clone = (ElapsedTime) super.clone(); 
		}
		catch (CloneNotSupportedException e)  
		{ 
            		e.printStackTrace(); 
		}
		return clone; 
	}

	public abstract String getTime();
}

