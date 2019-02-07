
public abstract class ElapsedTimeObject implements Cloneable {
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
