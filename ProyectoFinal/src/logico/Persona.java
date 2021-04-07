package logico;

import java.io.Serializable;

public abstract class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9153292647875246716L;
	protected String nombre;
	protected String telefono;
	protected String cedula;
	protected String direccion;

	public Persona(String nombre, String telefono, String cedula, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.cedula = cedula;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


}

