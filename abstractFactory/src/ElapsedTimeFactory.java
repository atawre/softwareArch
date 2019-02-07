
public abstract class ElapsedTimeFactory {
	protected static long programStart = System.currentTimeMillis();
	protected static long userStart;
	
	abstract ElapsedTimeObject getElapsedTimeObject();	
	abstract UserDefinedTimeObject getUserDefinedTimeObject();
	abstract void resetUserTime();
//	abstract String getCurTime();
}
