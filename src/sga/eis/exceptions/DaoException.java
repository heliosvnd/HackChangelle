package sga.eis.exceptions;

public class DaoException extends Exception {
	private static final long serialVersionUID = 1L;
	protected Throwable throwable;

	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, Throwable throwable) {
		super(message);
		this.throwable = throwable;
	}

	public Throwable getCause() {
		return throwable;
	}

}
