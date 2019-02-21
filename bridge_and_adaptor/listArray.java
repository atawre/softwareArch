import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class listArray implements storageArray{
	List<String> array;
	int tail;
	static String contentSeparator = ";";
	static String fileSeparator = ",";
	
	
	/*
	 * constructor for creating new storage array.
	 */
	public listArray() {
		array = new ArrayList<String>();
	}

	/*
	 * Creates a new file at the end of arrayList.
	 * filename is appended to storage arrayList.
	 * contentSeparator ; is placed after name
	 * fileSeparator , is placed before name (except for the first file)
	 * Empty string is added as a content.
	 */
	public void create(String name) {
		array.add(name);
		array.add(contentSeparator);
		array.add("");
		array.add(fileSeparator);
	}

	/* 
	 * This function writes a random character to file.
	 * New characters are prepended. Updates the tail pointer.
	 */
	public void write(String name) {
		int index = getIndex(name);
		
		Random rnd = new Random();
		char r = (char) (rnd.nextInt(26) + 'a');
		String newdata = Character.toString(r) + array.get(index+2);
		array.set(index+2, newdata);
	}
	
	/*
	 * reads content of the file mentioned in name variable.
	 */
	public String read(String name) {
		int index = getIndex(name);
		if(index<0)
			return "File not found.";
		return array.get(index+2);
	}

	/*
	 * Returns true is the file is present, false otherwise.
	 */
	@Override
	public boolean search(String name) {
		for(String str : array) {
			if(name.equals(str))
				return true;
		}
		return false;
	}

	public int getIndex(String name) {
		int index = 0;
		for(String str : array) {
			if(name.equals(str))
				return index;
			index++;
		}
		return -1;
	}

	/*
	 * Completely removes file content.
	 */
	@Override
	public boolean delete(String name) {
		int index = getIndex(name);
		if(index < 0)
			return false;
		array.remove(index+3);
		array.remove(index+2);
		array.remove(index+1);
		array.remove(index);
		return true;
	}
}

