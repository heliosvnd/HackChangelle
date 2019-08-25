package sga.eis.dto;

import java.util.Date;

public class Operacion {
	public enum Tipo {
		RETIRO,
		DEPOSITO,
	    PAGO,
	    CONSULTA
	}
	private String no;
	private String autorizacion;
	private Date fecha;
	private Double importe;
	private Tipo tipo;

	public Operacion(String no, String autorizacion, Date fecha, Double importe, Tipo tipo) {
		super();
		this.no = no;
		this.autorizacion = autorizacion;
		this.fecha = fecha;
		this.importe = importe;
		this.tipo = tipo;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
