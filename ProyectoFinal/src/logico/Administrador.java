package logico;

public class Administrador extends Persona{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8033000057888442984L;
	private String usernameAdmi;
	private String passwordAdmi;
	private String idAdmin;
	
	public Administrador(String nombre, String telefono, String cedula, String direccion, String usernameAdmi,
			String passwordAdmi, String idAdmin) {
		super(nombre, telefono, cedula, direccion);
		this.usernameAdmi = usernameAdmi;
		this.passwordAdmi = passwordAdmi;
		this.idAdmin = idAdmin;
	}

	public String getUsernameAdmi() {
		return usernameAdmi;
	}

	public void setUsernameAdmi(String usernameAdmi) {
		this.usernameAdmi = usernameAdmi;
	}

	public String getPasswordAdmi() {
		return passwordAdmi;
	}

	public void setPasswordAdmi(String passwordAdmi) {
		this.passwordAdmi = passwordAdmi;
	}

	public String getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(String idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	
	
}
