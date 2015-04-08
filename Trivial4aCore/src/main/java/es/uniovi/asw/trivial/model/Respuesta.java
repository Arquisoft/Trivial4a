package es.uniovi.asw.trivial.model;

/**
 * Esta es una clase auxiliar para el parser
 *
 */
public class Respuesta {
	
	
	public String respuesta;
	public boolean isCorrecta;
	
	public Respuesta(String respuesta, boolean isCorrecta) {
		
		this.respuesta = respuesta;
		this.isCorrecta = isCorrecta;
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


}
