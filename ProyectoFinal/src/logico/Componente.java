package logico;

public abstract class Componente {

	protected String id;
	protected String marca;
	protected String modelo;
	protected float precioVentaComponente;
	protected float precioCompraComponente;
	protected String numeroSerie;
	protected int cantMinimaComp;
	protected int cantMaximaComp;
	protected int cantActualComp;

	public Componente(String id, String marca, String modelo, float precioVentaComponente, float precioCompraComponente, 
			String numeroSerie, int cantMinimaComp, int cantMaximaComp, int cantActualComp) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.precioVentaComponente = precioVentaComponente;
		this.precioCompraComponente = precioCompraComponente;
		this.numeroSerie = numeroSerie;
		this.cantMinimaComp = cantMinimaComp;
		this.cantMaximaComp = cantMaximaComp;
		this.cantActualComp = cantActualComp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public int getCantMinimaComp() {
		return cantMinimaComp;
	}

	public void setCantMinimaComp(int cantMinimaComp) {
		this.cantMinimaComp = cantMinimaComp;
	}

	public int getcantActualComp() {
		return cantActualComp;
	}

	public void setcantActualComp(int cantActualComp) {
		this.cantActualComp = cantActualComp;
	}

	public float getPrecioVentaComponente() {
		return precioVentaComponente;
	}

	public void setPrecioVentaComponente(float precioVentaComponente) {
		this.precioVentaComponente = precioVentaComponente;
	}

	public float getPrecioCompraComponente() {
		return precioCompraComponente;
	}

	public void setPrecioCompraComponente(float precioCompraComponente) {
		this.precioCompraComponente = precioCompraComponente;
	}

	public int getCantMaximaComp() {
		return cantMaximaComp;
	}

	public void setCantMaximaComp(int cantMaximaComp) {
		this.cantMaximaComp = cantMaximaComp;
	}

	public int getCantActualComp() {
		return cantActualComp;
	}

	public void setCantActualComp(int cantActualComp) {
		this.cantActualComp = cantActualComp;
	}

	public boolean chequeoCantMinComp() {
		boolean aux = false;
		
		if(cantActualComp <= cantMinimaComp) {
			aux = true;
		}

		return aux;
	}

}
