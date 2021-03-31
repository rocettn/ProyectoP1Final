package logico;

public class Cliente extends Persona{
	
	private String componentesComprado;
	private float creditoCliente;
	private float valorMaxCredDisp;
	
	public Cliente(String nombre, String telefono, String cedula, String direccion, String componentesComprado,
			float creditoCliente, float valorMaxCredDisp) {
		super(nombre, telefono, cedula, direccion);
		this.componentesComprado = componentesComprado;
		this.creditoCliente = creditoCliente;
		this.valorMaxCredDisp = valorMaxCredDisp;
	}

	public String getComponentesComprado() {
		return componentesComprado;
	}

	public void setComponentesComprado(String componentesComprado) {
		this.componentesComprado = componentesComprado;
	}

	public float getCreditoCliente() {
		return creditoCliente;
	}

	public void setCreditoCliente(float creditoCliente) {
		this.creditoCliente = creditoCliente;
	}

	public float getValorMaxCredDisp() {
		return valorMaxCredDisp;
	}

	public void setValorMaxCredDisp(float valorMaxCredDisp) {
		this.valorMaxCredDisp = valorMaxCredDisp;
	}
	
	

}
