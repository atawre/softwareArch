
public class Leaf extends Node {
	Integer val;
	public Leaf(Integer v) {
		val = v;
	}

	public void display() {
		System.out.print(val);
		System.out.print(" ");
	}
}
