package sga.eis.dto;

public class Ticket extends Bean{
	private static final long serialVersionUID = 1L;
	private Sucursal sucursal;
	private Persona cliente;
	private Operacion operacion;
	
	public Ticket() {
		super();
	}

	public Ticket(Sucursal sucursal, Persona cliente, Operacion operacion) {
		super();
		this.sucursal = sucursal;
		this.cliente = cliente;
		this.operacion = operacion;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Operacion getOperacion() {
		return operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}
	
	
}
