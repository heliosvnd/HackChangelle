package sga.eis.exceptions;

public class PersonaDaoException extends DaoException {
	private static final long serialVersionUID = 1L;

	public PersonaDaoException(String message) {
		super(message);
	}

	public PersonaDaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
