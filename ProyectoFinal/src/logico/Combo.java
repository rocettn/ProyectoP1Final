package logico;

import java.util.ArrayList;

public class Combo {
	
	private ArrayList <Componente> componenteCombo;
	private float porcentajeDescuento;
	
	public Combo(ArrayList<Componente> componenteCombo, float porcentajeDescuento) {
		super();
		this.componenteCombo = componenteCombo;
		this.porcentajeDescuento = porcentajeDescuento;
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
	
	 public float obtenerPrecioCombo(){
	        float total = 0;
	        float precioCombo = 0;
	        for (Componente compTemp : this.componenteCombo) {
	            total += compTemp.getPrecioComponente();
	        }
	        precioCombo = total - (total * (this.porcentajeDescuento/100));
	        return precioCombo;
	    }
}
