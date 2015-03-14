package es.uniovi.asw.trivial;

import java.util.List;

public class Tablero {
	
	//TODO a rellenar
	private List<String> categorias;
	private List<Jugador> jugadores;
	private String[] categoriaQuesito;
	private String[] tablero;
	
	public Tablero(int tamanio,List<String> categorias,List<Jugador> jugadores) {
		this.categorias=categorias;
		this.jugadores=jugadores;
		tablero = new String[tamanio];
		rellenarTablero();
		categoriaQuesito = new String[tamanio];
		establecerCasillasQuesito();
	}
	
	private void rellenarTablero() {
		// TODO Auto-generated method stub
		for(int i=0;i<tablero.length;i++)
			tablero[i]=categorias.get(i%categorias.size());
	}

	public String getCategoria(Jugador jugadorActivo) {
		
		return getCategoriaCasilla(jugadorActivo.getPosicion());
	}
	
	private String getCategoriaCasilla(int posicion)
	{
		return tablero[posicion];
	}
	private void establecerCasillasQuesito()
	{
		//TODO en cuncion del tama�o del tablero y el numero de categorias pone en cuales habra quesito
		int aux = tablero.length/categorias.size();
		int j=0;
		for(int i=1;i<=tablero.length;i+=aux){
			categoriaQuesito[i-1] = categorias.get(j);
			j++;
		}
		
	}
	public boolean isQuesito(int posicion)
	{
		return categoriaQuesito[posicion]!=""? true : false;
	}

}
