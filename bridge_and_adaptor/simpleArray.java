import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class simpleArray implements storageArray{

	StringBuffer array;
	int tail;
	static String contentSeparator = ";";
	static String fileSeparator = ",";
	
	
	/*
	 * constructor for creating new storage array.
	 */
	public simpleArray() {
		array = new StringBuffer();
		tail = 0;
	}

	/*
	 * Creates a new file at the end of array.
	 * filename is appended to storage array.
	 * contentSeparator ; is placed after name
	 * fileSeparator , is placed before name (except for the first file)
	 */
	public void create(String name) {
		if(tail > 0)
			array.append(fileSeparator);
		array.append(name);
		array.append(contentSeparator);
	}

	/* 
	 * This function writes a random character to file.
	 * New characters are prepended. Updates the tail pointer.
	 */
	public void write(String name) {
		int findex = array.indexOf(name);
		int len = name.length();

		Random rnd = new Random();
		char r = (char) (rnd.nextInt(26) + 'a');
		array.insert(findex+len+1, r);
		tail = array.length();
	}
	
	/*
	 * reads content of the file mentioned in name variable.
	 */
	public String read(String name) {
		String data = null;
		Pattern pattern = Pattern.compile(name + ";" + "((.*?),|(.*$))");
		Matcher matcher = pattern.matcher(array);
		if(matcher.find()) {
			data = matcher.group(1);
		}
		return data;
	}
	
	@Override
	public boolean search(String name) {
		Pattern pattern = Pattern.compile(name + ";");
		Matcher matcher = pattern.matcher(array);
		return matcher.find();
	}

	@Override
	public boolean delete(String name) {
		int findex = array.indexOf(name);
		int len1 = name.length();
		String data = null;
		Pattern pattern = Pattern.compile(name + ";" + "((.*?),|(.*$))");
		Matcher matcher = pattern.matcher(array);
		if(matcher.find()) {
			data = matcher.group(1);
		}

		int len2 = data.length();
		int end  = findex + len1 + len2;
		array.delete(findex, end);
		return false;
	}
}

