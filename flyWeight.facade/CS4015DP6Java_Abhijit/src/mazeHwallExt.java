//
// Exterior horizontal wall don't have filler and hence separate class.
//
public class mazeHwallExt extends mazeComponent{

	public mazeHwallExt() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String draw(int x, int y) {
		return "--";
	}

}
