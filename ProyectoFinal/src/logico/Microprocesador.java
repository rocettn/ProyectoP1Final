package logico;

public class Microprocesador extends Componente {
	
	private String tipoConector;
	private float velocidadProcesamiento;
	
	public Microprocesador(String id, String marca, String modelo, float precioVentaComponente,
			float precioCompraComponente, String numeroSerie, int cantMinimaComp, int cantMaximaComp,
			int cantActualComp, String tipoConector, float velocidadProcesamiento) {
		super(id, marca, modelo, precioVentaComponente, precioCompraComponente, numeroSerie, cantMinimaComp,
				cantMaximaComp, cantActualComp);
		this.tipoConector = tipoConector;
		this.velocidadProcesamiento = velocidadProcesamiento;
	}

	public String getTipoConector() {
		return tipoConector;
	}

	public void setTipoConector(String tipoConector) {
		this.tipoConector = tipoConector;
	}

	public float getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}

	public void setVelocidadProcesamiento(float velocidadProcesamiento) {
		this.velocidadProcesamiento = velocidadProcesamiento;
	}
	
	
	
}
