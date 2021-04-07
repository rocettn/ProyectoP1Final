package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6967368939345868509L;
	private ArrayList <Persona> personasTienda; //Clientes, Administradores y Vendedores
	private ArrayList <Componente> componentesTienda;
	private ArrayList <Venta> ventasTienda;
	private ArrayList <Proveedor> proveedoresTienda;
	private ArrayList <Combo> combosTienda;
	private ArrayList <OrdenCompra> OrdenesComprasTienda;
	public static Tienda tienda = null;
	private Persona usuario = null;

	public Tienda() {
		super();
		this.personasTienda = new ArrayList<Persona>();
		this.componentesTienda = new ArrayList<Componente>();
		this.ventasTienda = new ArrayList<Venta>();
		this.proveedoresTienda = new ArrayList<Proveedor>();
		this.combosTienda = new ArrayList<Combo>();
		this.OrdenesComprasTienda = new ArrayList<OrdenCompra>();
	}


	public ArrayList<Persona> getPersonasTienda() {
		return personasTienda;
	}

	public void setPersonasTienda(ArrayList<Persona> personasTienda) {
		this.personasTienda = personasTienda;
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
	
	public static Tienda getInstance() {
		if(tienda == null) {
			tienda = new Tienda();
		}
		return tienda;
	}
	
	public Persona getUsuario() {
		return usuario;
	}

	public void setUsuario(Persona usuario) {
		this.usuario = usuario;
	}
	
	public void insertarPersona(Persona persona) {
		this.personasTienda.add(persona);
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
		while(!encontrado && i < personasTienda.size()) {
			if(personasTienda.get(i) instanceof Cliente && personasTienda.get(i).getCedula().equalsIgnoreCase(cedula)) {
				aux = (Cliente) personasTienda.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}

	//buscarVendedorTienda permite buscar un vendedor por su cedula.
	public Vendedor buscarVendedorTienda (String cedula) {
		Vendedor aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < personasTienda.size()) {
			if(personasTienda.get(i) instanceof Vendedor && personasTienda.get(i).getCedula().equalsIgnoreCase(cedula)) {
				aux = (Vendedor) personasTienda.get(i);
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
	public Administrador buscarAdiministradorTienda (String cedula) {
		Administrador aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < personasTienda.size()) {
			if(personasTienda.get(i) instanceof Administrador && personasTienda.get(i).getCedula().equalsIgnoreCase(cedula)) {
				aux = (Administrador) personasTienda.get(i);
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

	//inicioDeSesionEnLogin se encanga del inicio de sesion en el log in de vendedores y administradores. 
	public boolean inicioDeSesionEnLogin(String username, String password) {
		boolean res = false;
		int i = 0;
		while(i<personasTienda.size() && !res) {
			if(personasTienda.get(i) instanceof Administrador) {
				if(((Administrador)personasTienda.get(i)).getUsernameAdmi().equalsIgnoreCase(username)
						&& ((Administrador)personasTienda.get(i)).getPasswordAdmi().equalsIgnoreCase(password)){
					res = true;
					Tienda.getInstance().setUsuario(personasTienda.get(i));
				}
			}else if(personasTienda.get(i) instanceof Vendedor) {
				if(((Vendedor)personasTienda.get(i)).getUsernameVend().equalsIgnoreCase(username)
						&& ((Vendedor)personasTienda.get(i)).getUsernameVend().equalsIgnoreCase(password)) {
					res = true;
					Tienda.getInstance().setUsuario(personasTienda.get(i));
				}
			}
			i++;
		}
		return res;
	}

	

}
