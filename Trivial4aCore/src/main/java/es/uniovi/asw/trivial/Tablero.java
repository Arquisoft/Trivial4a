package es.uniovi.asw.trivial;

import java.util.List;

public class Tablero {
	
	//TODO a rellenar
	private int tamaño;
	private List<String> categorias;
	private List<Jugador> jugadores;
	private String[] categoriaQuesito;
	
	public Tablero(int tamaño,List<String> categorias,List<Jugador> jugadores) {
		this.categorias=categorias;
		this.tamaño = tamaño;
		this.jugadores=jugadores;
		categoriaQuesito = new String[tamaño];
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
		//TODO en cuncion del tamaño del tablero y el numero de categorias pone en cuales habra quesito
		
	}

}
