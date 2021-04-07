package logico;

public class MemoriaRam extends Componente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1836819491415438757L;
	private float cantidadMemoria;
	private String tipoMemoria;
	
	public MemoriaRam(String id, String marca, String modelo, float precioVentaComponente, float precioCompraComponente,
			String numeroSerie, int cantMinimaComp, int cantMaximaComp, int cantActualComp, float cantidadMemoria,
			String tipoMemoria) {
		super(id, marca, modelo, precioVentaComponente, precioCompraComponente, numeroSerie, cantMinimaComp,
				cantMaximaComp, cantActualComp);
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
