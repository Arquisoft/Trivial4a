package es.uniovi.asw.trivial;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	
	private Tablero tablero;
	private List<Jugador> jugadores;
	private List<String> categorias;
	private List<Categoria> preguntas;
	private Jugador jugadorActivo;
	
	public Juego(int tamañoTablero, List<Jugador> jugadores,List<Categoria> preguntas)
	{
		
		this.jugadores=jugadores;
		this.preguntas=preguntas;
		categorias= new ArrayList<String>();
		
		for(Categoria c: preguntas)
			if(!categorias.contains(c.getCategoria()))
				categorias.add(c.getCategoria());
		
		jugadorActivo = jugadores.get(0);
		
		tablero = new Tablero(tamañoTablero, categorias, jugadores);
	}
	
	public boolean responderPregunta()
	{
		Categoria categoriaActual=null;
		categoriaActual=tablero.getCategoria(jugadorActivo);
		
		
		return false;
	}

}
