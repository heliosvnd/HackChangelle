package sga.eis.exceptions;

public class UsuarioDaoException extends DaoException {
	private static final long serialVersionUID = 1L;

	public UsuarioDaoException(String message) {
		super(message);
	}

	public UsuarioDaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
