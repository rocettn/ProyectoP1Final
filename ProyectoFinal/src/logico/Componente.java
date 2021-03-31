package logico;

public abstract class Componente {
	
	protected String id;
	protected String marca;
	protected String modelo;
	protected float precioComponente;
	protected int cantidadDisponible;
	protected String numeroSerie;
	protected int cantMinimaComp;
	protected int cantMaximaComp;
	
	public Componente(String id, String marca, String modelo, float precioComponente, int cantidadDisponible,
			String numeroSerie, int cantMinimaComp, int cantMaximaComp) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.precioComponente = precioComponente;
		this.cantidadDisponible = cantidadDisponible;
		this.numeroSerie = numeroSerie;
		this.cantMinimaComp = cantMinimaComp;
		this.cantMaximaComp = cantMaximaComp;
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

	public float getPrecioComponente() {
		return precioComponente;
	}

	public void setPrecioComponente(float precioComponente) {
		this.precioComponente = precioComponente;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
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

	public int getCantMaximaComp() {
		return cantMaximaComp;
	}

	public void setCantMaximaComp(int cantMaximaComp) {
		this.cantMaximaComp = cantMaximaComp;
	}
	
	
    
}
