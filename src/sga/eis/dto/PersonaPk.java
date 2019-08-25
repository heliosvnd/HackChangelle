package sga.eis.dto;

import java.io.Serializable;

public class PersonaPk implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Integer idPersona;

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public PersonaPk() {
	}

	public PersonaPk(final Integer idPersona) {
		this.idPersona = idPersona;
	}

	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof PersonaPk)) {
			return false;
		}

		final PersonaPk _cast = (PersonaPk) _other;
		if (idPersona == null ? _cast.idPersona != idPersona : !idPersona.equals(_cast.idPersona)) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int _hashCode = 0;
		if (idPersona != null) {
			_hashCode = 29 * _hashCode + idPersona.hashCode();
		}

		return _hashCode;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("ap.eis.dto.PersonaPk: ");
		ret.append("idPersona=" + idPersona);
		return ret.toString();
	}

}
