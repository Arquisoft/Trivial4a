package es.uniovi.asw.trivial.model;

public class Contestacion {

	private String user;
	private String pregunta;
	private boolean isCorrecta;
	
	public Contestacion(String user, String pregunta, boolean isCorrecta) {
		
		this.user = user;
		this.pregunta = pregunta;
		this.isCorrecta = isCorrecta;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public boolean isCorrecta() {
		return isCorrecta;
	}

	public void setCorrecta(boolean isCorrecta) {
		this.isCorrecta = isCorrecta;
	}

	@Override
	public String toString() {
		return "Contestacion [user=" + user + ", pregunta=" + pregunta
				+ ", isCorrecta=" + isCorrecta + "]";
	}

	
	
	
}
