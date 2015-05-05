package es.uniovi.asw.componentesDeInterfaz;

import java.awt.Color;

import javax.swing.JButton;

import es.uniovi.asw.interfaz.VentanaJuego;
import es.uniovi.asw.trivial.model.*;

@SuppressWarnings("serial")
public class Casilla extends JButton{

	private int posicion;
	private String categoria;
	private boolean ocupada;
	
	public Casilla(){
		this.ocupada = false;
		this.setEnabled(false);
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	public int getPosicion(){
		return this.posicion;
	}
	
	public void setFondo(){
		if(VentanaJuego.juego.getCurrentPlayer().getPosicion() == this.posicion)
			this.setBackground(Color.WHITE);
		else
			this.setBackground(VentanaJuego.colores.getColor(categoria));
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
		return VentanaJuego.juego.getQuestionSet(posicion);
	}
	
	public void setPosicion(int index){
		this.posicion = index;
		this.categoria = VentanaJuego.juego.getCategoryname(posicion);
		setFondo();
	}
}
	
	
