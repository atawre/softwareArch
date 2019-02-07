
public interface ElapsedTimeFactory {
	static long programStart = System.currentTimeMillis();
	static long userStart = programStart;
	
	ElapsedTimeObject getElapsedTimeObject();	
	UserDefinedTimeObject getUserDefinedTimeObject();
	String getCurTime();
}
