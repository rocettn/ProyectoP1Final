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

	public Venta(Persona clienteVenta, Vendedor vendedorVenta, ArrayList<Componente> componentesVenta,
			ArrayList<Combo> combosVenta, String idFactura, Date fecha, Calendar hora) {
		super();
		this.clienteVenta = clienteVenta;
		this.vendedorVenta = vendedorVenta;
		this.componentesVenta = new ArrayList<Componente>();
		this.combosVenta = new ArrayList<Combo>();
		this.idFactura = idFactura;
		this.fecha = new Date();//fecha;
		this.hora = hora;
	}

	public Persona getClienteVenta() {
		return clienteVenta;
	}

	public void setClienteVenta(Persona clienteVenta) {
		this.clienteVenta = clienteVenta;
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

	/*
	 * public float calcularSubtotalVenta() { float subtotal = 0;
	 * 
	 * for (Componente compAux : componentes ) { subtotal += compAux;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */


	/*
	 * private Calendar newGregorianCalendar() { // TODO Auto-generated method stub
	 * 
	 * Calendar fecha = newGregorianCalendar(); int year = fecha.get(Calendar.YEAR);
	 * int mes = 1+fecha.get(Calendar.MONTH); int dia =
	 * fecha.get(Calendar.DAY_OF_MONTH);
	 * 
	 * //System.out.println(dia + mes + year); return fecha;
	 * 
	 * }
	 */

}

