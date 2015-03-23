package es.uniovi.asw.trivial.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

import es.uniovi.asw.trivial.game.Game;
import es.uniovi.asw.trivial.model.*;

@SuppressWarnings("serial")
public class Casilla extends JButton{

	private int posicion;
	private String categoria;
	private boolean ocupada;
	private Game juego;
	
	public Casilla(int posicion, Colores colores){
		this.posicion = posicion;
		
		//Se usa para hacer pruebas
		this.categoria = pruebaAleaotiraCategoria();
		
		//Esto es el codigo que debera estar
		//this.categoria = juego.getCategoryname(posicion);
		this.ocupada = false;
		setFondo(colores);
		this.setEnabled(false);
	}
	
	/*
	 * Este metodo se usa para hacer pruebas
	 */
	private String pruebaAleaotiraCategoria(){
		Random r = new Random();
		int i = r.nextInt(VentanaJuego.pruebaCategorias.length);
		return VentanaJuego.pruebaCategorias[i];
	}
	
	public void setFondo(Colores colores){
		//Esto se usa para hacer pruebas
		this.setBackground(colores.getColor(categoria));
		
		//Esto es el codigo que debera estar
		/*
		if(VentanaJuego.juego.getCurrentPlayer().getPosicion() == this.posicion)
			this.setBackground(Color.WHITE);
		else
			this.setBackground(colores.getColor(categoria));*/
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
	
	public void setPosicion(int index){
		this.posicion = index;
	}
}
	
	
