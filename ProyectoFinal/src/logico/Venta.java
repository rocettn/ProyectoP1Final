package logico;

import java.util.ArrayList;
import java.util.Calendar;

import sun.util.calendar.LocalGregorianCalendar.Date;

//import sun.util.calendar.BaseCalendar.Date;

public class Venta {
	
	private Cliente cedulaClienteV;
	private ArrayList <Componente> especificacionesComp;
	private String idFactura;
	private float impuesto;
	private Date fecha;
	private Calendar hora;
	
	public Venta(Cliente cedulaClienteV, ArrayList<Componente> especificacionesComp, String idFactura, float impuesto, Date fecha, Calendar hora) {
		super();
		this.cedulaClienteV = cedulaClienteV;
		this.especificacionesComp = especificacionesComp;
		this.idFactura = idFactura;
		this.impuesto = impuesto;
		this.fecha = fecha;
		this.hora = hora;
	}


	public Cliente getCedulaClienteV() {
		return cedulaClienteV;
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

	public void setCedulaClienteV(Cliente cedulaClienteV) {
		this.cedulaClienteV = cedulaClienteV;
	}

	public ArrayList<Componente> getEspecificacionesComp() {
		return especificacionesComp;
	}

	public void setEspecificacionesComp(ArrayList<Componente> especificacionesComp) {
		this.especificacionesComp = especificacionesComp;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}
	
	//System.out.println("La fecha es "+fecha.get());
	//System.out.println(fecha.toString());


	private Calendar newGregorianCalendar() {
		// TODO Auto-generated method stub
		
		Calendar fecha = newGregorianCalendar();
		int year = fecha.get(Calendar.YEAR);
		int mes = 1+fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		
		//System.out.println(dia + mes + year);
		return fecha;
		
	}
	
	//System.out.println(dia + mes + year);
	
}

