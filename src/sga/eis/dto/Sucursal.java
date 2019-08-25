package sga.eis.dto;

import java.util.Date;

public class Sucursal {
	private String direccion;
	private Long no;
	private String nombre;
	private String cajero;
	private Date fechaHora;
	
	public Sucursal() {
		
	}
	
	public Sucursal(String direccion, Long noSucursual, String nombreSucursal, String nombreCajero, Date fechaHora) {
		super();
		this.direccion = direccion;
		this.no = noSucursual;
		this.nombre = nombreSucursal;
		this.cajero = nombreCajero;
		this.fechaHora = fechaHora;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCajero() {
		return cajero;
	}

	public void setCajero(String cajero) {
		this.cajero = cajero;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	

}
