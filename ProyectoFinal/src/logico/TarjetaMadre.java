package logico;

public class TarjetaMadre extends Componente {
             
	/**
	 * 
	 */
	private static final long serialVersionUID = -7451087388867383859L;
	private String tipoConectorTM;
	private String tipoMemoriaRamTM;
	private String listaConexionesDD;
	
	public TarjetaMadre(String id, String marca, String modelo, float precioVentaComponente,
			float precioCompraComponente, String numeroSerie, int cantMinimaComp, int cantMaximaComp,
			int cantActualComp, String tipoConectorTM, String tipoMemoriaRamTM,
			String listaConexionesDD) {
		super(id, marca, modelo, precioVentaComponente, precioCompraComponente, numeroSerie, cantMinimaComp,
				cantMaximaComp, cantActualComp);
		this.tipoConectorTM = tipoConectorTM;
		this.tipoMemoriaRamTM = tipoMemoriaRamTM;
		this.listaConexionesDD = listaConexionesDD;
	}

	public String getTipoConectorTM() {
		return tipoConectorTM;
	}

	public void setTipoConectorTM(String tipoConectorTM) {
		this.tipoConectorTM = tipoConectorTM;
	}

	public String getTipoMemoriaRamTM() {
		return tipoMemoriaRamTM;
	}

	public void setTipoMemoriaRamTM(String tipoMemoriaRamTM) {
		this.tipoMemoriaRamTM = tipoMemoriaRamTM;
	}

	public String getListaConexionesDD() {
		return listaConexionesDD;
	}

	public void setListaConexionesDD(String listaConexionesDD) {
		this.listaConexionesDD = listaConexionesDD;
	}
	


	
}
