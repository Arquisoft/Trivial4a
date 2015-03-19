package es.uniovi.asw.trivial.model;

public class Respuesta {
	
	public User usuario;
	public String respuesta;
	public boolean isCorrecta;
	
	public Respuesta(String respuesta, boolean isCorrecta) {
		
		this.respuesta = respuesta;
		this.isCorrecta = isCorrecta;
	}
	
	public Respuesta(String respuesta, boolean isCorrecta, User usuario)
	{
		this.respuesta = respuesta;
		this.isCorrecta = isCorrecta;
		this.usuario=usuario;
	
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public boolean isCorrecta() {
		return isCorrecta;
	}

	public void setCorrecta(boolean isCorrecta) {
		this.isCorrecta = isCorrecta;
	}

	@Override
	public String toString() {
		return "Respuesta [usuario=" + usuario + ", respuesta=" + respuesta
				+ ", isCorrecta=" + isCorrecta + "]";
	}
	
	

}
