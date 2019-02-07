
public abstract class ElapsedTimeObject implements Cloneable {
	protected static Long programStart;
	public ElapsedTimeObject clone() {
		ElapsedTimeObject clone = null;
        try 
        {
            clone = (ElapsedTimeObject) super.clone(); 
        }
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
	}

	public abstract String getTime();
}
