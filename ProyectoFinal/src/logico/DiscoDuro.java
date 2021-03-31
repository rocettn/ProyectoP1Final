package logico;

public class DiscoDuro extends Componente {
	
	private float capacidadAlmacenamiento;
	private String tipoConexion;
	
	public DiscoDuro(String id, String marca, String modelo, float precioComponente, int cantidadDisponible,
			String numeroSerie, int cantMinimaComp, int cantMaximaComp, float capacidadAlmacenamiento,
			String tipoConexion) {
		super(id, marca, modelo, precioComponente, cantidadDisponible, numeroSerie, cantMinimaComp, cantMaximaComp);
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
		this.tipoConexion = tipoConexion;
	}

	public float getCapacidadAlmacenamiento() {
		return capacidadAlmacenamiento;
	}

	public void setCapacidadAlmacenamiento(float capacidadAlmacenamiento) {
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	

}
