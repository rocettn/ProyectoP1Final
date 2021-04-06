package logico;

public class TarjetaMadre extends Componente {
             
	private Microprocesador tipoConectorTM;
	private MemoriaRam tipoMemoriaRamTM;
	private DiscoDuro listaConexionesDD;
	
	public TarjetaMadre(String id, String marca, String modelo, float precioVentaComponente,
			float precioCompraComponente, String numeroSerie, int cantMinimaComp, int cantMaximaComp,
			int cantActualComp, Microprocesador tipoConectorTM, MemoriaRam tipoMemoriaRamTM,
			DiscoDuro listaConexionesDD) {
		super(id, marca, modelo, precioVentaComponente, precioCompraComponente, numeroSerie, cantMinimaComp,
				cantMaximaComp, cantActualComp);
		this.tipoConectorTM = tipoConectorTM;
		this.tipoMemoriaRamTM = tipoMemoriaRamTM;
		this.listaConexionesDD = listaConexionesDD;
	}

	public Microprocesador getTipoConectorTM() {
		return tipoConectorTM;
	}

	public void setTipoConectorTM(Microprocesador tipoConectorTM) {
		this.tipoConectorTM = tipoConectorTM;
	}

	public MemoriaRam getTipoMemoriaRamTM() {
		return tipoMemoriaRamTM;
	}

	public void setTipoMemoriaRamTM(MemoriaRam tipoMemoriaRamTM) {
		this.tipoMemoriaRamTM = tipoMemoriaRamTM;
	}

	public DiscoDuro getListaConexionesDD() {
		return listaConexionesDD;
	}

	public void setListaConexionesDD(DiscoDuro listaConexionesDD) {
		this.listaConexionesDD = listaConexionesDD;
	}
	


	
}
