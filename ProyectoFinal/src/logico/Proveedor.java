package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Proveedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1897831608459163347L;
	private String idProveedor;
	private String nombreProveedor;
	private String pais;
	private ArrayList <Componente> componentesSuple;
	
	public Proveedor(String idProveedor, String nombreProveedor, String pais) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.pais = pais;
		this.componentesSuple = new ArrayList<Componente>();

	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public ArrayList<Componente> getComponentesSuple() {
		return componentesSuple;
	}

	public void setComponentesSuple(ArrayList<Componente> componentesSuple) {
		this.componentesSuple = componentesSuple;
	}
	
	public void insertarcomponentes(Componente cp) {
		componentesSuple.add(cp);
	}

	
}
