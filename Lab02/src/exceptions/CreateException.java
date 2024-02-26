package exceptions;

public class CreateException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CreateException(String msg) {
		super(msg);
	}

}
