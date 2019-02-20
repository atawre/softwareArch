/**
 * 
 */

/**
 * @author ataware
 *
 */
public class arrayFS extends virtualFileSystem {

	public arrayFS(storageArray myArray) {
		array = myArray;
	}

	/*
	 * Creates a new file.
	 * First searches if file is already present.
	 * Creates new if the file does not exist.
	 */
	@Override
	public boolean create(String fileName) {
		if(array.search(fileName))
			return true;
		array.create(fileName);
		return true;
	}

	@Override
	public String read(String fileName) {
		return array.read(fileName);
	}

	@Override
	public void write(String fileName) {
		array.write(fileName);
	}

	@Override
	public boolean delete(String fileName) {
		if(array.search(fileName)) {
			return array.delete(fileName);
		}
		return false;
	}
}
