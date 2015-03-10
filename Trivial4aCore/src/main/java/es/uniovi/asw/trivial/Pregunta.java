package es.uniovi.asw.trivial;

import java.util.List;

public class Pregunta {

	private String identificador;
	private String pregunta;
	private List<String> respuestasCorrectas;
	private List<String> respuestasIncorrectas;
	
	
	public Pregunta(String identificador, String pregunta,
			List<String> respuestasCorrectas, List<String> respuestasIncorrectas) {
		
		this.identificador = identificador;
		this.pregunta = pregunta;
		this.respuestasCorrectas = respuestasCorrectas;
		this.respuestasIncorrectas = respuestasIncorrectas;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public String getPregunta() {
		return pregunta;
	}
	public List<String> getRespuestasCorrectas() {
		return respuestasCorrectas;
	}
	public List<String> getRespuestasIncorrectas() {
		return respuestasIncorrectas;
	}
	

}
