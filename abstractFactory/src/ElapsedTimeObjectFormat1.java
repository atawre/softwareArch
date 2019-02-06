
public class ElapsedTimeObjectFormat1 implements ElapsedTimeObject{

	public ElapsedTimeObjectFormat1() {
		// TODO Auto-generated constructor stub
	}
	
	public ElapsedTimeObjectFormat1 clone() {
		ElapsedTimeObjectFormat1 elapsedTimeF1 = null;
		try {
			elapsedTimeF1 = (ElapsedTimeObjectFormat1) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elapsedTimeF1;
	}
	
	public String toString() {
		return "ElapsedTimeObjectFormat1";
	}
	
}
