
public class mazeHwall extends mazeComponent{
	private int x, y;									//extrinsic state
	private static String content = new String("--");	//shared intrinsic state
	@Override
	public String draw(int x, int y) {
		return "-";
	}
}
