package es.uniovi.asw.trivial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public List<String> getRespuestas(){
		List<String> aux = respuestasCorrectas;
		
		for(String s : respuestasIncorrectas)
			aux.add(s);
		aux = desordenar(aux);
		
		
		return aux;
	}
	
	private List<String> desordenar(List<String> aux) {
		// TODO Auto-generated method stub
		
		List<String> aux2 = new ArrayList<String>();
		int i=0;
		Random r1 = new Random();
		while(i<aux.size())
		{
			String respuesta= aux.get(r1.nextInt(aux.size()));
			if(!aux2.contains(respuesta)){
				aux2.add(respuesta);
				i++;
			}
			
		}
				
		return aux2;
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
