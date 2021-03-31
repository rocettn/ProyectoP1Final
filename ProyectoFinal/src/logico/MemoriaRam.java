package logico;

public class MemoriaRam extends Componente {
	
	private float cantidadMemoria;
	private String tipoMemoria;
	
	public MemoriaRam(String id, String marca, String modelo, float precioComponente, int cantidadDisponible,
			String numeroSerie, int cantMinimaComp, int cantMaximaComp, float cantidadMemoria, String tipoMemoria) {
		super(id, marca, modelo, precioComponente, cantidadDisponible, numeroSerie, cantMinimaComp, cantMaximaComp);
		this.cantidadMemoria = cantidadMemoria;
		this.tipoMemoria = tipoMemoria;
	}

	public float getCantidadMemoria() {
		return cantidadMemoria;
	}

	public void setCantidadMemoria(float cantidadMemoria) {
		this.cantidadMemoria = cantidadMemoria;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	
	
	
}
