public abstract class UserDefinedTimeObject implements Cloneable {
	protected static Long userStart;
	public UserDefinedTimeObject clone() {
		UserDefinedTimeObject clone = null;
        try 
        {
            clone = (UserDefinedTimeObject) super.clone(); 
        }
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
	}

	abstract String getTime();
	public void setUserStart(long time) {
		userStart = time;
	}
}
