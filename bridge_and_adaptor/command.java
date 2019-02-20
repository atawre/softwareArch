
public abstract class command {

	public command() {

	}
	public abstract boolean createFile(String name);
	public abstract String readFile(String name);
	public abstract void writeFile(String name);
	public abstract boolean deleteFile(String name);

}
