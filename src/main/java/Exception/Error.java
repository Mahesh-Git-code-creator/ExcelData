package Exception;

@SuppressWarnings("serial")
public class Error extends RuntimeException {
	
	public Error(String message) {
		
		super(message);
		
	}

}

//"I think you are entered the wrong Browser Expecting Chrome/firefox/Edge.."