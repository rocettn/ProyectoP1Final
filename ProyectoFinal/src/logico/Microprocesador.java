package logico;

public class Microprocesador extends Componente {
	
	private String tipoConector;
	private float velocidadProcesamiento;
	
	public Microprocesador(String id, String marca, String modelo, float precioComponente, int cantidadDisponible,
			String numeroSerie, int cantMinimaComp, int cantMaximaComp, String tipoConector,
			float velocidadProcesamiento) {
		super(id, marca, modelo, precioComponente, cantidadDisponible, numeroSerie, cantMinimaComp, cantMaximaComp);
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
