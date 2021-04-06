package logico;

import java.util.Date;

public class OrdenCompra {
	
	private Componente componenteAPedir;
	private int cantComponente;
	private Proveedor proveedorCompra;
	private float totalOrdenCompra;
	private Administrador adminOrdenCompra;
	private Date fechaOrdenCompra;
	
	public OrdenCompra(Componente componenteAPedir, int cantComponente, Proveedor proveedorCompra,
			float totalOrdenCompra, Administrador adminOrdenCompra, Date fechaOrdenCompra) {
		super();
		this.componenteAPedir = componenteAPedir;
		this.cantComponente = cantComponente;
		this.proveedorCompra = proveedorCompra;
		this.totalOrdenCompra = totalOrdenCompra;
		this.adminOrdenCompra = adminOrdenCompra;
		this.fechaOrdenCompra = fechaOrdenCompra;
	}

	public Componente getComponenteAPedir() {
		return componenteAPedir;
	}

	public void setComponenteAPedir(Componente componenteAPedir) {
		this.componenteAPedir = componenteAPedir;
	}

	public int getCantComponente() {
		return cantComponente;
	}

	public void setCantComponente(int cantComponente) {
		this.cantComponente = cantComponente;
	}

	public Proveedor getProveedorCompra() {
		return proveedorCompra;
	}

	public void setProveedorCompra(Proveedor proveedorCompra) {
		this.proveedorCompra = proveedorCompra;
	}

	public float getTotalOrdenCompra() {
		return totalOrdenCompra;
	}

	public void setTotalOrdenCompra(float totalOrdenCompra) {
		this.totalOrdenCompra = totalOrdenCompra;
	}

	public Administrador getAdminOrdenCompra() {
		return adminOrdenCompra;
	}

	public void setAdminOrdenCompra(Administrador adminOrdenCompra) {
		this.adminOrdenCompra = adminOrdenCompra;
	}

	public Date getFechaOrdenCompra() {
		return fechaOrdenCompra;
	}

	public void setFechaOrdenCompra(Date fechaOrdenCompra) {
		this.fechaOrdenCompra = fechaOrdenCompra;
	}
	
	

}
