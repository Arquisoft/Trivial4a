package es.uniovi.asw.trivial.extractor.parser;

import java.util.Arrays;

import es.uniovi.asw.trivial.model.Pregunta;

/**
 * Created by Jorge on 13/03/2015.
 */
public class PreguntaM implements Marcador {

	private String _id;
	private String pregunta;
	private String categoria;
	private String[] respuestasCorrectas;
	private String[] respuestasIncorrectas;

	public PreguntaM(String _id, String pregunta, String categoria,
			String[] respuestasCorrectas, String[] respuestasIncorrectas) {
		this._id = _id;
		this.pregunta = pregunta;
		this.categoria = categoria;
		this.respuestasCorrectas = respuestasCorrectas;
		this.respuestasIncorrectas = respuestasIncorrectas;
	}

	@Override
	public String toString() {
		return "Pregunta [_id=" + _id + "\n pregunta=" + pregunta
				+ "\n categoria=" + categoria + "\n respuestasCorrectas="
				+ Arrays.toString(respuestasCorrectas)
				+ "\n respuestasIncorrectas="
				+ Arrays.toString(respuestasIncorrectas) + "]";
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String[] getRespuestasCorrectas() {
		return respuestasCorrectas;
	}

	public void setRespuestasCorrectas(String[] respuestasCorrectas) {
		this.respuestasCorrectas = respuestasCorrectas;
	}

	public String[] getRespuestasIncorrectas() {
		return respuestasIncorrectas;
	}

	public void setRespuestasIncorrectas(String[] respuestasIncorrectas) {
		this.respuestasIncorrectas = respuestasIncorrectas;
	}

	public static Pregunta transformarPregunta(PreguntaM m){
    	String _id = m._id;
    	String pregunta = m.pregunta;
    	String categoria = m.categoria;
    	String[] respuestasCorrectas = m.respuestasCorrectas;
    	String[] respuestasIncorrectas = m.respuestasIncorrectas;
    	return new Pregunta(_id, pregunta, categoria, respuestasCorrectas, respuestasIncorrectas);
    }
}
