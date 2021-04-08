package logico;

public class Cliente extends Persona{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3265925181038712909L;
	
	private float creditoCliente;
	
	public Cliente(String nombre, String telefono, String cedula, String direccion, 
			float creditoCliente) {
		super(nombre, telefono, cedula, direccion);
		this.creditoCliente = creditoCliente;
	}

	public float getCreditoCliente() {
		return creditoCliente;
	}

	public void setCreditoCliente(float creditoCliente) {
		this.creditoCliente = creditoCliente;
	}

}
