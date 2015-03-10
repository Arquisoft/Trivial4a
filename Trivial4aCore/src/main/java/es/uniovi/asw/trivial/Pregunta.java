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
	}

}
