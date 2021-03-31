package logico;

import java.util.ArrayList;

public class Proveedor {
	
	private String idProveedor;
	private String nombreProveedor;
	private String pais;
	private ArrayList <Componente> componentesSuple;
	private int tiempoDemEntrega;
	
	public Proveedor(String idProveedor, String nombreProveedor, String pais, ArrayList<Componente> componentesSuple,
			int tiempoDemEntrega) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.pais = pais;
		this.componentesSuple = componentesSuple;
		this.tiempoDemEntrega = tiempoDemEntrega;
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

	public int getTiempoDemEntrega() {
		return tiempoDemEntrega;
	}

	public void setTiempoDemEntrega(int tiempoDemEntrega) {
		this.tiempoDemEntrega = tiempoDemEntrega;
	}
	
	
}
