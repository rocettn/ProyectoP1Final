package logico;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Venta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8035349213109284835L;
	private Persona clienteVenta;
	private Vendedor vendedorVenta;
	private ArrayList <Componente> componentesVenta;
	private ArrayList <Combo> combosVenta;
	private String idFactura;
	private Date fecha;
	private Calendar hora;
	private float montoTotal;
	private Object[][]filas;
	public static Venta venta = null;
	private int cantidadElegida = -1;

	public Venta(Persona clienteVenta, Vendedor vendedorVenta, String idFactura,  float montoTotal, int cant) {
		super();
		this.clienteVenta = clienteVenta;
		this.vendedorVenta = vendedorVenta;
		this.componentesVenta = new ArrayList<Componente>();
		this.combosVenta = new ArrayList<Combo>();
		this.idFactura = idFactura;
		this.fecha = new Date();//fecha;
		this.hora = hora;
		this.cantidadElegida = cant;
		this.filas=new Object[100][5];
	}

	
	public Object[][] getFilas() {
		return filas;
	}

	public void setFilas(Object[][] filas) {
		this.filas = filas;
	}
	public Persona getClienteVenta() {
		return clienteVenta;
	}

	public void setClienteVenta(Persona clienteVenta) {
		this.clienteVenta = clienteVenta;
	}
	
	public int getCantidadElegida() {
		return cantidadElegida;
	}


	public void setCantidad(int cantidadElegida) {
		this.cantidadElegida = cantidadElegida;
	}


	public Vendedor getVendedorVenta() {
		return vendedorVenta;
	}

	public void setVendedorVenta(Vendedor vendedorVenta) {
		this.vendedorVenta = vendedorVenta;
	}

	public ArrayList<Componente> getComponentesVenta() {
		return componentesVenta;
	}

	public void setComponentesVenta(ArrayList<Componente> componentesVenta) {
		this.componentesVenta = componentesVenta;
	}

	public ArrayList<Combo> getCombosVenta() {
		return combosVenta;
	}

	public void setCombosVenta(ArrayList<Combo> combosVenta) {
		this.combosVenta = combosVenta;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	
	public float calcularSumaBeneficio() {
		float total = 0;
		
		for(Combo Comb : combosVenta) {
			total += (Comb.obtenerPrecioVentaCombo() - Comb.obtenerPrecioCompraCombo());
			
		}
		
		for(Componente comp : componentesVenta) {
			total += comp.calculoGananciaComponente();
		}
		
		return total;
	}
	
	public float[] sumaTotalGananciaComponente() {
		float [] total = new float [4];
		
		for(Componente componenteTemporal : componentesVenta) {
			
			if(componenteTemporal instanceof TarjetaMadre) {
				total[0] += componenteTemporal.calculoGananciaComponente();
			}
			
			if(componenteTemporal instanceof MemoriaRam) {
				total[1] += componenteTemporal.calculoGananciaComponente();
			}
			
			if(componenteTemporal instanceof Microprocesador) {
				total[2] += componenteTemporal.calculoGananciaComponente();
			}
			
			if(componenteTemporal instanceof DiscoDuro) {
				total[3] += componenteTemporal.calculoGananciaComponente();
			}
			
		}
		
		for(Combo comboTemporal : combosVenta) {
			for(Componente componenteT : comboTemporal.getComponenteCombo()) {
				
				if(componenteT instanceof TarjetaMadre) {
					total[0] += componenteT.calculoGananciaComponente();
				}
				
				if(componenteT instanceof MemoriaRam) {
					total[1] += componenteT.calculoGananciaComponente();
				}
				
				if(componenteT instanceof Microprocesador) {
					total[2] += componenteT.calculoGananciaComponente();
				}
				
				if(componenteT instanceof DiscoDuro) {
					total[3] += componenteT.calculoGananciaComponente();
				}
				
			}
		}
		return total;
	}
	public void insertarComponente(Componente c) {
		componentesVenta.add(c);
	}

	public void insertarCombos(Combo c) {
		combosVenta.add(c);
	}
	
	public void insertarFilas(int pos,Object[] o) {
		for(int i = 0; i<5;i++) {
			filas[pos][i]=o[i];
		}
		
	}
}

