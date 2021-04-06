package logico;

import java.util.ArrayList;

public class Tienda {

	private ArrayList <Cliente> clientesTienda;
	private ArrayList <Vendedor> vendedoresTienda;
	private ArrayList <Administrador> administradoresTienda;
	private ArrayList <Componente> componentesTienda;
	private ArrayList <Venta> ventasTienda;
	private ArrayList <Proveedor> proveedoresTienda;
	private ArrayList <Combo> combosTienda;
	private ArrayList <OrdenCompra> OrdenesComprasTienda;

	public Tienda(ArrayList<Cliente> clientesTienda, ArrayList<Vendedor> vendedoresTienda,
			ArrayList <Administrador> administradoresTienda, ArrayList<Componente> componentesTienda, 
			ArrayList<Venta> ventasTienda, ArrayList<Proveedor> proveedoresTienda,
			ArrayList<Combo> combosTienda, ArrayList<OrdenCompra> ordenesComprasTienda) {
		super();
		this.clientesTienda = clientesTienda;
		this.vendedoresTienda = vendedoresTienda;
		this.administradoresTienda = administradoresTienda;
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

	public ArrayList<Administrador> getAdministradoresTienda() {
		return administradoresTienda;
	}

	public void setAdministradoresTienda(ArrayList<Administrador> administradoresTienda) {
		this.administradoresTienda = administradoresTienda;
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

	/*
	 * //chequeoCantMinComp determina si un componente se encuentra en su cantidad
	 * minima. 
	 * public OrdenCompra chequeoCantMinComp (int cantMinimaComp) {
	 * Componente auxiliar = null; OrdenCompra ordenCompraGenerada = null; boolean
	 * buscar = false;
	 * 
	 * for(int k=0 ; k < componentesTienda.size() ; k++) {
	 * if(componentesTienda.get(k).getcantActualComp() <=
	 * componentesTienda.get(k).getCantMinimaComp()) { auxiliar =
	 * componentesTienda.get(k); buscar = true; } k++; }
	 * 
	 * if(buscar == true) { auxiliar = ordenCompraGenerada.getComponentesAPedir(); }
	 * return ordenCompraGenerada.getComponentesAPedir(); }
	 */

	//buscarClienteTienda permite buscar un cliente por su cedula.
	public Cliente buscarClienteTienda (String cedula) {
		Cliente aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < clientesTienda.size()) {
			if(clientesTienda.get(i).getCedula().equalsIgnoreCase(cedula)) {
				aux = clientesTienda.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}

	//buscarVendedorTienda permite buscar un vendedor por su id.
	public Vendedor buscarVendedorTienda (String idVendedor) {
		Vendedor aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < vendedoresTienda.size()) {
			if(vendedoresTienda.get(i).getIdVendedor().equalsIgnoreCase(idVendedor)) {
				aux = vendedoresTienda.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}
	//buscarComponenteTienda permite buscar un componente por su id.
	public Componente buscarComponenteTienda (String id) {
		Componente aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < componentesTienda.size()) {
			if(componentesTienda.get(i).getId().equalsIgnoreCase(id)) {
				aux = componentesTienda.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}

	//buscarVentaTienda permite buscar una venta por su id de factura.
	public Venta buscarVentaTienda (String idFactura) {
		Venta aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < ventasTienda.size()) {
			if(ventasTienda.get(i).getIdFactura().equalsIgnoreCase(idFactura)) {
				aux = ventasTienda.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}

	//buscarComboTienda permite buscar un combo por su nombre.
	public Combo buscarComboTienda (String nombreCombo) {
		Combo aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < combosTienda.size()) {
			if(combosTienda.get(i).getNombreCombo().equalsIgnoreCase(nombreCombo)) {
				aux = combosTienda.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}

	//buscarProveedorTienda permite buscar un proveedor por su id.
	public Proveedor buscarProveedorTienda (String idProveedor) {
		Proveedor aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < proveedoresTienda.size()) {
			if(proveedoresTienda.get(i).getIdProveedor().equalsIgnoreCase(idProveedor)) {
				aux = proveedoresTienda.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}

	//buscarAdministradorTienda permite buscar un proveedor por su id.
	public Administrador buscarAdiministradorTienda (String idAdmin) {
		Administrador aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < administradoresTienda.size()) {
			if(administradoresTienda.get(i).getIdAdmin().equalsIgnoreCase(idAdmin)) {
				aux = administradoresTienda.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}

	//buscarProveedorDeComponente determina el proveedor de una componente especifica. 
	public Proveedor buscarProveedorDeComponente (String id) {
		Proveedor proveedorDeComponente = null;
		int k = 0; 
		int m = 0; 
		boolean buscar1 = false;
		boolean buscar2 = false;
		
		while (k < proveedoresTienda.size() && !buscar2) {
			m=0;
			while(m < proveedoresTienda.get(k).getComponentesSuple().size() && !buscar1) {
				if(proveedoresTienda.get(k).getComponentesSuple().get(m).getId().equalsIgnoreCase(id)) {
					buscar2 = true;
					buscar1 = true;
					proveedorDeComponente = proveedoresTienda.get(k);
				}
				m++;
			}
			k++;
		}
		return proveedorDeComponente;
	}

	//generarOrdenCompra permite que se realice el pedido de una orden de compra. 
	public boolean generarOrdenCompra (String id) {
		boolean aux = false;

		Componente componenteDeOrdenCompra = buscarComponenteTienda (id);
		if(componenteDeOrdenCompra != null) {
			Proveedor proveedorTemp = buscarProveedorDeComponente (id);
			if(proveedorTemp!=null) {
				aux = componenteDeOrdenCompra.chequeoCantMinComp();
			}
		}
		return aux;
	}
	
	
	

}
