
public class serviceDemo {

	public static void main(String[] args) {
		String inFile = args[0];
		String serviceType = args[1];
		serviceBuilder builder = serviceBuilder.getInstance(inFile, serviceType);
		serviceDirector director = new serviceDirector(builder);
		String result = director.serveUser();
	}
}

