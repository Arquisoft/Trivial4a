package es.uniovi.asw.trivial;

import java.util.List;

public class Tablero {
	
	//TODO a rellenar
	private int tama�o;
	private List<String> categorias;
	private List<Jugador> jugadores;
	private String[] categoriaQuesito;
	
	public Tablero(int tama�o,List<String> categorias,List<Jugador> jugadores) {
		this.categorias=categorias;
		this.tama�o = tama�o;
		this.jugadores=jugadores;
		categoriaQuesito = new String[tama�o];
		establecerCasillasQuesito();
	}
	
	public Categoria getCategoria(Jugador jugadorActivo) {
		
		return getCategoriaCasilla(jugadorActivo.getPosicion());
	}
	
	private Categoria getCategoriaCasilla(int posicion)
	{
		// TODO Elegir categoria en funcion de la casilla en la que se encuentre
		Categoria c = null;
		
		return c;
	}
	private void establecerCasillasQuesito()
	{
		//TODO en cuncion del tama�o del tablero y el numero de categorias pone en cuales habra quesito
		
	}

}
