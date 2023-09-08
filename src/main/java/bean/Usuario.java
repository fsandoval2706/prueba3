package bean;

public class Usuario {
	private String Rut;
	private String username;
	private String password;

	public Usuario(String rut, String username, String password) {

		this.Rut = rut;
		this.username = username;
		this.password = password;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getRut() {
		return Rut;
	}

	public void setRut(String rut) {
		Rut = rut;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
