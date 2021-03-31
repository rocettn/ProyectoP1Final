package logico;

import java.util.ArrayList;

public class OrdenCompra {
	
	private ArrayList <Componente> componentesAPedir;
	private int cantComponente;
	private ArrayList <Proveedor> proveedorCompra;
	
	public OrdenCompra(ArrayList<Componente> componentesAPedir, int cantComponente,
			ArrayList<Proveedor> proveedorCompra) {
		super();
		this.componentesAPedir = componentesAPedir;
		this.cantComponente = cantComponente;
		this.proveedorCompra = proveedorCompra;
	}

	public ArrayList<Componente> getComponentesAPedir() {
		return componentesAPedir;
	}

	public void setComponentesAPedir(ArrayList<Componente> componentesAPedir) {
		this.componentesAPedir = componentesAPedir;
	}

	public int getCantComponente() {
		return cantComponente;
	}

	public void setCantComponente(int cantComponente) {
		this.cantComponente = cantComponente;
	}

	public ArrayList<Proveedor> getProveedorCompra() {
		return proveedorCompra;
	}

	public void setProveedorCompra(ArrayList<Proveedor> proveedorCompra) {
		this.proveedorCompra = proveedorCompra;
	}
	
	
}
