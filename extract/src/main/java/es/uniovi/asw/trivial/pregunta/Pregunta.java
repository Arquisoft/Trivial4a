package es.uniovi.asw.trivial.pregunta;

<<<<<<< HEAD
import java.util.List;

public class Pregunta implements JSonable{
	
	private String identificador;
	private String pregunta;
	private List<String> respuestasCorrectas;
	private List<String> respuestasIncorrectas;
	
	
	public Pregunta(String identificador, String pregunta,
			List<String> respuestasCorrectas, List<String> respuestasIncorrectas) {
		
		this.identificador = identificador;
		this.pregunta = pregunta;
=======
import java.util.Arrays;

public class Pregunta{
	
	private String _id;
	private String pregunta;
	private String categoria;
	private String[] respuestasCorrectas;
	private String[] respuestasIncorrectas;
	

	
	public Pregunta(String _id, String pregunta, String categoria,
			String[] respuestasCorrectas, String[] respuestasIncorrectas) {
		this._id = _id;
		this.pregunta = pregunta;
		this.categoria = categoria;
>>>>>>> develop
		this.respuestasCorrectas = respuestasCorrectas;
		this.respuestasIncorrectas = respuestasIncorrectas;
	}

<<<<<<< HEAD

	@Override
	public String toString() {
		return "Pregunta:\n identificador:" + identificador + "\n pregunta:"
				+ pregunta + "\n respuestasCorrectas:" + imprimirLista(respuestasCorrectas)
				+ "\n respuestasIncorrectas:" + imprimirLista(respuestasIncorrectas);
	}
	
	private String imprimirLista(List<String> lista)
	{
		String cadena="";
		for(int i=0;i<lista.size();i++)
			if(i!=lista.size()-1)
				cadena+=lista.get(i)+", ";
			else
				cadena+=lista.get(i);
		return cadena;
=======
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
>>>>>>> develop
	}

}
