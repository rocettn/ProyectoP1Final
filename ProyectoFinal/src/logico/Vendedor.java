package logico;

public class Vendedor extends Persona {
	
	private String idVendedor;

	public Vendedor(String nombre, String telefono, String cedula, String direccion, String idVendedor) {
		super(nombre, telefono, cedula, direccion);
		this.idVendedor = idVendedor;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	

}
