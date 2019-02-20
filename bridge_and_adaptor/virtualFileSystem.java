
public abstract class virtualFileSystem {
	protected storageArray array;

	public virtualFileSystem() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public abstract boolean create(String fileName);
	public abstract String read(String fileName);
	public abstract void write(String fileName);
	public abstract boolean delete(String fileName);
}
