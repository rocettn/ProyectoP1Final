package logico;

public class Vendedor extends Persona {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1072226191846445043L;
	private String idVendedor;
	private String usernameVend;
	private String passwordVend;

	public Vendedor(String nombre, String telefono, String cedula, String direccion, String idVendedor, 
			String usernameVend, String passwordVend) {
		super(nombre, telefono, cedula, direccion);
		this.idVendedor = idVendedor;
		this.usernameVend = usernameVend;
		this.passwordVend = passwordVend;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getUsernameVend() {
		return usernameVend;
	}

	public void setUsernameVend(String usernameVend) {
		this.usernameVend = usernameVend;
	}

	public String getPasswordVend() {
		return passwordVend;
	}

	public void setPasswordVend(String passwordVend) {
		this.passwordVend = passwordVend;
	}
	
	

}
