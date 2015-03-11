package es.uniovi.asw.trivial;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	
	private Tablero tablero;
	private List<Jugador> jugadores;
	private List<String> categorias;
	private List<Categoria> preguntas;
	private Jugador jugadorActivo;
	Pregunta preguntaActual;
	boolean isQuesito = false;
	
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
		isQuesito=false;
		jugar();
	}
	
	
	
	public void jugar() {
		// TODO Poner m�todos pertinentes para jugar (conseguir pregunta, responder blabla)
		
	}



	private void conseguirPregunta()
	{
		Categoria categoriaActual=null;

		
		
		categoriaActual=tablero.getCategoria(jugadorActivo);
		isQuesito = tablero.isQuesito(jugadorActivo.getPosicion());
		
		preguntaActual = conseguirPregunta(categoriaActual);
		//hasta aqu� hemos sacado la pregunta de la categoria pertinente y si vale por quesito
		mostrarPregunta(preguntaActual,isQuesito);
		
	}

	private void mostrarPregunta(Pregunta pregunta, boolean isQuesito) {
		// TODO Auto-generated method stub
		if(isQuesito)
			System.out.println("Por quesito de: "+tablero.getCategoria(jugadorActivo));
		System.out.println("Pregunta: "+pregunta.getPregunta());
	}

	private Pregunta conseguirPregunta(Categoria categoriaActual) {
		//TODO mostrar pregunta, categoria y si vale por quesito
		return null;
	}
	
	private void mostrarRespuestas()
	{
		for(String s: preguntaActual.getRespuestas())
			System.out.println(s);
	}

}
