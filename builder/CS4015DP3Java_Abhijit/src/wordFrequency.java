import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class wordFrequency extends serviceBuilder {
	private static HashMap<String, Integer> wordTable = new HashMap();
	private static String inFile;
	private String outFile;
	private static wordFrequency INSTANCE = null;
	
	private wordFrequency() {
	}

	public static wordFrequency getInstance(String fileName) {
        if (INSTANCE == null)
        	INSTANCE = new wordFrequency();
        inFile = fileName;
        return INSTANCE;
	}

	public static void main(String[] args) {
	}

	@Override
	public void setFileName() {
		outFile = inFile + ".Z2";
	}

	@Override
	public void transform() {
		try(Scanner sc = new Scanner(new FileInputStream(inFile))){
			while(sc.hasNext()){
				Integer frequency = 0;
		    	String word = sc.next();
		    	if(wordTable.containsKey(word))
		    		frequency = wordTable.get(word);
		    	wordTable.put(word, ++frequency);
		    }
		    System.out.println(wordTable);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(outFile));
			writer.append("Word \t Frequency \n");
			for (Map.Entry<String, Integer> e : wordTable.entrySet()) {
			    String key = e.getKey();
			    Integer value = e.getValue();
			    writer.append(key + " \t " + Integer.toString(value) + "\n");
			}
			wordTable = null;
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String getResultFile() {
		return outFile;
	}
}
