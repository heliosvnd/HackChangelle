package sga.eis.dto;

import java.io.Serializable;

public class UsuarioPk implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Integer idUsuario;

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public UsuarioPk() {
	}

	public UsuarioPk(final Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof UsuarioPk)) {
			return false;
		}

		final UsuarioPk _cast = (UsuarioPk) _other;
		if (idUsuario == null ? _cast.idUsuario != idUsuario : !idUsuario.equals(_cast.idUsuario)) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int _hashCode = 0;
		if (idUsuario != null) {
			_hashCode = 29 * _hashCode + idUsuario.hashCode();
		}

		return _hashCode;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("ap.eis.dto.UsuarioPk: ");
		ret.append("idUsuario=" + idUsuario);
		return ret.toString();
	}

}
