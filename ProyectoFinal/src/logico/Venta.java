package logico;

import java.util.ArrayList;

public class Venta {
	
	private Cliente cedulaClienteV;
	private ArrayList <Componente> especificacionesComp;
	private String idFactura;
	private float impuesto;
	
	public Venta(Cliente cedulaClienteV, ArrayList<Componente> especificacionesComp, String idFactura, float impuesto) {
		super();
		this.cedulaClienteV = cedulaClienteV;
		this.especificacionesComp = especificacionesComp;
		this.idFactura = idFactura;
		this.impuesto = impuesto;
	}

	public Cliente getCedulaClienteV() {
		return cedulaClienteV;
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
	
	
}
