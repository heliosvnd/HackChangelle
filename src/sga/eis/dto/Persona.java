package sga.eis.dto;

import java.io.Serializable;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	protected Integer idPersona;

	protected String nombre;

	protected String apellido;
	
	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getPrimerapellido() {
		return primerapellido;
	}

	public void setPrimerapellido(String primerapellido) {
		this.primerapellido = primerapellido;
	}

	public String getSegundoapellido() {
		return segundoapellido;
	}

	public void setSegundoapellido(String segundoapellido) {
		this.segundoapellido = segundoapellido;
	}

	public String getIden() {
		return iden;
	}

	public void setIden(String iden) {
		this.iden = iden;
	}

	public String getNoiden() {
		return noiden;
	}

	public void setNoiden(String noiden) {
		this.noiden = noiden;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getNocuenta() {
		return nocuenta;
	}

	public void setNocuenta(String nocuenta) {
		this.nocuenta = nocuenta;
	}

	public String getNoclabeinterbancaria() {
		return noclabeinterbancaria;
	}

	public void setNoclabeinterbancaria(String noclabeinterbancaria) {
		this.noclabeinterbancaria = noclabeinterbancaria;
	}

	protected String curp;
	protected String primerapellido;
	protected String segundoapellido;
	protected String iden;
	protected String noiden;
	protected String nss;
	protected String nocuenta;
	protected String noclabeinterbancaria;

	public Persona(String primerApellido, String segundoApellido, String nombre, String iden, String noIden,
			String noCuenta, String noClabeInterbancaria) {
		super();
		this.primerapellido = primerApellido;
		this.segundoapellido = segundoApellido;
		this.nombre = nombre;
		this.iden = iden;
		this.noiden = noIden;
		this.nocuenta = noCuenta;
		this.noclabeinterbancaria = noClabeInterbancaria;
	}
	
	public Persona() {	
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof Persona)) {
			return false;
		}

		final Persona _cast = (Persona) _other;
		if (idPersona == null ? _cast.idPersona != idPersona : !idPersona.equals(_cast.idPersona)) {
			return false;
		}

		if (nombre == null ? _cast.nombre != nombre : !nombre.equals(_cast.nombre)) {
			return false;
		}

		if (apellido == null ? _cast.apellido != apellido : !apellido.equals(_cast.apellido)) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int _hashCode = 0;
		if (idPersona != null) {
			_hashCode = 29 * _hashCode + idPersona.hashCode();
		}

		if (nombre != null) {
			_hashCode = 29 * _hashCode + nombre.hashCode();
		}

		if (apellido != null) {
			_hashCode = 29 * _hashCode + apellido.hashCode();
		}

		return _hashCode;
	}

	public PersonaPk createPk() {
		return new PersonaPk(idPersona);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("ap.eis.dto.Persona: ");
		ret.append("idPersona=" + idPersona);
		ret.append(", nombre=" + nombre);
		ret.append(", apellido=" + apellido);
		return ret.toString();
	}

}
