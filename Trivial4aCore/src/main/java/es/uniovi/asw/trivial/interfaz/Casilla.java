package es.uniovi.asw.trivial.interfaz;

import javax.swing.JButton;

import es.uniovi.asw.trivial.game.Game;
import es.uniovi.asw.trivial.model.*;

@SuppressWarnings("serial")
public class Casilla extends JButton{

	private int posicion;
	private String categoria;
	private boolean ocupada;
	private Game juego;
	
	public Casilla(int posicion, Game juego, Colores colores){
		this.posicion = posicion;
		this.juego = juego;
		this.categoria = juego.getCategoryname(posicion);
		this.ocupada = false;
		this.setBackground(colores.getColor(categoria));
		this.setEnabled(false);
	}
	
	public boolean isOcupada(){
		return ocupada;
	}
	public void setOcupada(Player jugadorActual){
		if(jugadorActual.getPosicion() == this.posicion)
			ocupada = true;
	}
	public int getIndice(){
		return this.posicion;
	}
	
	public Pregunta getPregunta(){
		return juego.getQuestionSet(posicion);
	}
}
	
	
