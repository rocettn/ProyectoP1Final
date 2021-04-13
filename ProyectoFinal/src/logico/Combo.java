package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 955197359938136313L;
	private String nombreCombo;
	private ArrayList <Componente> componenteCombo;
	private float porcentajeDescuento;
	private String codigoIdentCombo;
	
	public Combo(String nombreCombo, String codigoIdentCombo) {
		super();
		this.nombreCombo = nombreCombo;
		this.componenteCombo = new ArrayList<Componente>();
		this.porcentajeDescuento = porcentajeDescuento;
		this.codigoIdentCombo = codigoIdentCombo;
	}
	

	public String getNombreCombo() {
		return nombreCombo;
	}

	public void setNombreCombo(String nombreCombo) {
		this.nombreCombo = nombreCombo;
	}

	public ArrayList<Componente> getComponenteCombo() {
		return componenteCombo;
	}

	public void setComponenteCombo(ArrayList<Componente> componenteCombo) {
		this.componenteCombo = componenteCombo;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	public String getCodigoIdentCombo() {
		return codigoIdentCombo;
	}


	public void setCodigoIdentCombo(String codigoIdentCombo) {
		this.codigoIdentCombo = codigoIdentCombo;
	}
	
	public void insertarComponenteCombo(Componente c) {
		componenteCombo.add(c);
	}
	//obtenerPrecioVentaCombo permite calcular el precio de venta del combo. 
	 public float obtenerPrecioVentaCombo(){
	        float total = 0;
	        float precioVentaCombo = 0;
	        for (Componente compTemp : this.componenteCombo) {
	            total += compTemp.getPrecioVentaComponente();
	        }
	        precioVentaCombo = total - (total * (this.porcentajeDescuento/100));
	        return precioVentaCombo;
	    }
	 
	//obtenerPrecioCompraCombo permite calcular el precio de compra del combo.
	 public float obtenerPrecioCompraCombo(){
	        float total = 0;
	        float precioCompraCombo = 0;
	        for (Componente compTemp : this.componenteCombo) {
	            total += compTemp.getPrecioCompraComponente();
	        }
	        precioCompraCombo = total;
	        return precioCompraCombo;
	    }

	 
}
