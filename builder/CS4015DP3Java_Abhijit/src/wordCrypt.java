
public class wordCrypt extends serviceBuilder{
	private static String inFile;
	private String outFile;
	private static wordCrypt INSTANCE = null;
	
	private wordCrypt() {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getResultFile() {
		return outFile;
	}

}
