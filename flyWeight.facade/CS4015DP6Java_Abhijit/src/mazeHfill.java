//
// horizontal walls i.e. "-" have a filler i.e. "+"
//

public class mazeHfill extends mazeComponent {

	public mazeHfill() {
	}

	@Override
	public String draw(int x, int y) {
		return "+";
	}

}
