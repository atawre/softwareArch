
public abstract class serviceBuilder {

	public abstract void setFileName();
	public abstract void transform();
	public abstract String getResultFile();
	
	public serviceBuilder() {
		// TODO Auto-generated constructor stub
	}

	public static serviceBuilder getInstance(String fileName, String type) {
		switch(type) {
		case "count":
			return wordCount.getInstance(fileName);
		case "frequency":
			return wordFrequency.getInstance(fileName);
		case "crypt":
			return wordCrypt.getInstance(fileName);
		}
		return null;
	}
}
