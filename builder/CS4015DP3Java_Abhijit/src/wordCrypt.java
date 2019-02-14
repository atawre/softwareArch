import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class wordCrypt extends serviceBuilder{
	private static String inFile;
	private String outFile;
	private static wordCrypt INSTANCE = null;
	private static LinkedHashMap<String, String> wordCipher = new LinkedHashMap<>();
	private static HashMap<Integer, Integer> positionCipher = new HashMap<>();
	
	//1->5, 2->3, 3->1, 4->7, 5->2, 6->4, 7->6
	private wordCrypt() {
		positionCipher.put(1, 5);
		positionCipher.put(2,3);
		positionCipher.put(3,1);
		positionCipher.put(4,7);
		positionCipher.put(5,2);
		positionCipher.put(6,4);
		positionCipher.put(7,6);
	}

	public static wordCrypt getInstance(String fileName) {
        if (INSTANCE == null)
        	INSTANCE = new wordCrypt();
        inFile = fileName;
        return INSTANCE;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFileName() {
		outFile = inFile + ".Z3";
	}

	@Override
	public void transform() {
		try(Scanner sc = new Scanner(new FileInputStream(inFile))){
			while(sc.hasNext()) {
		    	String word = sc.next();
				if(wordCipher.containsKey(word))
					continue;
				wordCipher.put(word, null);
			}

			ArrayList<String> keyList = new ArrayList<String>(wordCipher.keySet());
			int uniquePosition = 1;
			for (Map.Entry<String, String> e : wordCipher.entrySet()) {
				System.out.println(positionCipher);
				System.out.println(uniquePosition);
				System.out.println(uniquePosition%8);
				int newPosition = positionCipher.get(uniquePosition%8);
				System.out.println(newPosition);
				
				String key = e.getKey();
				String replacement = keyList.get(newPosition);
				wordCipher.replace(key, replacement);
				uniquePosition++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(outFile));
			Scanner sc = new Scanner(new FileInputStream(inFile));
			while(sc.hasNext()) {
		    	String word = sc.next();
		    	String replace = wordCipher.get(word);
		    	writer.append(replace + " ");
			}		
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
