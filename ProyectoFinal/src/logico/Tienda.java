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
	private int codigoCompo = 1;
	private int codigoCombo = 1;
	private int tajetaMadreT = 0;
	private int memoriaRamT = 0;
	private int microT = 0;
	private int discoDuroT = 0;
	private float balanceTotalAc = 0;
	private int codigoProveedores = 1;
	private int codigoFactura = 1;
	private int codigoAdmin = 1;
	private int codigoVend = 1;

	private Tienda() { //Por el patron Singleton se coloca privado.
		super();
		this.personasTienda = new ArrayList<Persona>();
		this.componentesTienda = new ArrayList<Componente>();
		this.ventasTienda = new ArrayList<Venta>();
		this.proveedoresTienda = new ArrayList<Proveedor>();
		this.combosTienda = new ArrayList<Combo>();
		this.OrdenesComprasTienda = new ArrayList<OrdenCompra>();
	}



	public float getBalanceTotalAc() {
		return balanceTotalAc;
	}

	public void setBalanceTotalAc(float m) {
		this.balanceTotalAc = m;
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

	public void insertarComponente(Componente componente) {
		this.componentesTienda.add(componente); 
		setCodigoCompo(getCodigoCompo() + 1);
	}

	public int getCodigoCompo() {
		return codigoCompo;
	}

	public void setCodigoCompo(int codigoCompo) {
		this.codigoCompo = codigoCompo;
	}


	public int getCodigoCombo() {
		return codigoCompo;
	}

	public void setCodigoCombo(int codigoCombo) {
		this.codigoCombo = codigoCombo;
	}

	public int getTajetaMadreT() {
		return tajetaMadreT;
	}


	public void setTajetaMadreT(int tajetaMadreT) {
		this.tajetaMadreT = tajetaMadreT;
	}


	public int getMemoriaRamT() {
		return memoriaRamT;
	}


	public void setMemoriaRamT(int memoriaRamT) {
		this.memoriaRamT = memoriaRamT;
	}


	public int getMicroT() {
		return microT;
	}


	public void setMicroT(int microT) {
		this.microT = microT;
	}


	public int getDiscoDuroT() {
		return discoDuroT;
	}


	public void setDiscoDuroT(int discoDuroT) {
		this.discoDuroT = discoDuroT;
	}
	
	public int getCodigoProveedores() {
		return codigoProveedores;
	}

	public void setCodigoProveedores(int codigoProveedores) {
		this.codigoProveedores= codigoProveedores;
	}
	
	public void insertarProveedor(Proveedor pro) {
		proveedoresTienda.add(pro);
		setCodigoProveedores(getCodigoProveedores() + 1);
		
	}
	
	public int getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	
	public int getCodigoAdmin() {
		return codigoAdmin;
	}

	public void setCodigoAdmin(int codigoAdmin) {
		this.codigoAdmin = codigoAdmin;
	}
	
	public int getCodigoVend() {
		return codigoVend;
	}

	public void setCodigoVend(int codigoVend) {
		this.codigoVend = codigoVend;
	}
	
	public void insertarFactura(Venta venta) {
		this.ventasTienda.add(venta); 
		setCodigoFactura(getCodigoFactura()+1);
		
	}
	
	public void insertarCombo(Combo combo) {
		combosTienda.add(combo);
		setCodigoCombo (getCodigoCombo ()+1);
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
				System.out.println("toyaqui");
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
			if(componentesTienda.get(i).getNumeroSerie().equalsIgnoreCase(id)) {
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
	public Combo buscarComboTienda (String idCombo) {
		Combo aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < combosTienda.size()) {
			if(combosTienda.get(i).getCodigoIdentCombo().equalsIgnoreCase(idCombo)) {
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

	public float[] calculoGananciaFinal(){

		float rm[] = new  float [4]; 
		float total = 0.0f;

		for(Venta aux : ventasTienda) {
			total += aux.calcularSumaBeneficio();
			float m[] = aux.sumaTotalGananciaComponente();
			rm[0] += m[0];
			rm[1] += m[1];
			rm[2] += m[2];
			rm[3] += m[3];

		}
		rm[0] /= total; //Tarjeta Madre
		rm[1] /= total; //Memoria Ram
		rm[2] /= total; //Microprocesador
		rm[3] /= total; //Disco Duro

		return rm;
	}

	//Credito del cliente
	public float CreditoClienteTienda(Cliente client) {
		float auxCliente = 0;
		for(Venta venTem : ventasTienda) {
			if(venTem.getClienteVenta().cedula.equalsIgnoreCase(client.getCedula())) {
				auxCliente += venTem.getMontoTotal();
			}
		}

		//return client.getCreditoCliente() - auxCliente;
		return auxCliente;
	}

	public void restarCantidadComponente(Componente compoT, int cantidadCompo) {
		for(Componente ct : componentesTienda) {
			if(ct.equals(compoT)) {
				ct.cantActualComp += cantidadCompo;

				if( ct instanceof TarjetaMadre) {
					setTajetaMadreT(getTajetaMadreT() - cantidadCompo);
				}

				if( ct instanceof MemoriaRam) {
					setMemoriaRamT(getMemoriaRamT() - cantidadCompo);
				}
				if( ct instanceof Microprocesador) {
					setMicroT(getMicroT() - cantidadCompo);
				}

				if( ct instanceof DiscoDuro) {
					setDiscoDuroT(getDiscoDuroT() - cantidadCompo);
				}

			}			
		}

	}

	public void agregarComponenteTienda(Componente lm) {
		Componente cm = buscarComponenteTienda(lm.id);
		cm.setCantActualComp(cm.getCantActualComp() - 1);

		if( lm instanceof TarjetaMadre) {
			setTajetaMadreT(getTajetaMadreT() + 1);
		}

		if( lm instanceof MemoriaRam) {
			setMemoriaRamT(getMemoriaRamT() + 1);
		}
		if( lm instanceof Microprocesador) {
			setMicroT(getMicroT() + 1);
		}

		if( lm instanceof DiscoDuro) {
			setDiscoDuroT(getDiscoDuroT() + 1);
		}

	}		

	public void agregarComboTienda(Combo n) {
		Combo z = buscarComboTienda(n.getCodigoIdentCombo());
		for(Componente v : n.getComponenteCombo()) {
			agregarComponenteTienda(v);
		}

	}

	public boolean verificarCombo(Combo r) {
		boolean aux = true;
		int cantidad = 0;
		int k = 0;
		int m = 0;
		while(k < r.getComponenteCombo().size() && aux) {
			m = k+1;
			cantidad = r.getComponenteCombo().get(k).getCantActualComp()-1;
			if(cantidad > 0) {
				while(m < r.getComponenteCombo().size() && aux) {
					if(r.getComponenteCombo().get(k).equals(r.getComponenteCombo().get(m))) {
						cantidad--;
						if(cantidad == -1) {
							aux = false;
						}
					}
					m++;
				}
			}else {
				aux = false;
			}
			k++;
		}
		return aux;
	}

	public void restarComponenteCombo(Combo lm) {
		for(Componente mn : lm.getComponenteCombo() ) {
			mn.setCantActualComp(mn.getCantActualComp()+1);

			if( mn instanceof TarjetaMadre) {
				setTajetaMadreT(getTajetaMadreT() - 1);
			}

			if( mn instanceof MemoriaRam) {
				setMemoriaRamT(getMemoriaRamT() - 1);
			}
			if( mn instanceof Microprocesador) {
				setMicroT(getMicroT() - 1);
			}

			if( mn instanceof DiscoDuro) {
				setDiscoDuroT(getDiscoDuroT() - 1);
			}

		}

	}

	public boolean realizarOrdenCompra(String id) {
		boolean aux = false;
		Componente componenteTe = buscarComponenteTienda(id);
		if(componenteTe != null) {
			Proveedor proveedorTe = buscarProveedorDeComponente(id);
			if(proveedorTe != null) {
				aux = componenteTe.chequeoCantMinComp();
			}
		}
		return aux;
	}


	public void PagarDeudaCliente(Cliente aux) {
		float total = 0;
		ArrayList<String>s=new ArrayList<String>();
		for(Venta v :  ventasTienda) {
			if(v.getClienteVenta().equals(aux)) {
				s.add(v.getIdFactura());
				total += v.calcularSumaBeneficio();
			}
		}
		setBalanceTotalAc(getBalanceTotalAc()+total);

	}
}


