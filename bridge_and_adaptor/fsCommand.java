
public class fsCommand extends command{
	virtualFileSystem vfs;
	public fsCommand(virtualFileSystem myvfs) {
		vfs = myvfs;
	}
	
	public boolean createFile(String name) {
		return vfs.create(name);
	}
	public String readFile(String name) {
		return vfs.read(name);
	}
	public void writeFile(String name) {
		vfs.write(name);
	}
	public boolean deleteFile(String name) {
		return vfs.delete(name);
	}
}

