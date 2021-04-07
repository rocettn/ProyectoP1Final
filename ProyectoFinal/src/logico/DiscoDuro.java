package logico;

public class DiscoDuro extends Componente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4922700719562520552L;
	private float capacidadAlmacenamiento;
	private String tipoConexion;
	
	public DiscoDuro(String id, String marca, String modelo, float precioVentaComponente, float precioCompraComponente,
			String numeroSerie, int cantMinimaComp, int cantMaximaComp, int cantActualComp,
			float capacidadAlmacenamiento, String tipoConexion) {
		super(id, marca, modelo, precioVentaComponente, precioCompraComponente, numeroSerie, cantMinimaComp,
				cantMaximaComp, cantActualComp);
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
