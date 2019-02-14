import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class wordCount extends serviceBuilder {
	private static int count = 0;
	private static String inFile;
	private String outFile;
	private static wordCount INSTANCE = null;
	
	private wordCount() {
	}

	public static wordCount getInstance(String fileName) {
        if (INSTANCE == null)
        	INSTANCE = new wordCount();
        inFile = fileName;
        return INSTANCE;
	}
	

	@Override
	public void setFileName() {
		outFile = inFile + ".Z1";
	}

	@Override
	public void transform() {
		File file = new File(inFile);
		try(Scanner sc = new Scanner(new FileInputStream(file))){
			count = 0;
		    while(sc.hasNext()){
		        sc.next();
		        count++;
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(outFile));
			writer.write("The word count is : " + Integer.toString(count) + "\n");
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
