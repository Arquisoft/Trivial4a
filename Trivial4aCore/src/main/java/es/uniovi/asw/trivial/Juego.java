package es.uniovi.asw.trivial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {
	
	private Tablero tablero;
	private List<Jugador> jugadores;
	private List<String> categorias;
	private List<Categoria> preguntas;
	private Jugador jugadorActivo;
	Pregunta preguntaActual;
	
	
	public Juego(int tamanioTablero, List<Jugador> jugadores,List<Categoria> preguntas)
	{
		
		this.jugadores=jugadores;
		this.preguntas=preguntas;
		categorias= new ArrayList<String>();
		
		for(Categoria c: preguntas)
			if(!categorias.contains(c.getCategoria()))
				categorias.add(c.getCategoria());
		
		jugadorActivo = jugadores.get(0);
		
		tablero = new Tablero(tamanioTablero, categorias, jugadores);
		
		preguntaActual=null;
		
		jugar();
	}
	
	
	
	public void jugar() {
		// TODO Poner m�todos pertinentes para jugar (conseguir pregunta, responder blabla)
		preguntaActual = conseguirPregunta();
				
		List<String> respuestas = mostrarPregunta(preguntaActual);
		
		if(isCorrecta(respuestas))
		{
			
		}
		
	}



	private boolean isCorrecta(List<String> respuestas) {
		// TODO Auto-generated method stub
		return false;
	}



	private Pregunta conseguirPregunta()
	{
		Categoria categoriaActual=null;

		
		
		categoriaActual=tablero.getCategoria(jugadorActivo);
		
		
		return conseguirPregunta(categoriaActual);
		
	}

	private List<String> mostrarPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		if(tablero.isQuesito(jugadorActivo.getPosicion()))
			System.out.println("Por quesito de: "+tablero.getCategoria(jugadorActivo));
		System.out.println("Pregunta: "+pregunta.getPregunta());
		
		return mostrarRespuestas();
	}

	private Pregunta conseguirPregunta(Categoria categoriaActual) {
		
		Random r1 = new Random();
		
		return filtrarPreguntas(categoriaActual).get(r1.nextInt(filtrarPreguntas(categoriaActual).size()));
	}
	
	private List<Pregunta> filtrarPreguntas(Categoria categoriaActual){
		List<Pregunta> preguntasC = new ArrayList<Pregunta>();
		
		for(Categoria p : preguntas)
			if(p.getCategoria().equals(categoriaActual))
				preguntasC.addAll(p.getPreguntas());
		
		return preguntasC;
	}
	
	private List<String> mostrarRespuestas()
	{
		for(String s: preguntaActual.getRespuestas())
			System.out.println(s);
		
		return respuesta();
	}



	private List<String> respuesta() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
