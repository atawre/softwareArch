
public interface ElapsedTimeFactory {
	static long programEpoch = System.currentTimeMillis();

	ElapsedTimeObject getElapsedTime();	
	UserDefinedTimeObject getUserDefinedTime();
}
