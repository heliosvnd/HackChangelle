package sga.eis.dto;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	protected Integer idUsuario;

	protected Integer idPersona;

	protected String username;

	protected String password;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof Usuario)) {
			return false;
		}

		final Usuario _cast = (Usuario) _other;
		if (idUsuario == null ? _cast.idUsuario != idUsuario : !idUsuario.equals(_cast.idUsuario)) {
			return false;
		}

		if (idPersona == null ? _cast.idPersona != idPersona : !idPersona.equals(_cast.idPersona)) {
			return false;
		}

		if (username == null ? _cast.username != username : !username.equals(_cast.username)) {
			return false;
		}

		if (password == null ? _cast.password != password : !password.equals(_cast.password)) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int _hashCode = 0;
		if (idUsuario != null) {
			_hashCode = 29 * _hashCode + idUsuario.hashCode();
		}

		if (idPersona != null) {
			_hashCode = 29 * _hashCode + idPersona.hashCode();
		}

		if (username != null) {
			_hashCode = 29 * _hashCode + username.hashCode();
		}

		if (password != null) {
			_hashCode = 29 * _hashCode + password.hashCode();
		}

		return _hashCode;
	}

	public UsuarioPk createPk() {
		return new UsuarioPk(idUsuario);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("ap.eis.dto.Usuario: ");
		ret.append("idUsuario=" + idUsuario);
		ret.append(", idPersona=" + idPersona);
		ret.append(", username=" + username);
		ret.append(", password=" + password);
		return ret.toString();
	}

}
