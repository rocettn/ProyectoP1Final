package logico;

import java.util.ArrayList;

public class Tienda {
	
	private ArrayList <Cliente> clientesTienda;
	private ArrayList <Vendedor> vendedoresTienda;
	private ArrayList <Componente> componentesTienda;
	private ArrayList <Venta> ventasTienda;
	private ArrayList <Proveedor> proveedoresTienda;
	private ArrayList <Combo> combosTienda;
	private ArrayList <OrdenCompra> OrdenesComprasTienda;
	
	public Tienda(ArrayList<Cliente> clientesTienda, ArrayList<Vendedor> vendedoresTienda,
			ArrayList<Componente> componentesTienda, ArrayList<Venta> ventasTienda,
			ArrayList<Proveedor> proveedoresTienda, ArrayList<Combo> combosTienda,
			ArrayList<OrdenCompra> ordenesComprasTienda) {
		super();
		this.clientesTienda = clientesTienda;
		this.vendedoresTienda = vendedoresTienda;
		this.componentesTienda = componentesTienda;
		this.ventasTienda = ventasTienda;
		this.proveedoresTienda = proveedoresTienda;
		this.combosTienda = combosTienda;
		this.OrdenesComprasTienda = ordenesComprasTienda;
	}

	public ArrayList<Cliente> getClientesTienda() {
		return clientesTienda;
	}

	public void setClientesTienda(ArrayList<Cliente> clientesTienda) {
		this.clientesTienda = clientesTienda;
	}

	public ArrayList<Vendedor> getVendedoresTienda() {
		return vendedoresTienda;
	}

	public void setVendedoresTienda(ArrayList<Vendedor> vendedoresTienda) {
		this.vendedoresTienda = vendedoresTienda;
	}

	public ArrayList<Componente> getComponentesTienda() {
		return componentesTienda;
	}

	public void setComponentesTienda(ArrayList<Componente> componentesTienda) {
		this.componentesTienda = componentesTienda;
	}

	public ArrayList<Venta> getVentasTienda() {
		return ventasTienda;
	}

	public void setVentasTienda(ArrayList<Venta> ventasTienda) {
		this.ventasTienda = ventasTienda;
	}

	public ArrayList<Proveedor> getProveedoresTienda() {
		return proveedoresTienda;
	}

	public void setProveedoresTienda(ArrayList<Proveedor> proveedoresTienda) {
		this.proveedoresTienda = proveedoresTienda;
	}

	public ArrayList<Combo> getCombosTienda() {
		return combosTienda;
	}

	public void setCombosTienda(ArrayList<Combo> combosTienda) {
		this.combosTienda = combosTienda;
	}

	public ArrayList<OrdenCompra> getOrdenesComprasTienda() {
		return OrdenesComprasTienda;
	}

	public void setOrdenesComprasTienda(ArrayList<OrdenCompra> ordenesComprasTienda) {
		OrdenesComprasTienda = ordenesComprasTienda;
	}

	//chequeoCantMincomp determina si un componente se encuentra en su cantidad
	//minima. 
	public Componente chequeoCantMincomp (String id) {
		Componente aux = null;
		boolean buscar = false;
		
		for(int k=0 ; k < componentesTienda.size() ; k++) {
			if(componentesTienda.get(k).getId().equalsIgnoreCase(id)) {
				aux = componentesTienda.get(k);
				buscar = true;
			}
			k++;
		}
		return aux;
	}

}
