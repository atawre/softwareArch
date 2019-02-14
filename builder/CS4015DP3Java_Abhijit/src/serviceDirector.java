
public class serviceDirector {
	private serviceBuilder sb;
	
	public serviceDirector(serviceBuilder service) {
		sb = service;
	}

	public String serveUser() {
		sb.setFileName();
		sb.transform();
		return sb.getResultFile();
	}
}
